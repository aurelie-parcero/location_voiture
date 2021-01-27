package simone.front.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import simone.front.model.Customer;


import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/api/customers"})
    public List<Customer> listCustomer(Model model) {
        String url = "http://127.0.0.1:8083/api/customers";
        List<Customer> customersList = restTemplate.getForObject(url, List.class);
        model.addAttribute("customers", customersList);
        return customersList;
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

