package simone.front.model;


import java.time.LocalDate;
import java.util.Set;

public class Vehicle {


    private String licensePlate;
    private VehicleType type;
    private String brand;
    private String model;
    private String color;
    private String cylinder;
    private float price;
    private float kilometerRate;
    private int RACHP;

    private Set<LocalDate> isBooked;


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public Set<LocalDate> getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Set<LocalDate> isBooked) {
        this.isBooked = isBooked;
    }

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
                ", isBooked=" + isBooked +
                '}';
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
