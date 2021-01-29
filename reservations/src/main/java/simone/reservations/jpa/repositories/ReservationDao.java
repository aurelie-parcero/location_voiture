package simone.reservations.jpa.repositories;


import simone.reservations.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDao {

List<Reservation> getReservationsOnDates(Date start, Date end);
}
