package com.example.Transverra.AdminPackeges;

import com.example.Transverra.TripDetailsPackage.Status;
import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.TripDetailsPackage.TripRepository;
import com.example.Transverra.TripTypeDTOs.TripDetailsViewDTO;
import com.example.Transverra.TripTypeModelPackage.*;
import com.example.Transverra.TripTypeRepositoryPackage.*;
import com.example.Transverra.UserPackeges.UserModel;
import com.example.Transverra.UserPackeges.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private OneWayRepository oneWayRepository;
    @Autowired
    private ReturntransferRepository returntransferRepository;
    @Autowired
    private AirportArrivalRepository arrivalRepository;
    @Autowired
    private AirportDepartureRepository departureRepository;
    @Autowired
    private DayTripRepository dayTripRepository;


    public AdminModel findAdminByName(String admName) {
        return adminRepository.findByAdmName(admName);
    }

/// fetching all details view in admin page
    public List<TripDetailsViewDTO> getAllTripsForAdmin() {

        List<TripModel> trips = (List<TripModel>) tripRepository.findAll();
        List<TripDetailsViewDTO> dtos = new ArrayList<>();

        for (TripModel trip : trips) {

            TripDetailsViewDTO dto = new TripDetailsViewDTO();

            // 1️⃣ User data
            dto.setName(trip.getUser().getUsername());
            dto.setMail(trip.getUser().getEmail());
            dto.setMobile(trip.getUser().getPhoneNo());

            // 2️⃣ Basic trip info
            dto.setTripId(trip.getTripId());
            dto.setTripType(trip.getTripType());
            dto.setStatus(trip.getStatus());
            dto.setTripRate(trip.getTripRate());

            Integer travellersCount = null;
            // 3️⃣ Fetch trip-type specific details
            switch (trip.getTripType()) {

                // ----------------- 1 ONE WAY TRANSFER -----------------
                case OWT:
                    List<OneWayTransfer> oneWays = oneWayRepository.findByTripId_TripId(trip.getTripId());
                    if (!oneWays.isEmpty())
                    {
                        OneWayTransfer o = oneWays.get(0); // take latest or loop
                        dto.setPickupLocation(o.getOneWayPickUp());
                        dto.setDropLocation(o.getOneWayDropOff());
                        dto.setPickUpDate(o.getOneWayDate());
                        dto.setTravellersCount(o.getOneWayTravellersCount());
                    }
                    break;


                // ----------------- 2 RETURN TRANSFER -----------------
                case RT:
                    List<ReturnTransfer> returns = returntransferRepository.findBytripId_TripId(trip.getTripId());
                    if (!returns.isEmpty()) {
                        ReturnTransfer r = returns.get(0);
                        dto.setPickupLocation(r.getReturnPickUp());
                        dto.setDropLocation(r.getReturnDropOff());
                        dto.setPickUpDate(r.getReturnDate());
                        dto.setTravellersCount(r.getReturnTravellersCount());
                    }
                    break;


                // ----------------- 3 AIRPORT ARRIVAL -----------------
                case AA:
                    List<AirportArrival> arrivals = arrivalRepository.findByTripId_TripId(trip.getTripId());
                    if (!arrivals.isEmpty()) {
                        AirportArrival a = arrivals.get(0);
                        dto.setPickUpDate(a.getArrivalDate());
                        dto.setPickupLocation(a.getArriveAirportName());
                        dto.setDropLocation(a.getArriveDropOff());
                        dto.setTravellersCount(a.getArriveTravellersCount());
                    }
                    break;


                // ----------------- 4️ AIRPORT DEPARTURE -----------------
                case AD:
                    List<AirportDeparture> deps = departureRepository.findByTripId_TripId(trip.getTripId());
                    if (!deps.isEmpty()) {
                        AirportDeparture d = deps.get(0);
                        dto.setPickUpDate(d.getDepartDate());
                        dto.setPickupLocation(d.getDepartPickUp());
                        dto.setDropLocation(d.getDepartAirportName());
                        dto.setPickUpDate(trip.getTripReqDate()); // if needed change
                        dto.setTravellersCount(d.getDepartTravellersCount());
                    }
                    break;
                    //--------------5 DAY TRIPS - HALF DAY - FULL DAY - 24 HRS-------------//
                case HS:
                case FS:
                case H24:

                    List<DayTripsModel> dayTrips = dayTripRepository.findByTripId(trip);

                    if (dayTrips != null && !dayTrips.isEmpty()) {

                        DayTripsModel t = dayTrips.get(0); // take first row
                        dto.setPickUpDate(t.getDayTripDate());
                        dto.setPickupLocation(t.getDayTripickUp());
                        dto.setTravellersCount(t.getDayTripTravellersCount());
                    }
                    break;
            }

            dtos.add(dto);
        }
        return dtos;
    }

    /// fetch bookings in ADMIN PAGE creating DTO list..different fields in different names comes same positions
    private List<TripDetailsViewDTO> convertToDTOList(List<TripModel> trips) {
        List<TripDetailsViewDTO> dtos = new ArrayList<>();

        for (TripModel trip : trips) {
            TripDetailsViewDTO dto = new TripDetailsViewDTO();

            // User info
            dto.setName(trip.getUser().getUsername());
            dto.setMail(trip.getUser().getEmail());
            dto.setMobile(trip.getUser().getPhoneNo());

            // Basic trip info
            dto.setTripId(trip.getTripId());
            dto.setTripType(trip.getTripType());
            dto.setStatus(trip.getStatus());
            dto.setTripRate(trip.getTripRate());

            // Trip-type specific details
            switch (trip.getTripType()) {
                case OWT:
                    oneWayRepository.findByTripId_TripId(trip.getTripId()).stream().findFirst().ifPresent(o -> {
                        dto.setPickupLocation(o.getOneWayPickUp());
                        dto.setDropLocation(o.getOneWayDropOff());
                        dto.setPickUpDate(o.getOneWayDate());
                        dto.setTravellersCount(o.getOneWayTravellersCount());
                    });
                    break;
                case RT:
                    returntransferRepository.findBytripId_TripId(trip.getTripId()).stream().findFirst().ifPresent(r -> {
                        dto.setPickupLocation(r.getReturnPickUp());
                        dto.setDropLocation(r.getReturnDropOff());
                        dto.setPickUpDate(r.getReturnDate());
                        dto.setTravellersCount(r.getReturnTravellersCount());
                    });
                    break;
                case AA:
                    arrivalRepository.findByTripId_TripId(trip.getTripId()).stream().findFirst().ifPresent(a -> {
                        dto.setPickupLocation(a.getArriveAirportName());
                        dto.setDropLocation(a.getArriveDropOff());
                        dto.setPickUpDate(a.getArrivalDate());
                        dto.setTravellersCount(a.getArriveTravellersCount());
                    });
                    break;
                case AD:
                    departureRepository.findByTripId_TripId(trip.getTripId()).stream().findFirst().ifPresent(d -> {
                        dto.setPickupLocation(d.getDepartPickUp());
                        dto.setDropLocation(d.getDepartAirportName());
//                        dto.setPickUpDate(trip.getTripReqDate());
                        dto.setPickUpDate(d.getDepartDate());
                        dto.setTravellersCount(d.getDepartTravellersCount());
                    });
                    break;
                case HS:
                case FS:
                case H24:
                    dayTripRepository.findByTripId(trip).stream().findFirst().ifPresent(t -> {
                        dto.setPickUpDate(t.getDayTripDate());
                        dto.setPickupLocation(t.getDayTripickUp());
                        dto.setTravellersCount(t.getDayTripTravellersCount());
                    });
                    break;
            }

            dtos.add(dto);
        }

        return dtos;
    }
    /// display number of bookings categorised

    public long countTotalTrips() {
       return tripRepository.count();
    }

    public long countPendingTrips() {
        return tripRepository.countByStatus(Status.PENDING);
    }

    public long countConfirmedTrips() {
        return tripRepository.countByStatus(Status.CONFIRMED);
    }

    public long countCompletedTrips() {
        return tripRepository.countByStatus(Status.COMPLETED);
    }



    /// fetching the status of each trip

    public List<TripDetailsViewDTO> getTripsByStatus(Status status) {
        List<TripModel> trips = tripRepository.findByStatus(status);  // create this query in repo
        return convertToDTOList(trips);
    }
//    search trips
    public List<TripDetailsViewDTO> searchTrips(String keyword) {
        List<TripModel> trips = adminRepository.searchTrips(keyword);
        return convertToDTOList(trips);
    }

    /// Search by Name, Email, Mobile --> ADMIN PAGE
    public List<String> getSearchSuggestions(String keyword) {

        if (keyword == null || keyword.trim().length() < 1) {
            return List.of();
        }

        List<String> results = new ArrayList<>();
//copilot-s
        // use adminRepository suggestions (they use contains '%keyword%') so autosuggest matches search behavior
        results.addAll(adminRepository.suggestNames(keyword));
        results.addAll(adminRepository.suggestEmails(keyword));
        results.addAll(adminRepository.suggestMobiles(keyword));
//copilot-end
        // remove duplicates + limit results
        return results.stream()
                .distinct()
//                co-s
                .limit(8)
//                co-end
                .toList();
    }

}
