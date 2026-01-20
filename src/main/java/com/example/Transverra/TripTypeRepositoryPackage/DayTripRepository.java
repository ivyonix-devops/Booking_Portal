package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.TripTypeModelPackage.DayTripsModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DayTripRepository extends CrudRepository <DayTripsModel,Long>{
        List<DayTripsModel> findByTripId(TripModel trip);
    }


