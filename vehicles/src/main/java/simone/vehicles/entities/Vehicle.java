package simone.vehicles.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import simone.vehicles.enums.VehicleType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    private String licensePlate;
    private VehicleType type;
    private String brand;
    private String model;
    private String color;
    private String cylinder;
    private float price;
    private float kilometerRate;
    private int RACHP;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @ElementCollection
//    @Column(columnDefinition="DATE")
//    @MapKeyColumn(columnDefinition="DATE")
//    private Set<Date> isBooked;
//    @Temporal(TemporalType.TIMESTAMP)



    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getKilometerRate() {
        return kilometerRate;
    }

    public void setKilometerRate(float kilometerRate) {
        this.kilometerRate = kilometerRate;
    }

    public int getRACHP() {
        return RACHP;
    }

    public void setRACHP(int RACHP) {
        this.RACHP = RACHP;
    }

//    public Set<Date> getIsBooked() {
//        return isBooked;
//    }
//
//    public void setIsBooked(Set<Date> isBooked) {
//        this.isBooked = isBooked;
//    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", cylinder='" + cylinder + '\'' +
                ", price=" + price +
                ", kilometerRate=" + kilometerRate +
                ", RACHP=" + RACHP +
                '}';
    }

}
