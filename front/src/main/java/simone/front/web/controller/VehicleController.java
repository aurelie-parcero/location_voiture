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
import simone.front.model.*;


import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
public class VehicleController {


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
        String urltoclean = "http://127.0.0.1:9004/vehicles/api/vehicles/available?start=" + parsedStartDate + "&end=" + parsedEndDate + "&type=" + type;
        List<Vehicle> vehicles = restTemplate.postForObject(urltoclean, isBookedForm, List.class);
        model.addAttribute("vehicles", vehicles);
        if (isBookedForm == null) {
            model.addAttribute("isBookedForm", new IsBookedForm());
        }
        System.out.println(isBookedForm);
        return "index";
    }

    @GetMapping(value = "/bookingForm")
    public String showBookingForm(Model model) {
//        BookingForm bookingForm = new BookingForm();
//        model.addAttribute("bookingForm", bookingForm);
        model.addAttribute("licensePlate", "teeeesssst");
        return "index";
    }
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
