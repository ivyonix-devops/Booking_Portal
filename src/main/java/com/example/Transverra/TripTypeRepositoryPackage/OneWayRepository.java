package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.TripTypeModelPackage.OneWayTransfer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OneWayRepository extends CrudRepository <OneWayTransfer,Long>{

        List<OneWayTransfer> findByTripId_TripId(Long tripId);
    }


