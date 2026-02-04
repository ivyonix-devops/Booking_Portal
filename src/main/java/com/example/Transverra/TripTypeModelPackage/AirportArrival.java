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
@Table (name="air_arrival")
public class AirportArrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "arrive_id")
    private Long arrivalId;
    @Column (name="arrival_date")
    private LocalDate arrivalDate;
    @Column (name="arrival_time")
    private LocalTime arrivalTime;
    @Column (name="airport_name")
    private String arriveAirportName;
    @Column (name="flight_no")
    private String arriveFlightNo;
    @Column (name="terminal")
    private String arriveTerminal;
    @Column (name="dropoff_location")
    private String arriveDropOff;
    @Column (name="travellers_count")
    private Integer arriveTravellersCount;
    @Column (name="vehicle_type")
    private String arriveVehicleType;

//    @ManyToOne
    @OneToOne
    @JoinColumn(name="trip_id",nullable = false )
    private TripModel tripId;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserModel userId;



    public Long getArrivalId() {
        return arrivalId;
    }

    public void setArrivalId(Long arrivalId) {
        this.arrivalId = arrivalId;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArriveAirportName() {
        return arriveAirportName;
    }

    public void setArriveAirportName(String arriveAirportName) {
        this.arriveAirportName = arriveAirportName;
    }

    public String getArriveFlightNo() {
        return arriveFlightNo;
    }

    public void setArriveFlightNo(String arriveFlightNo) {
        this.arriveFlightNo = arriveFlightNo;
    }

    public String getArriveTerminal() {
        return arriveTerminal;
    }

    public void setArriveTerminal(String arrivalTerminal) {
        this.arriveTerminal = arrivalTerminal;
    }

    public String getArriveDropOff() {
        return arriveDropOff;
    }

    public void setArriveDropOff(String arriveDropOff) {
        this.arriveDropOff = arriveDropOff;
    }

    public Integer getArriveTravellersCount() {
        return arriveTravellersCount;
    }

    public void setArriveTravellersCount(Integer arriveTravellersCount) {
        this.arriveTravellersCount = arriveTravellersCount;
    }

    public String getArriveVehicleType() {
        return arriveVehicleType;
    }

    public void setArriveVehicleType(String arriveVehicleType) {
        this.arriveVehicleType = arriveVehicleType;
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
