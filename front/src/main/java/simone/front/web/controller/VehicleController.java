package simone.front.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import simone.front.model.*;


import java.util.List;


@Controller
public class VehicleController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/vehicles")
    public List<Vehicle> getVehicles(Model model) {
        String url = "http://127.0.0.1:9004/vehicles/api/vehicles";
        List<Vehicle> vehicleList = restTemplate.getForObject(url, List.class);
        model.addAttribute("vehicles", vehicleList);
        return vehicleList;
    }






//
//    @GetMapping("api/vehicles/{licensePlate}")
//    public Vehicle getVehicle(@PathVariable String licensePlate) {
//        return vehicleRepository.findByLicensePlate(licensePlate).orElse(null);
//    }
//
//
//    @PostMapping("/api/vehicles")
//    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
//        return vehicleRepository.save(vehicle);
//    }
//
//
//    @PutMapping(value = "/api/vehicles/{licensePlate}")
//    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
//        assert vehicle != null;
//        return vehicleRepository.save(vehicle);
//    }
//
//
//    @DeleteMapping("/api/vehicles/{licensePlate}")
//    public void deleteVehicle(Vehicle vehicle) {
//        vehicleRepository.delete(vehicle);
//    }
}
