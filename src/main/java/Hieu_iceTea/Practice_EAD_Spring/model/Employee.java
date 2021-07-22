package Hieu_iceTea.Practice_EAD_Spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends BaseModel implements Serializable {

    //region - Define Fields -

    @NotNull
    @Size(min = 2, max = 64)
    private String name;

    @NotNull
    @Digits(integer = 16, fraction = 2)
    private double wage;

    //endregion


    //region - Relationship -

    //endregion


    //region - Getter, Setter -
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    //endregion


    //region - Method Extend -

    //endregion

}