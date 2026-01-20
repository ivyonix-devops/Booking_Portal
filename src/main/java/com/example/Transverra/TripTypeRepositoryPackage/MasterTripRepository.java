package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripTypeModelPackage.MasterTripModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MasterTripRepository extends CrudRepository<MasterTripModel,Long> {
    Optional<MasterTripModel> findByTripCode(String tripCode);
}
