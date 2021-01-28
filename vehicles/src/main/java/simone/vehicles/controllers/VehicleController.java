package simone.vehicles.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import simone.vehicles.entities.Vehicle;
import simone.vehicles.enums.VehicleType;
import simone.vehicles.jpa.repositories.VehicleRepository;

import javax.swing.text.DateFormatter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = {"Vehicle Manager"}, description = "Manage all your vehicles")
@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;


    @ApiOperation(value = "Vehicles available", notes = "Get all the vehicles created")
    @RequestMapping(value = "/api/vehicles/available")
    public @ResponseBody
    List<Vehicle> getVehiclesAvailable(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<Vehicle> result = new ArrayList<>();
        List<Vehicle> unavailable = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (!vehicle.getIsBooked().isEmpty()) {
                for (Date date : vehicle.getIsBooked()
                ) {
                    if ((date.after(start) || date.equals(start)) && (date.before(end) || date.equals(end))) {
                        unavailable.add(vehicle);
                    }
                }
            }
        }
        for (Vehicle vehicle : allVehicles) {
            if(!unavailable.contains(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }


    @ApiOperation(value = "Vehicles list", notes = "Get all the vehicles created", nickname = "vehiclesIndex")
    @GetMapping(value = "/api/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }


    @ApiOperation(value = "Vehicles by type", notes = "Get all the vehicles of this type")
    @RequestMapping(value = "/api/vehicles", params = "type")
    public @ResponseBody
    List<Vehicle> getVehiclesByType(@RequestParam String type) {
        System.out.println(type);

        return vehicleRepository.findAllByType(VehicleType.valueOf(type.toUpperCase()));
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
