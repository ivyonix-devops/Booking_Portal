package com.example.Transverra.TripTypeModelPackage;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.UserPackeges.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table (name = "return_transfer")
public class ReturnTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name="return_id")
    private Long returnId;
    @Column (name="return_date")
    private LocalDate returnDate;
    @Column (name="pickup_time")
    private LocalTime retPickUpTime;
    @Column (name="pickup_location")
    private String returnPickUp;
    @Column (name="dropoff_location")
    private String returnDropOff;
    @Column (name="return_pickup_location")
    private String returnPickUpLocation;
    @Column (name="return_time")
    private LocalTime returnTime;
    @Column (name="travellers_count")
    private Integer returnTravellersCount;
    @Column (name="vehicle_type")
    private String returnVehicleType;
    @Column (name="special_request")
    private String returnSpecialReq;

//    @ManyToOne
    @OneToOne
    @JoinColumn (name="trip_id", nullable = false)
    private TripModel tripId;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserModel userId;



    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalTime getRetPickUpTime() {
        return retPickUpTime;
    }

    public void setRetPickUpTime(LocalTime retPickUpTime) {
        this.retPickUpTime = retPickUpTime;
    }

    public String getReturnDropOff() {
        return returnDropOff;
    }

    public String getReturnPickUp() {
        return returnPickUp;
    }

    public void setReturnPickUp(String returnPickUp) {
        this.returnPickUp = returnPickUp;
    }

    public String getReturnPickUpLocation() {
        return returnPickUpLocation;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    public void setReturnPickUpLocation(String returnPickUpLocation) {
        this.returnPickUpLocation = returnPickUpLocation;
    }

    public void setReturnDropOff(String returnDropOff) {
        this.returnDropOff = returnDropOff;
    }

    public Integer getReturnTravellersCount() {
        return returnTravellersCount;
    }

    public void setReturnTravellersCount(Integer returnTravellersCount) {
        this.returnTravellersCount = returnTravellersCount;
    }

    public String getReturnVehicleType() {
        return returnVehicleType;
    }

    public void setReturnVehicleType(String returnVehicleType) {
        this.returnVehicleType = returnVehicleType;
    }

    public String getReturnSpecialReq() {
        return returnSpecialReq;
    }

    public void setReturnSpecialReq(String returnSpecialReq) {
        this.returnSpecialReq = returnSpecialReq;
    }

    public TripModel getTripId() {
        return tripId;
    }

    public void setTripId(TripModel tripId) {
        this.tripId = tripId;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
}
