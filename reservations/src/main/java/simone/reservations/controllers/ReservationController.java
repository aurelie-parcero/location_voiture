package simone.reservations.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import simone.reservations.entities.Reservation;
import simone.reservations.jpa.repositories.ReservationDaoImpl;
import simone.reservations.jpa.repositories.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = {"Reservation Manager"}, description = "Manage all your reservations")
@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @ApiOperation(value = "Reservations list", notes = "Get all the reservations created", nickname = "reservationsIndex")
    @GetMapping(value = "/api/reservations")
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @ApiOperation(value = "Reservations list", notes = "Get all the reservations created", nickname = "reservationsIndex")
    @RequestMapping(value = "/api/reservations/booked")
    public List<Reservation> getLicensePlatesBookedByDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return reservationRepository.getReservationsOnDates(start, end);

    }


    @ApiOperation(value = "Get a reservation by booking number")
    @GetMapping("/api/reservations/{bookingNumber}")
    public Reservation getReservation(@PathVariable int bookingNumber) {
        return reservationRepository.findByBookingNumber(bookingNumber).orElse(null);
    }

    @ApiOperation(value = "Register a reservation")
    @PostMapping("/api/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value = "Update reservation data")
    @PutMapping(value = "/api/reservations/{bookingNumber}")
    public Reservation updateReservation(@PathVariable int bookingNumber, @RequestBody Reservation reservation) {
        assert reservation != null;
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value = "Delete a reservation with its booking number")
    @DeleteMapping("/api/reservations/{bookingNumber}")
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
