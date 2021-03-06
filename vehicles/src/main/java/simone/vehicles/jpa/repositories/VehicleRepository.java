package simone.vehicles.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simone.vehicles.entities.Vehicle;
import simone.vehicles.enums.VehicleType;

import java.util.List;
import java.util.Optional;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findAllByType(VehicleType type);

}