package com.training.javaee.rest.models;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.javaee.person.models.Address;
import com.training.javaee.person.models.Phone;
import com.training.javaee.validation.StartWith;

@XmlRootElement
public class PersonRest {


    @NotEmpty(message = "name null olamaz")
    @NotBlank
    @Size(min = 2, max = 15)
    @StartWith("n:")
    private String      name;
    @NotEmpty(message = "surname null olamaz")
    @NotBlank
    @Size(min = 3, max = 18)
    @StartWith("s:")
    private String      surname;
    @Max(300)
    @Min(50)
    private Integer     height;
    @Max(300)
    @Min(10)
    @Positive
    private Integer     weight;

    @NotNull
    private Address     address;

    @NotNull
    private List<Phone> phones;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String      password;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}
