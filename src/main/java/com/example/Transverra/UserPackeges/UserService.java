package com.example.Transverra.UserPackeges;

import com.example.Transverra.TripDetailsPackage.TripModel;
import com.example.Transverra.TripDetailsPackage.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public void saveUserBookRequest(UserModel userModel){
        userRepository.save(userModel);
    }

}
