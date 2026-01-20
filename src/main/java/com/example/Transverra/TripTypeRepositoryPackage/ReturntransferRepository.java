package com.example.Transverra.TripTypeRepositoryPackage;

import com.example.Transverra.TripTypeModelPackage.ReturnTransfer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReturntransferRepository extends CrudRepository <ReturnTransfer,Long>{

    List<ReturnTransfer> findBytripId_TripId(Long tripId);
}
