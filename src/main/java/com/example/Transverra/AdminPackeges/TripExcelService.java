package com.example.Transverra.AdminPackeges;

import com.example.Transverra.TripTypeDTOs.TripDetailsViewDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class TripExcelService {
    public ByteArrayInputStream exportTrips(List<TripDetailsViewDTO> trips) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Trip Details");

        // Header row
        Row headerRow = sheet.createRow(0);

        String[] headers = {
                "Trip ID",
                "Trip Type",
                "Status",
                "User Name",
                "User Email",
                "User Mobile",
                "Pickup Location",
                "Drop Location",
                "Pickup Date",
                "Travellers Count"
        };

        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }
//co-s
        // Data rows
        int rowNum = 1;
        for (TripDetailsViewDTO trip : trips) {

            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(trip.getTripId());
            row.createCell(1).setCellValue(trip.getTripType().name());
            row.createCell(2).setCellValue(trip.getStatus().name());
            row.createCell(3).setCellValue(trip.getName());
            row.createCell(4).setCellValue(trip.getMail());
            row.createCell(5).setCellValue(trip.getMobile());
            row.createCell(6).setCellValue(trip.getPickupLocation());
            row.createCell(7).setCellValue(trip.getDropLocation());

            if (trip.getPickUpDate() != null) {
                row.createCell(8).setCellValue(trip.getPickUpDate().toString());
            } else {
                row.createCell(8).setCellValue("");
            }

            // travellersCount getter is null-safe and returns 0 when underlying value is null
            row.createCell(9).setCellValue(trip.getTravellersCount());
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
//    co-end
}
