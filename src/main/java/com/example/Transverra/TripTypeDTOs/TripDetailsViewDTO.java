package com.example.Transverra.TripTypeDTOs;

import com.example.Transverra.TripDetailsPackage.Status;
import com.example.Transverra.TripDetailsPackage.TripTypesEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TripDetailsViewDTO {

    // Trip details
    private Long tripId;
    private TripTypesEnum tripType;    // ONEWAY, RETURN, ARRIVAL...
//    private LocalDate requestDate;
    private Status status;

    // User details
    private String name;
    private String mail;
    private String mobile;

    // Optional common fields
    private String pickupLocation;
    private String dropLocation;
    private LocalDate pickUpDate;
//    private LocalTime time;
    private Integer travellersCount;

    private BigDecimal tripRate;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public TripTypesEnum getTripType() {
        return tripType;
    }

    public void setTripType(TripTypesEnum tripType) {
        this.tripType = tripType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }


    // Null-safe getter: returns primitive int with default 0 to avoid NPE when callers do .intValue() or unbox it
    public int getTravellersCount() {
        return travellersCount != null ? travellersCount : 0;
    }

    public void setTravellersCount(Integer travellersCount) {
        this.travellersCount = travellersCount;
    }

    public BigDecimal  getTripRate() {
        return tripRate;
    }

    public void setTripRate(BigDecimal  tripRate) {
        this.tripRate = tripRate;
    }
}
