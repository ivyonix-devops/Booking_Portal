package com.example.Transverra.TripTypeDTOs;

import com.example.Transverra.TripDetailsPackage.TripTypesEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class BookingRequestDTO {


        // ----------- USER -------------
        private String username;
        private String email;
        private String phoneNo;

        // ----------- TRIP COMMON -------------
        private TripTypesEnum tripType;
        private LocalDate tripReqDate;
        private BigDecimal tripRate;

        // ----------- ONE WAY -------------
        private LocalDate oneWayDate;
        private LocalTime oneWayPickupTime;
        private String oneWayPickUp;
        private String oneWayDropOff;
        private Integer oneWayTravellersCount = 1;
        private String oneWayVehicleType;
        private String oneWaySpecialReq;

        // ----------- RETURN TRANSFER -------------
        private LocalDate returnDate;
        private LocalTime retPickUpTime;
        private String returnPickUp;
        private String returnDropOff;
        private String returnPickUpLocation;
        private LocalTime returnTime;
        private Integer returnTravellersCount = 1;
        private String returnVehicleType;
        private String returnSpecialReq;

        // ----------- AIRPORT ARRIVAL -------------
        private LocalDate arrivalDate;
        private LocalTime arrivalTime;
        private String arriveAirportName;
        private String arriveFlightNo;
        private String arriveTerminal;
        private String arriveDropOff;
        private Integer arriveTravellersCount = 1;
        private String arriveVehicleType;

        // ----------- AIRPORT DEPARTURE -------------
        private LocalDate departDate;
        private LocalTime departPickupTime;
        private String departPickUp;
        private String departAirportName;
        private String departFlightNo;
        private String departTerminal;
        private Integer departTravellersCount = 1;
        private String departVehicleType;

        // ----------- DAY TRIPS -------------
        private LocalDate dayTripDate;
        private String dayTripType;
        private String dayTripPickUp;
        private LocalTime startTime;
        private LocalTime endTime;
        private String itinerary;
        private Integer dayTripTravellersCount = 1;
        private String dayTripVehicleType;

        // -- USER --getters---setters--------
        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhoneNo() {
                return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
                this.phoneNo = phoneNo;
        }


        // -- TRIP TABLE --getters---setters--------

        public TripTypesEnum getTripType() {
                return tripType;
        }

        public void setTripType(TripTypesEnum tripType) {
                this.tripType = tripType;
        }

        public LocalDate getTripReqDate() {
                return tripReqDate;
        }

        public BigDecimal getTripRate() {
                return tripRate;
        }

        public void setTripRate(BigDecimal tripRate) {
                this.tripRate = tripRate;
        }

        public void setTripReqDate(LocalDate tripReqDate) {
                this.tripReqDate = tripReqDate;
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

        // -- RETURN TRANSFER --getters---setters--------

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

        public String getReturnPickUp() {
                return returnPickUp;
        }

        public void setReturnPickUp(String returnPickUp) {
                this.returnPickUp = returnPickUp;
        }

        public String getReturnDropOff() {
                return returnDropOff;
        }

        public void setReturnDropOff(String returnDropOff) {
                this.returnDropOff = returnDropOff;
        }

        public String getReturnPickUpLocation() {
                return returnPickUpLocation;
        }

        public void setReturnPickUpLocation(String returnPickUpLocation) {
                this.returnPickUpLocation = returnPickUpLocation;
        }

        public LocalTime getReturnTime() {
                return returnTime;
        }

        public void setReturnTime(LocalTime returnTime) {
                this.returnTime = returnTime;
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

        // -- AIRPORT PICKUP --getters---setters--------

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

        public void setArriveTerminal(String arriveTerminal) {
                this.arriveTerminal = arriveTerminal;
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

        // -- AIRPORT DEPARTURE --getters---setters--------

        public LocalDate getDepartDate() {
                return departDate;
        }

        public void setDepartDate(LocalDate departDate) {
                this.departDate = departDate;
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

        // -- DAYTRIPS --getters---setters-------

        public LocalDate getDayTripDate() {
                return dayTripDate;
        }

        public void setDayTripDate(LocalDate dayTripDate) {
                this.dayTripDate = dayTripDate;
        }

        public String getDayTripType() {
                return dayTripType;
        }

        public void setDayTripType(String dayTripType) {
                this.dayTripType = dayTripType;
        }

        public String getDayTripPickUp() {
                return dayTripPickUp;
        }

        public void setDayTripPickUp(String dayTripPickUp) {
                this.dayTripPickUp = dayTripPickUp;
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

        public String getItinerary() {
                return itinerary;
        }

        public void setItinerary(String itinerary) {
                this.itinerary = itinerary;
        }

        public Integer getDayTripTravellersCount() {
                return dayTripTravellersCount;
        }

        public void setDayTripTravellersCount(Integer dayTripTravellersCount) {
                this.dayTripTravellersCount = dayTripTravellersCount;
        }

        public String getDayTripVehicleType() {
                return dayTripVehicleType;
        }

        public void setDayTripVehicleType(String dayTripVehicleType) {
                this.dayTripVehicleType = dayTripVehicleType;
        }
}



