package com.example.Transverra.AdminPackeges;

import com.example.Transverra.TripDetailsPackage.TripModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<AdminModel,Integer> {
    AdminModel findByAdmName(String admName);
    // Search by Name
    @Query("""
        select u.username
        from TripModel t join t.user u
        where lower(u.username) like lower(concat('%', :keyword, '%'))
    """)
    List<String> suggestNames(String keyword);

    // Search by Email
    @Query("""
        select u.email
        from TripModel t join t.user u
        where lower(u.email) like lower(concat('%', :keyword, '%'))
    """)
    List<String> suggestEmails(String keyword);

    // Search by Mobile
    @Query("""
        select u.phoneNo
        from TripModel t join t.user u
        where u.phoneNo like concat('%', :keyword, '%')
    """)
    List<String> suggestMobiles(String keyword);


    @Query("""
    select t
    from TripModel t join t.user u
    where lower(u.username) like lower(concat('%', :keyword, '%'))
       or lower(u.email) like lower(concat('%', :keyword, '%'))
       or u.phoneNo like concat('%', :keyword, '%')
""")
    List<TripModel> searchTrips(String keyword);

}

