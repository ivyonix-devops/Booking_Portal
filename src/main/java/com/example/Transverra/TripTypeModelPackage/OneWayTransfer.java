package com.example.Transverra.TripTypeModelPackage;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.UserPackeges.UserModel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "oneway_transfer")
public class OneWayTransfer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "oneway_id")
    private Long oneWayId;
    @Column (name="oneway_date")
    private LocalDate oneWayDate;
    @Column (name="pickup_time")
    private LocalTime oneWayPickupTime;
    @Column (name="pickup_location")
    private String  oneWayPickUp;
    @Column (name="dropoff_location")
    private String oneWayDropOff;
    @Column (name="travellers_count")
    private Integer oneWayTravellersCount;
    @Column (name="vehicle_type")
    private String oneWayVehicleType;;
    @Column (name="special_request")
    private String oneWaySpecialReq;


    @ManyToOne
    @JoinColumn (name="trip_id", nullable = false)
    private TripModel tripId;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserModel userId;

    public Long getOneWayId() {
        return oneWayId;
    }

    public void setOneWayId(Long oneWayId) {
        this.oneWayId = oneWayId;
    }

    public LocalDate getOneWayDate() {
        return oneWayDate;
    }

    public void setOneWayDate(LocalDate oneWayDate) {
        this.oneWayDate = oneWayDate;
    }

    public LocalTime getOneWayPickupTime() {
        return oneWayPickupTime;
    }

    public void setOneWayPickupTime(LocalTime oneWayPickupTime) {
        this.oneWayPickupTime = oneWayPickupTime;
    }

    public String getOneWayPickUp() {
        return oneWayPickUp;
    }

    public void setOneWayPickUp(String oneWayPickUp) {
        this.oneWayPickUp = oneWayPickUp;
    }

    public String getOneWayDropOff() {
        return oneWayDropOff;
    }

    public void setOneWayDropOff(String oneWayDropOff) {
        this.oneWayDropOff = oneWayDropOff;
    }

    public Integer getOneWayTravellersCount() {
        return oneWayTravellersCount;
    }

    public void setOneWayTravellersCount(Integer oneWayTravellersCount) {
        this.oneWayTravellersCount = oneWayTravellersCount;
    }

    public String getOneWayVehicleType() {
        return oneWayVehicleType;
    }

    public void setOneWayVehicleType(String oneWayVehicleType) {
        this.oneWayVehicleType = oneWayVehicleType;
    }

    public String getOneWaySpecialReq() {
        return oneWaySpecialReq;
    }

    public void setOneWaySpecialReq(String oneWaySpecialReq) {
        this.oneWaySpecialReq = oneWaySpecialReq;
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
