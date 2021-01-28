package simone.billings.entities;


import simone.billings.enums.PaymentType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "billings")
public class Billing {

    @Id
    private int bookingNumber;
    private String id_invoice;
    private PaymentType type;
    private LocalDate paymentDate;
    private float payableAmount;

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(String id_invoice) {
        this.id_invoice = id_invoice;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(float payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "bookingNumber=" + bookingNumber +
                ", id_invoice='" + id_invoice + '\'' +
                ", type=" + type +
                ", paymentDate=" + paymentDate +
                ", payableAmount=" + payableAmount +
                '}';
    }
}
