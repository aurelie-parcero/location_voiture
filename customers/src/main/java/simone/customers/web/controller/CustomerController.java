package simone.customers.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import simone.customers.dao.*;
import simone.customers.model.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping(value = "/api/customers")
    public List<Customer> listCustomer() {
        return customerDao.findAll();
    }

    @GetMapping(value = "/api/customers/{drivinglicensenumber}")
    public Customer seeCustomer(@PathVariable long drivinglicensenumber) {
        return customerDao.findByDrivinglicensenumber(drivinglicensenumber);
    }

    @PostMapping(value = "/api/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer save = customerDao.save(customer);
        return save;
    }

    @DeleteMapping (value = "/api/customers/{drivinglicensenumber}")
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @PutMapping(value = "/api/customers/{drivinglicensenumber}")
    public void updCustomer( @RequestBody Customer customer) {
       customerDao.save(customer);
    }

}

