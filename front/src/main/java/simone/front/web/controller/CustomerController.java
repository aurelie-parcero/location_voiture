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
    public String ajouterClient(Model model, @ModelAttribute  BookingForm bookingForm) {
        String url = "http://127.0.0.1:9004/customers/api/customers";
        bookingForm.setCurrentrental(false);
        Customer newcustomer = restTemplate.postForObject(url,bookingForm,Customer.class);
        model.addAttribute("newcustomer", newcustomer);
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

