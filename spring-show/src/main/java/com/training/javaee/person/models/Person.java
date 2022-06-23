package com.training.javaee.person.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "kisi")
public class Person {

    @Id
    @GeneratedValue
    private Long           personId;
    @Size(min = 2, max = 20)
    private String         name;
    @Column(length = 50)
    private String         surname;
    private Integer        height;
    private Integer        weight;
    private String         password;
    @Column(name = "astatus")
    @Enumerated(EnumType.STRING)
    private EAccountStatus accountStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address        address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone>    phones;

    @Version
    private Integer        dataVersion;


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

    public Integer getDataVersion() {
        return this.dataVersion;
    }

    public void setDataVersion(final Integer dataVersionParam) {
        this.dataVersion = dataVersionParam;
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
