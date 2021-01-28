package simone.billings.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simone.billings.entities.Billing;
import simone.billings.repositories.BillingRepository;

import java.util.List;

@Api(tags = {"Billing Manager"}, description = "Manage all your billings")
@RestController
public class BillingController {
    @Autowired
    private BillingRepository billingRepository;

    @ApiOperation(value = "Billings list", notes = "Get all the billings created", nickname = "billingsIndex")
    @GetMapping(value = "/api/billings")
    public List<Billing> getBillings() {
        return billingRepository.findAll();
    }

    @ApiOperation(value = "Get a billing by booking number")
    @GetMapping("/api/billings/{bookingNumber}")
    public Billing getBilling(@PathVariable int bookingNumber) {
        return (Billing) billingRepository.findByBookingNumber(bookingNumber).orElse(null);
    }

    @ApiOperation(value = "Register a billing")
    @PostMapping("/api/billings")
    public Billing addBilling(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }

    @ApiOperation(value = "Update billing data")
    @PutMapping(value = "/api/billings/{bookingNumber}")
    public Billing updateBilling(@PathVariable int bookingNumber, @RequestBody Billing billing) {
        assert billing != null;
        return billingRepository.save(billing);
    }

    @ApiOperation(value = "Delete a billing with its booking number")
    @DeleteMapping("/api/billings/{bookingNumber}")
    public void deleteBilling(Billing billing) {
        billingRepository.delete(billing);
    }
}
