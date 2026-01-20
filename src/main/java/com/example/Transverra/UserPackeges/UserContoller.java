package com.example.Transverra.UserPackeges;

import com.example.Transverra.TripDetailsPackage.*;
import com.example.Transverra.TripTypeDTOs.BookingRequestDTO;
import com.example.Transverra.TripTypeModelPackage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class UserContoller {
    @Autowired private UserService userService;
    @Autowired private TripService tripService;
    @Autowired private MasterTripService masterTripService;



    @GetMapping("/home")
    public String BookingReq(Model model){
        model.addAttribute("bookingform",new BookingRequestDTO());

        // Vehicle types dropdown (used by all trip types)
        model.addAttribute("vehicleTypes", VehicleTypeEnum.values());
        return "UserHome";
    }
    @GetMapping("/trip/rate")
    @ResponseBody
    public BigDecimal getTripRate(@RequestParam TripTypesEnum tripType) {
        return masterTripService.getRateByTripType(tripType);
    }


    @PostMapping("/home")
    public String saveUserDetails(@ModelAttribute("bookingform") BookingRequestDTO dto,
                                  RedirectAttributes redirectAttributes) {
//        co-s
        // process booking and persist
        processBooking(dto);

        redirectAttributes.addFlashAttribute("successMessage",
                "Booking completed successfully!");

        return "redirect:/home";
    }

    // AJAX endpoint: same path but only handles requests with X-Requested-With=XMLHttpRequest
    @PostMapping(value = "/home", headers = "X-Requested-With=XMLHttpRequest")
    @ResponseBody
    public String saveUserDetailsAjax(@ModelAttribute("bookingform") BookingRequestDTO dto) {
        processBooking(dto);
        // respond with simple text that frontend expects
        return "SUCCESS";
    }

    // helper extracted from POST handler to avoid duplication
    private void processBooking(BookingRequestDTO dto) {
//        co-end
        // Create a new user model and fill details from DTO
        UserModel user = new UserModel();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhoneNo(dto.getPhoneNo());

        // Save user
        userService.saveUserBookRequest(user);


        //Save Trip Details
        TripModel trip = new TripModel();
        trip.setTripReqDate(dto.getTripReqDate());
        trip.setTripType(dto.getTripType());
        // Backend calculation (FINAL authority)
        BigDecimal rate = masterTripService.getRateByTripType(dto.getTripType());
        trip.setTripRate(rate);
        trip.setStatus(Status.PENDING);
        trip.setUser(user); // Link to user
        tripService.saveTrip(trip);

        // Save trip-type specific details
        if (dto.getTripType() == TripTypesEnum.OWT) {
            OneWayTransfer oneWay = new OneWayTransfer();
            oneWay.setOneWayDate(dto.getOneWayDate());
            oneWay.setOneWayPickupTime(dto.getOneWayPickupTime());
            oneWay.setOneWayPickUp(dto.getOneWayPickUp());
            oneWay.setOneWayDropOff(dto.getOneWayDropOff());
            oneWay.setOneWayTravellersCount(dto.getOneWayTravellersCount());
            oneWay.setOneWayVehicleType(dto.getOneWayVehicleType());
            oneWay.setOneWaySpecialReq(dto.getOneWaySpecialReq());
            oneWay.setTripId(trip); //
            oneWay.setUserId(user); // Link to trip
            tripService.saveOneWay(oneWay);

        } else if (dto.getTripType() == TripTypesEnum.RT) {
            ReturnTransfer ret = new ReturnTransfer();
            ret.setReturnDate(dto.getReturnDate());
            ret.setRetPickUpTime(dto.getRetPickUpTime());
            ret.setReturnPickUp(dto.getReturnPickUp());
            ret.setReturnDropOff(dto.getReturnDropOff());
            ret.setReturnPickUpLocation(dto.getReturnPickUpLocation());
            ret.setReturnTime(dto.getReturnTime());
            ret.setReturnTravellersCount(dto.getReturnTravellersCount());
            ret.setReturnVehicleType(dto.getReturnVehicleType());
            ret.setReturnSpecialReq(dto.getReturnSpecialReq());
            ret.setTripId(trip);
            ret.setUserId(user);
            tripService.saveReturnTransfer(ret);

        } else if (dto.getTripType() == TripTypesEnum.AA) {
            AirportArrival arrival = new AirportArrival();
            arrival.setArrivalDate(dto.getArrivalDate());
            arrival.setArrivalTime(dto.getArrivalTime());
            arrival.setArriveAirportName(dto.getArriveAirportName());
            arrival.setArriveFlightNo(dto.getArriveFlightNo());
            arrival.setArriveTerminal(dto.getArriveTerminal());
            arrival.setArriveDropOff(dto.getArriveDropOff());
            arrival.setArriveTravellersCount(dto.getArriveTravellersCount());
            arrival.setArriveVehicleType(dto.getArriveVehicleType());
            arrival.setTripId(trip);
            arrival.setUserId(user);
            tripService.saveAirportArrival(arrival);

        } else if (dto.getTripType() == TripTypesEnum.AD) {
            AirportDeparture depart = new AirportDeparture();
            depart.setDepartDate(dto.getDepartDate());
            depart.setDepartPickupTime(dto.getDepartPickupTime());
            depart.setDepartPickUp(dto.getDepartPickUp());
            depart.setDepartAirportName(dto.getDepartAirportName());
            depart.setDepartFlightNo(dto.getDepartFlightNo());
            depart.setDepartTerminal(dto.getDepartTerminal());
            depart.setDepartTravellersCount(dto.getDepartTravellersCount());
            depart.setDepartVehicleType(dto.getDepartVehicleType());
            depart.setTripId(trip);
            depart.setUserId(user);
            tripService.saveDepartureDetails(depart);

        } else if (dto.getTripType() == TripTypesEnum.HS ||
                dto.getTripType() == TripTypesEnum.FS ||
                dto.getTripType() == TripTypesEnum.H24) {
            DayTripsModel daytrip = new DayTripsModel();
            daytrip.setDayTripDate(dto.getDayTripDate());
            daytrip.setStartTime(dto.getStartTime());
            daytrip.setEndTime(dto.getEndTime());
            daytrip.setDayTripTravellersCount(dto.getDayTripTravellersCount());
            daytrip.setDayTripVehicleType(dto.getDayTripVehicleType());
            daytrip.setDayTripickUp(dto.getDayTripPickUp());
            daytrip.setItinerary(dto.getItinerary());
            daytrip.setTripId(trip);
            daytrip.setUserId(user);
            tripService.saveDayTripDetails(daytrip);
        } else {
            throw new IllegalArgumentException("Invalid Trip Type! received: " + dto.getTripType());
        }
    }

    @GetMapping("/about")
    public String about(){
        return "UserAbout";
    }
    @GetMapping("/service")
    public String service(){
        return "UserServices";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page", "contact");
        return "UserContact";
    }
    @GetMapping ("/header")
    public String Header(){
        return "UserHeader";
    }
    @GetMapping ("/footer")
    public String FooterPage(){
        return "UserFooter";
    }
}
