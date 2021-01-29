package simone.reservations.jpa.repositories;

import org.springframework.stereotype.Repository;
import simone.reservations.entities.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Reservation> getReservationsOnDates(Date start, Date end) {

        Query query = em.createNativeQuery("SELECT * FROM reservations WHERE ((reservations.pick_up_date BETWEEN ? AND ?) OR (reservations.return_date BETWEEN ? AND ?)) OR (reservations.pick_up_date < ? AND reservations.return_date > ?)", Reservation.class);
        query.setParameter(1, start, TemporalType.DATE);
        query.setParameter(2, end, TemporalType.DATE);
        query.setParameter(3, start, TemporalType.DATE);
        query.setParameter(4, end, TemporalType.DATE);
        query.setParameter(5, start, TemporalType.DATE);
        query.setParameter(6, end, TemporalType.DATE);
        return query.getResultList();
    }
}
