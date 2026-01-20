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
@Table (name="air_departure")
public class AirportDeparture {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)


    @Column (name="departure_id")
    private Long deprtrId;
    @Column (name="departure_date")
    private LocalDate DepartDate;
    @Column (name="pickup_time")
    private LocalTime departPickupTime;
    @Column (name="pickup_location")
    private String departPickUp;
    @Column (name="airport_name")
    private String departAirportName;
    @Column (name="flight_no")
    private String departFlightNo;
    @Column (name="terminal")
    private String departTerminal;
    @Column (name="travellers_count")
    private Integer departTravellersCount;
    @Column (name="vehicle_type")
    private String departVehicleType;

    @ManyToOne
    @JoinColumn (name="trip_id", nullable = false)
    private TripModel tripId;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserModel userId;


    public Long getDeprtrId() {
        return deprtrId;
    }

    public void setDeprtrId(Long deprtrId) {
        this.deprtrId = deprtrId;
    }

    public LocalDate getDepartDate() {
        return DepartDate;
    }

    public void setDepartDate(LocalDate departDate) {
        DepartDate = departDate;
    }

    public LocalTime getDepartPickupTime() {
        return departPickupTime;
    }

    public void setDepartPickupTime(LocalTime departPickupTime) {
        this.departPickupTime = departPickupTime;
    }

    public String getDepartPickUp() {
        return departPickUp;
    }

    public void setDepartPickUp(String departPickUp) {
        this.departPickUp = departPickUp;
    }

    public String getDepartAirportName() {
        return departAirportName;
    }

    public void setDepartAirportName(String departAirportName) {
        this.departAirportName = departAirportName;
    }

    public String getDepartFlightNo() {
        return departFlightNo;
    }

    public void setDepartFlightNo(String departFlightNo) {
        this.departFlightNo = departFlightNo;
    }

    public String getDepartTerminal() {
        return departTerminal;
    }

    public void setDepartTerminal(String departTerminal) {
        this.departTerminal = departTerminal;
    }

    public Integer getDepartTravellersCount() {
        return departTravellersCount;
    }

    public void setDepartTravellersCount(Integer departTravellersCount) {
        this.departTravellersCount = departTravellersCount;
    }

    public String getDepartVehicleType() {
        return departVehicleType;
    }

    public void setDepartVehicleType(String departVehicleType) {
        this.departVehicleType = departVehicleType;
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
