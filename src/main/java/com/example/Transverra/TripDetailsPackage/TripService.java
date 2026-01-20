package com.example.Transverra.TripDetailsPackage;

import com.example.Transverra.TripTypeModelPackage.*;
import com.example.Transverra.TripTypeRepositoryPackage.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired private TripRepository tripRepository;
    @Autowired private OneWayRepository oneWayRepository;
    @Autowired private ReturntransferRepository returntransferRepository;
    @Autowired private AirportArrivalRepository airportArrivalRepository;
    @Autowired private AirportDepartureRepository airportDepartureRepository;
    @Autowired private DayTripRepository dayTripRepository;

    // Save or update trip
    @Transactional
    public TripModel saveTrip(TripModel tripModel) {
        return tripRepository.save(tripModel);
    }

    // Fetch all trips
    @Transactional(Transactional.TxType.SUPPORTS) // read-only
    public List<TripModel> getAllTrips() {
        return (List<TripModel>) tripRepository.findAll();
    }
    @Transactional
    public OneWayTransfer saveOneWay(OneWayTransfer oneWayTransfer){
        return oneWayRepository.save(oneWayTransfer);
    }
   @Transactional
    public ReturnTransfer saveReturnTransfer(ReturnTransfer returnTransfer) {
       return returntransferRepository.save(returnTransfer);
   }
    @Transactional
       public AirportArrival saveAirportArrival (AirportArrival airportArrival){
           return airportArrivalRepository.save(airportArrival);
       }

       @Transactional
    public AirportDeparture saveDepartureDetails(AirportDeparture airportDeparture){
        return airportDepartureRepository.save(airportDeparture);
    }
    @Transactional
    public DayTripsModel saveDayTripDetails(DayTripsModel dayTripsModel){
        return dayTripRepository.save(dayTripsModel);
    }
//    public DayTripsModel getDayTripTyoByTripId(Long tripId){
//        return dayTripRepository.findByTripId(tripId).orElseThrow(() -> new RuntimeException("Day trip not found for trip id: " + tripId)).getDayTrip();
//    }

   }

