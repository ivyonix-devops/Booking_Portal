package com.example.Transverra.TripDetailsPackage;

import com.example.Transverra.TripTypeDTOs.BookingRequestDTO;
import com.example.Transverra.UserPackeges.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripController {

    @Autowired private TripService tripService;


}
