package simone.billings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simone.billings.entities.Billing;

import java.util.Optional;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

    Optional<Object> findByBookingNumber(int bookingNumber);
}
