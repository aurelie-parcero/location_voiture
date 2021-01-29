package simone.front.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class BookingForm {

    private Long drivinglicensenumber;
    private String email;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private int bookingId;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofbirth;
    private String licensePlate;

    private boolean currentrental;

    public Long getDrivinglicensenumber() {
        return drivinglicensenumber;
    }

    public void setDrivinglicensenumber(Long drivinglicensenumber) {
        this.drivinglicensenumber = drivinglicensenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    public boolean isCurrentrental() {
        return currentrental;
    }

    public void setCurrentrental(boolean currentrental) {
        this.currentrental = currentrental;
    }
}
