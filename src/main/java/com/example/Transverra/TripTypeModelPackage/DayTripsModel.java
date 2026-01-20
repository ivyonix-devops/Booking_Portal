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
@Table (name="daytrips")
public class DayTripsModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name="daytrip_id")
    private Long dayTripId;
    @Column (name="pickup_location")
    private String dayTripickUp;
    @Column (name="daytrip_date")
    private LocalDate dayTripDate;
    @Column (name="start_time")
    private LocalTime startTime;
    @Column (name="end_time")
    private LocalTime endTime;
    @Column (name="vehicle_type")
    private String dayTripVehicleType;
    @Column (name="travellers_count")
    private Integer dayTripTravellersCount;
    private String itinerary;


    @ManyToOne
    @JoinColumn (name="trip_id", nullable = false)
    private TripModel tripId;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserModel userId;


    public Long getDayTripId() {
        return dayTripId;
    }

    public void setDayTripId(Long dayTripId) {
        this.dayTripId = dayTripId;
    }

    public String getDayTripickUp() {
        return dayTripickUp;
    }

    public void setDayTripickUp(String dayTripickUp) {
        this.dayTripickUp = dayTripickUp;
    }

    public LocalDate getDayTripDate() {
        return dayTripDate;
    }

    public void setDayTripDate(LocalDate dayTripDate) {
        this.dayTripDate = dayTripDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getDayTripVehicleType() {
        return dayTripVehicleType;
    }

    public void setDayTripVehicleType(String dayTripVehicleType) {
        this.dayTripVehicleType = dayTripVehicleType;
    }

    public Integer getDayTripTravellersCount() {
        return dayTripTravellersCount;
    }

    public void setDayTripTravellersCount(Integer dayTripTravellersCount) {
        this.dayTripTravellersCount = dayTripTravellersCount;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
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
