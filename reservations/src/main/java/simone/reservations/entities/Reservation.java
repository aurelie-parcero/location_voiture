package simone.reservations.entities;

import simone.reservations.enums.ReservationType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    private int bookingNumber;
    private String id_vehicle;
    private Long id_customer;
    private ReservationType type;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private int estimationMileage;
    private int mileage;
    private float quote;
    private int invoice;

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getId_vehicle() {
        return id_vehicle;
    }

    public void setId_vehicle(String id_vehicle) {
        this.id_vehicle = id_vehicle;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public ReservationType getType() {
        return type;
    }

    public void setType(ReservationType type) {
        this.type = type;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getEstimationMileage() {
        return estimationMileage;
    }

    public void setEstimationMileage(int estimationMileage) {
        this.estimationMileage = estimationMileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public float getQuote() {
        return quote;
    }

    public void setQuote(float quote) {
        this.quote = quote;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "bookingNumber=" + bookingNumber +
                ", id_vehicle=" + id_vehicle +
                ", id_customer=" + id_customer +
                ", type=" + type +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", estimationMileage=" + estimationMileage +
                ", mileage=" + mileage +
                ", quote='" + quote + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
