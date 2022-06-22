package com.training.javaee.person.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private Long           personId;
    private String         name;
    private String         surname;
    private Integer        height;
    private Integer        weight;
    private String         password;
    private EAccountStatus accountStatus;

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

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public EAccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(final EAccountStatus accountStatusParam) {
        this.accountStatus = accountStatusParam;
    }


}
