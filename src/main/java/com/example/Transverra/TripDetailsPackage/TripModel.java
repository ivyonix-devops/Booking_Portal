package com.example.Transverra.TripDetailsPackage;

import com.example.Transverra.TripTypeModelPackage.*;
import com.example.Transverra.UserPackeges.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="trip_details")
@NoArgsConstructor
public class TripModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


//Trip details
    @Column (name="trip_id")
    private Long tripId;
    @Enumerated(EnumType.STRING)  // stores enum name by default
    @Column(name = "trip_type", length = 5)
    private TripTypesEnum tripType;
    @Column (name="trip_requestdate")
    private LocalDate tripReqDate;
    @Column (name="trip_rate",precision = 10, scale = 2)
    private BigDecimal tripRate;
    @Enumerated(EnumType.STRING)
    private Status status;


    @ManyToOne
    @JoinColumn(name = "user_id")   // Foreign Key in trip_details table
    private UserModel user;

    @OneToMany(mappedBy = "tripId", cascade = CascadeType.ALL)
    private List<DayTripsModel> dayTrips;

//    to child of trips - connection to delete

    // -------- ONE WAY --------
    @OneToOne(mappedBy = "tripId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private OneWayTransfer oneWayTransfer;

    // -------- RETURN --------
    @OneToOne(mappedBy = "tripId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ReturnTransfer returnTransfer;

    // -------- AIRPORT ARRIVAL --------
    @OneToOne(mappedBy = "tripId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private AirportArrival airportArrival;

    // -------- AIRPORT DEPARTURE --------
    @OneToOne(mappedBy = "tripId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private AirportDeparture airportDeparture;


    public Long getTripId(){
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

    public LocalDate getTripReqDate() {
        return tripReqDate;
    }
    public void setTripReqDate(LocalDate tripReqDate) {
        this.tripReqDate = tripReqDate;
    }


    public BigDecimal  getTripRate() {
        return tripRate;
    }

    public void setTripRate(BigDecimal tripRate) {
        this.tripRate = tripRate;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<DayTripsModel> getDayTrips() {
        return dayTrips;
    }

    public void setDayTrips(List<DayTripsModel> dayTrips) {
        this.dayTrips = dayTrips;
    }

    public OneWayTransfer getOneWayTransfer() {
        return oneWayTransfer;
    }

    public void setOneWayTransfer(OneWayTransfer oneWayTransfer) {
        this.oneWayTransfer = oneWayTransfer;
    }

    public ReturnTransfer getReturnTransfer() {
        return returnTransfer;
    }

    public void setReturnTransfer(ReturnTransfer returnTransfer) {
        this.returnTransfer = returnTransfer;
    }

    public AirportArrival getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(AirportArrival airportArrival) {
        this.airportArrival = airportArrival;
    }

    public AirportDeparture getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(AirportDeparture airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

}