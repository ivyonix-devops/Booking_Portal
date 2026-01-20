package com.example.Transverra.TripDetailsPackage;

import com.example.Transverra.TripTypeRepositoryPackage.MasterTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MasterTripService {
    @Autowired
    private MasterTripRepository repository;

    public BigDecimal getRateByTripType(TripTypesEnum tripType) {

        return repository.findByTripCode(tripType.name())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Trip code not found: " + tripType.name()))
                .getFixedRate();
    }
    }

