package simone.front.web.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import simone.front.form.BookingForm;
import simone.front.form.IsBookedForm;
import simone.front.model.Vehicle;
import simone.front.model.Reservation;
import simone.front.model.VehicleType;
import simone.front.model.ReservationStatus;
import simone.front.model.Customer;

import simone.front.form.*;
import simone.front.model.*;


import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
public class VehicleController {


    public Date startBooking;
    public Date endBooking;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/vehicles")
    public List<Vehicle> getVehicles(Model model) {
        String url = "http://127.0.0.1:9004/vehicles/api/vehicles";
        List<Vehicle> vehicleList = restTemplate.getForObject(url, List.class);
        model.addAttribute("vehicles", vehicleList);
        return vehicleList;
    }


    @GetMapping(value = "/")
    public String showVehicleForm(Model model) {
        IsBookedForm isBookedForm = new IsBookedForm();
        model.addAttribute("isBookedForm", isBookedForm);
        return "index";
    }


    @PostMapping(value = "/isBooked")
    public String showVehiclesNotBooked(Model model, @ModelAttribute IsBookedForm isBookedForm) throws ParseException {
        model.addAttribute("isBookedFormExist", isBookedForm);
        Date beginDate = isBookedForm.getBeginDate();
        Date endDate = isBookedForm.getEndDate();
        VehicleType type = isBookedForm.getType();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String parsedStartDate = format.format(beginDate);
        String parsedEndDate = format.format(endDate);
        String urlVehicles = "http://127.0.0.1:9004/vehicles/api/vehicles?&type=" + type;
        List<Vehicle> vehicles = restTemplate.postForObject(urlVehicles, isBookedForm, List.class);
        String urlReservations = "http://127.0.07:9004/reservations/api/reservations/booked?start=" + parsedStartDate + "&end=" + parsedEndDate;
        List<Reservation> bookings = restTemplate.postForObject(urlReservations, isBookedForm, List.class);

//        assert bookings != null;
//        for (Reservation resa : bookings
//        ) {
//            assert vehicles != null;
//            vehicles.removeIf(vehicle -> vehicle.getLicensePlate().equals(resa.getId_vehicle()));
//        }
//
//        System.out.println(vehicles);

        model.addAttribute("vehicles", vehicles);
        if (isBookedForm == null) {
            model.addAttribute("isBookedForm", new IsBookedForm());
        }
        System.out.println(isBookedForm);
        startBooking = beginDate;
        endBooking = endDate;
        return "index";
    }

    @GetMapping(value = "/booking/{licensePlate}")
    public String showBookingForm(Model model, @PathVariable(value = "licensePlate") String licensePlate){
        String url = "http://127.0.0.1:9004/vehicles/api/vehicles/"+licensePlate;
        Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
        BookingForm bookingForm = new BookingForm();
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("licensePlate", licensePlate);
        model.addAttribute("bookingForm", bookingForm);
        Reservation resa = new Reservation();
        resa.setId_vehicle(licensePlate);
        resa.setStatus(ReservationStatus.WAITING_CONFIRM);
        resa.setPickUpDate(startBooking);
        resa.setReturnDate(endBooking);
        String resaUrl = "http://127.0.0.1:9004/reservations/api/reservations";
        Reservation postResa = restTemplate.postForObject(resaUrl, resa, Reservation.class);
        model.addAttribute("resa", postResa);
        return "booking";
    }
//    @GetMapping(value = "/booking/{licensePlate}")
//    public String showBookingForm(Model model, @PathVariable(value = "licensePlate") String licensePlate){
//        String url = "http://127.0.0.1:9004/vehicles/api/vehicles/"+licensePlate;
//        Vehicle vehicle = restTemplate.getForObject(url, Vehicle.class);
//        BookingForm bookingForm = new BookingForm();
//        model.addAttribute("vehicle", vehicle);
//        model.addAttribute("licensePlate", licensePlate);
//        model.addAttribute("bookingForm", bookingForm);
//        return "booking";
//    }
//    @GetMapping(value = "/bookingForm/{licensePlate}")
//    public String bookingForm(Model model,@ModelAttribute BookingForm bookingForm) {
//        if (bookingForm == null) {
//            model.addAttribute("bookingForm", new BookingForm());
//        }
//        return "index";
//    }


//    @PostMapping(value = "/isBooked")
//    public IsBookedForm showVehiclesNotBooked(Model model,@ModelAttribute IsBookedForm isBookedForm) {
//        Date beginDate = isBookedForm.getBeginDate();
//        System.out.println(beginDate);
//        return isBookedForm;
//    }


//
//    @GetMapping("api/vehicles/{licensePlate}")
//    public Vehicle getVehicle(@PathVariable String licensePlate) {
//        return vehicleRepository.findByLicensePlate(licensePlate).orElse(null);
//    }
//
//
//    @PostMapping("/api/vehicles")
//    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
//        return vehicleRepository.save(vehicle);
//    }
//
//
//    @PutMapping(value = "/api/vehicles/{licensePlate}")
//    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
//        assert vehicle != null;
//        return vehicleRepository.save(vehicle);
//    }
//
//
//    @DeleteMapping("/api/vehicles/{licensePlate}")
//    public void deleteVehicle(Vehicle vehicle) {
//        vehicleRepository.delete(vehicle);
//    }
}
