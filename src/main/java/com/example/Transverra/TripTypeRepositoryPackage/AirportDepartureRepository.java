package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripTypeModelPackage.AirportDeparture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportDepartureRepository extends CrudRepository <AirportDeparture,Long> {

    List<AirportDeparture> findByTripId_TripId(Long tripid);
}
