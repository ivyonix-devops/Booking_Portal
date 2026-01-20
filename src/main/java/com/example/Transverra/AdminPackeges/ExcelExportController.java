package com.example.Transverra.AdminPackeges;

import com.example.Transverra.TripTypeDTOs.TripDetailsViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ExcelExportController {

    @Autowired AdminService adminService;
    @Autowired TripExcelService tripExcelService;

@GetMapping("/admin/export-details")
public ResponseEntity<InputStreamResource> exportTripsExcel() {

    List<TripDetailsViewDTO> tripList =
            adminService.getAllTripsForAdmin();

    ByteArrayInputStream excelFile =
            tripExcelService.exportTrips(tripList);

//    DUBAI STANDARD TIME
    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");

    ZonedDateTime dubaiTime =
            ZonedDateTime.now(ZoneId.of("Asia/Dubai"));

    String currentDateTime =
            dubaiTime.format(formatter);

    String fileName =
            "trip_details." + currentDateTime + ".xlsx";

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition",
            "attachment; filename=" + fileName);

    return ResponseEntity.ok()
            .headers(headers)
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(new InputStreamResource(excelFile));
}

}
