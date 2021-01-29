package simone.front.model;

import java.util.Date;

public class Reservation {

    private int bookingNumber;
    private String id_vehicle;
    private Long id_customer;
    private ReservationStatus status;
    private Date pickUpDate;
    private Date returnDate;
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

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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
                ", status=" + status +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", estimationMileage=" + estimationMileage +
                ", mileage=" + mileage +
                ", quote='" + quote + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
