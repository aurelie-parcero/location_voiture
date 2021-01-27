package simone.customers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simone.customers.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
   Customer findByDrivinglicensenumber(Long drivinglicensenumber);
}
