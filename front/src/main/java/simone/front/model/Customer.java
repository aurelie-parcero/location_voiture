package simone.front.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class Customer {

    private Long drivinglicensenumber;


    private String email;
    private String firstname;
    private String lastname;
    private String phonenumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofbirth;


    private boolean currentrental;


    /**
     * Constructer
     */
    public Customer() {

    }

    public Customer(Long drivinglicensenumber) {
        this.drivinglicensenumber = drivinglicensenumber;
    }

    public Customer(Long drivinglicensenumber, String email) {
        this.drivinglicensenumber = drivinglicensenumber;
        this.email = email;
    }

    public Customer(Long drivinglicensenumber, String email, String firstName, String lastname, String phonenumber, Date  dateofbirth, boolean currentrental) {
        this.drivinglicensenumber= drivinglicensenumber;
        this.email = email;
        this.firstname = firstName;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.dateofbirth = dateofbirth;
        this.currentrental = currentrental;
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

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String  phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public Long getDrivinglicensenumber() {
        return drivinglicensenumber;
    }

    public void setDrivinglicensenumber(Long drivingLicenseNumber) {
        this.drivinglicensenumber = drivingLicenseNumber;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateOfbirth) {
        this.dateofbirth = dateOfbirth;
    }

    public boolean isCurrentrental() {
        return currentrental;
    }

    public void setCurrentrental(boolean currentRental) {
        this.currentrental = currentRental;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + drivinglicensenumber+
                ", email='" + email + '\'' +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", phoneNumber='" + phonenumber + '\'' +
                ", dateOfbirth='" + dateofbirth + '\'' +
                ", currentRental=" + currentrental +
                '}';
    }
}
