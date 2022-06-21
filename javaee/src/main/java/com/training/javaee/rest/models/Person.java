package com.training.javaee.rest.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.javaee.validation.StartWith;

@XmlRootElement
public class Person {

    private Long    personId;
    @QueryParam("name")
    @NotEmpty(message = "name null olamaz")
    @NotBlank
    @Size(min = 2, max = 15)
    @StartWith("n:")
    private String  name;
    @QueryParam("sur")
    @NotEmpty(message = "surname null olamaz")
    @NotBlank
    @Size(min = 3, max = 18)
    @StartWith("s:")
    private String  surname;
    @HeaderParam("height")
    @Max(300)
    @Min(50)
    private Integer height;
    @HeaderParam("height")
    @Max(300)
    @Min(10)
    @Positive
    private Integer weight;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String  password;

    public String getName() {
        return name;
    }

    public void setName(String nameParam) {
        name = nameParam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surnameParam) {
        surname = surnameParam;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer heightParam) {
        height = heightParam;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weightParam) {
        weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", height=" + height + ", weight=" + weight + "]";
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personIdParam) {
        personId = personIdParam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordParam) {
        password = passwordParam;
    }


}
