package com.example.Transverra.TripDetailsPackage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends CrudRepository<TripModel,Long> {
    List<TripModel> findByStatus(Status status);
    long countByStatus(Status status);

    // SEARCH by name / email / mobile => ADMIN PAGE//
    @Query("""
   SELECT DISTINCT u.username 
   FROM TripModel t JOIN t.user u
   WHERE LOWER(u.username) LIKE LOWER(CONCAT(:keyword, '%'))
""")
    List<String> suggestNames(@Param("keyword") String keyword);

    @Query("""
   SELECT DISTINCT u.email 
   FROM TripModel t JOIN t.user u
   WHERE LOWER(u.email) LIKE LOWER(CONCAT(:keyword, '%'))
""")
    List<String> suggestEmails(@Param("keyword") String keyword);

    @Query("""
   SELECT DISTINCT u.phoneNo 
   FROM TripModel t JOIN t.user u
   WHERE u.phoneNo LIKE CONCAT(:keyword, '%')
""")
    List<String> suggestMobiles(@Param("keyword") String keyword);

}

