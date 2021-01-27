package simone.customers.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity

public class Customer {
    @Id
    private Long drivinglicensenumber;

    @NotNull
    private String email;
    private String firstname;
    private String lastname;
    private String phonenumber;

    private LocalDateTime dateofbirth;

    @Column(columnDefinition = "boolean default false")
    private Boolean currentrental;


    /**
     * Constructer
     */
    public Customer() {

    }

    public Customer(@NotNull Long drivinglicensenumber) {
        this.drivinglicensenumber = drivinglicensenumber;
    }

    public Customer(@NotNull Long drivinglicensenumber, @NotNull String email) {
        this.drivinglicensenumber = drivinglicensenumber;
        this.email = email;
    }

    public Customer(Long drivinglicensenumber, String email, String firstName, String lastname, String phonenumber, LocalDateTime dateofbirth, boolean currentrental) {
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

    public @NotNull Long getDrivinglicensenumber() {
        return drivinglicensenumber;
    }

    public void setDrivinglicensenumber(@NotNull Long drivingLicenseNumber) {
        this.drivinglicensenumber = drivingLicenseNumber;
    }

    public LocalDateTime getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDateTime dateOfbirth) {
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
