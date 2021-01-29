package simone.front.web.controller;

import org.springframework.format.annotation.DateTimeFormat;
import simone.front.model.*;
import simone.front.form.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/customers"})
    public List<Customer> listCustomer(Model model) {
        String url = "http://127.0.0.1:9004/customers/api/customers";
        List<Customer> customersList = restTemplate.getForObject(url, List.class);
        model.addAttribute("customers", customersList);
        return customersList;
    }


    @PostMapping(value = {"/addBooking"})
    public String ajouterClient(Model model, @ModelAttribute BookingForm bookingForm) {
        String url = "http://127.0.0.1:9004/customers/api/customers";
        String resaUrl = "http://127.0.0.1:9004/reservations/api/reservations/" + bookingForm.getBookingId();

        bookingForm.setCurrentrental(false);
        Customer newcustomer = restTemplate.postForObject(url, bookingForm, Customer.class);
        Reservation booking = restTemplate.getForObject(resaUrl, Reservation.class);
        //System.out.println(booking.getId_vehicle());
        System.out.println(bookingForm.getBookingId());
//        assert newcustomer != null;
//        assert booking != null;
        booking.setId_customer(bookingForm.getDrivinglicensenumber());
        booking.setStatus(ReservationStatus.ON_GOING);
        restTemplate.put(resaUrl, booking, Reservation.class, bookingForm.getBookingId());
        String vehicleUrl = "http://127.0.0.1:9004/vehicles/api/vehicles/" + booking.getId_vehicle();
        Vehicle car = restTemplate.getForObject(vehicleUrl, Vehicle.class);
        model.addAttribute("bookingForm", false);
        model.addAttribute("newcustomer", newcustomer);
        model.addAttribute("booking", booking);
        model.addAttribute("car", car);
        return "booking";
    }

//
//
//
//    @GetMapping(value = "/api/customers/{drivinglicensenumber}")
//    public Customer seeCustomer(@PathVariable long drivinglicensenumber) {
//        return customerDao.findByDrivinglicensenumber(drivinglicensenumber);
//    }
//
//    @PostMapping(value = "/api/customers")
//    public Customer addCustomer(@RequestBody Customer customer) {
//        Customer save = customerDao.save(customer);
//        return save;
//    }
//
//    @DeleteMapping (value = "/api/customers/{drivinglicensenumber}")
//    public void delete(Customer customer) {
//        customerDao.delete(customer);
//    }
//
//    @PutMapping(value = "/api/customers/{drivinglicensenumber}")
//    public void updCustomer( @RequestBody Customer customer) {
//       customerDao.save(customer);
//    }

}

