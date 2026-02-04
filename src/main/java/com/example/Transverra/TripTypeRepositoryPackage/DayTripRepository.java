package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.TripTypeModelPackage.DayTripsModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DayTripRepository extends CrudRepository <DayTripsModel,Long>{
        List<DayTripsModel> findByTripId(TripModel trip);
    //    to make cascade on manual deletion in DB
    @Transactional
    @Modifying
    @Query("DELETE FROM OneWayTransfer o WHERE o.tripId.tripId = :tripId")
    void deleteByTripId(@Param("tripId") Long tripId);
    }


