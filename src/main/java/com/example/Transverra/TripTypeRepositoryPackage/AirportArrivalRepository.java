package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripTypeModelPackage.AirportArrival;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportArrivalRepository extends CrudRepository<AirportArrival,Long> {

    List<AirportArrival> findByTripId_TripId(Long tripId);
}
