package com.example.Transverra.AdminPackeges;

import com.example.Transverra.TripDetailsPackage.Status;
import com.example.Transverra.TripDetailsPackage.TripRepository;
import com.example.Transverra.TripTypeDTOs.TripDetailsViewDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    TripExcelService tripExcelService;

    // ---------- LOGIN PAGE ----------
    @GetMapping("/admin/login")
    public String login() {
        return "adminLoginForm";
    }


    // ---------- LOGIN PROCESS ----------
    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String admName,
                             @RequestParam String adm_password,
                             Model model,
                             HttpSession session) {

        AdminModel admin = adminService.findAdminByName(admName);

        if (admin != null &&
                admin.getAdmName().equals(admName) &&
                admin.getAdm_password().equals(adm_password)) {

            session.setAttribute("isAdminLoggedIn", true);
            session.setAttribute("adminName", admin.getAdmName());

            return "redirect:/admin/dashboard";
        }

        model.addAttribute("error", "Invalid Input");
        return "adminLoginForm";
    }

    // ---------- AFTER LOGIN REDIRECT ----------
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model, HttpSession session) {

        if (session.getAttribute("isAdminLoggedIn") == null) {
            return "redirect:/admin/login";
        }
        List<TripDetailsViewDTO> allTrips = adminService.getAllTripsForAdmin();

        model.addAttribute("trips", allTrips);


        ///  to display teh number of bookings

        // === Count values for cards ===
            model.addAttribute("total", adminService.countTotalTrips());
            model.addAttribute("pending", adminService.countPendingTrips());
            model.addAttribute("confirmed", adminService.countConfirmedTrips());
            model.addAttribute("completed", adminService.countCompletedTrips());

        return "adminDashboard";        //  dashboard HTML page
    }

    /// to fetch trips

    @GetMapping("/admin/bookings")
    public String allBookings(Model model) {
        List<TripDetailsViewDTO> allTrips = adminService.getAllTripsForAdmin();
        model.addAttribute("trips", allTrips);
        return "adminDashboard";
    }
    /// fetch the bookings by status

    @GetMapping("/admin/dashboard/status/{status}")
    public String dashboardByStatus(@PathVariable String status, Model model, HttpSession session) {
        if (session.getAttribute("isAdminLoggedIn") == null) {
            return "redirect:/admin/login";
        }


        model.addAttribute("total", adminService.countTotalTrips());
        model.addAttribute("pending", adminService.countPendingTrips());
        model.addAttribute("confirmed", adminService.countConfirmedTrips());
        model.addAttribute("completed", adminService.countCompletedTrips());

        List<TripDetailsViewDTO> trips;
        if(status.equalsIgnoreCase("all")) {
            trips = adminService.getAllTripsForAdmin();
        } else {
            trips = adminService.getTripsByStatus(Status.valueOf(status.toUpperCase()));
        }

        model.addAttribute("trips", trips);

        return "adminDashboard";
    }
    //// Search by Name,Email, Mobile
    @GetMapping("/admin/dashboard/search")
    public String searchTrips(
            @RequestParam("keyword") String keyword,
            Model model) {

        model.addAttribute("total", adminService.countTotalTrips());
        model.addAttribute("pending", adminService.countPendingTrips());
        model.addAttribute("confirmed", adminService.countConfirmedTrips());
        model.addAttribute("completed", adminService.countCompletedTrips());

        List<TripDetailsViewDTO> trips = adminService.searchTrips(keyword);
        model.addAttribute("trips", trips);

        return "adminDashboard";
    }
    @ResponseBody
    @GetMapping("/admin/dashboard/autosuggest")
    public List<String> autoSuggest(@RequestParam String keyword) {
        return adminService.getSearchSuggestions(keyword);
    }
    // ---------------- CONFIRM / COMPLETE ACTION ----------------
    @GetMapping("/admin/dashboard/action/{tripId}")
    public String handleTripAction(@PathVariable Long tripId, HttpSession session) {

        // Optional login check
    if (session.getAttribute("isAdminLoggedIn") == null) {
        return "redirect:/admin/login";
    }

        tripRepository.findById(tripId).ifPresent(trip -> {

            if (trip.getStatus() == Status.PENDING) {
                trip.setStatus(Status.CONFIRMED);
            }
            else if (trip.getStatus() == Status.CONFIRMED) {
                trip.setStatus(Status.COMPLETED);
            }

            tripRepository.save(trip);
        });

        return "redirect:/admin/dashboard";
    }

    // ---------------- Cancel Trip ----------------
    @GetMapping("/admin/dashboard/cancel/{tripId}")
    public String cancelTrip(@PathVariable Long tripId, HttpSession session) {
        if (session.getAttribute("isAdminLoggedIn") == null) {
            return "redirect:/admin/login";
        }

        tripRepository.findById(tripId).ifPresent(trip -> {
            trip.setStatus(Status.CANCELLED);
            tripRepository.save(trip);
        });

        return "redirect:/admin/dashboard";
    }

    // ---------------- Delete Trip ----------------
    @GetMapping("/admin/dashboard/delete/{tripId}")
    public String deleteTrip(@PathVariable Long tripId, HttpSession session) {
        if (session.getAttribute("isAdminLoggedIn") == null) {
            return "redirect:/admin/login";
        }

        tripRepository.deleteById(tripId);

        return "redirect:/admin/dashboard";
    }



    @GetMapping("/admin/error")
    public String admLoginError(){
        return "adminLoginError";
    }


        //-------LOGOUT-ADMIN--------
        @PostMapping("admin/logout")
        public String adminLogout(HttpSession session) {
            // Invalidate admin session
            session.invalidate();

            // Redirect to admin login page
            return "redirect:/admin/login";
        }
}

