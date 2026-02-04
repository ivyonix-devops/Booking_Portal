package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripTypeModelPackage.AirportDeparture;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirportDepartureRepository extends CrudRepository <AirportDeparture,Long> {

    List<AirportDeparture> findByTripId_TripId(Long tripid);
    //    to make cascade on manual deletion in DB
    @Transactional
    @Modifying
    @Query("DELETE FROM OneWayTransfer o WHERE o.tripId.tripId = :tripId")
    void deleteByTripId(@Param("tripId") Long tripId);
}
