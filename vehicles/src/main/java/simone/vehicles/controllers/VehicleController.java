package simone.vehicles.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simone.vehicles.entities.Vehicle;
import simone.vehicles.jpa.repositories.VehicleRepository;

import java.util.List;

@Api(tags = {"Vehicle Manager"}, description = "Manage all your vehicles")
@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @ApiOperation(value = "Vehicles list", notes = "Get all the vehicles created", nickname = "vehiclesIndex")
    @GetMapping(value = "/api/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @ApiOperation(value = "Get a vehicle by license plate")
    @GetMapping("api/vehicles/{licensePlate}")
    public Vehicle getVehicle(@PathVariable String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate).orElse(null);
    }

    @ApiOperation(value = "Register a vehicle")
    @PostMapping("/api/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @ApiOperation(value = "Update vehicle data")
    @PutMapping(value = "/api/vehicles/{licensePlate}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        assert vehicle != null;
        return vehicleRepository.save(vehicle);
    }

    @ApiOperation(value = "Delete a vehicle with its license plate")
    @DeleteMapping("/api/vehicles/{licensePlate}")
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
