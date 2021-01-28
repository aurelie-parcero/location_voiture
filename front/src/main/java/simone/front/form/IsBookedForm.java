package simone.front.form;

import org.springframework.format.annotation.DateTimeFormat;
import simone.front.model.VehicleType;

import java.time.LocalDate;
import java.util.Date;

public class IsBookedForm {
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    private VehicleType type;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
