package com.rmkshr.java.java8.optional;

import java.util.Optional;

public class AddressOptional {

    Integer streetNumber;
    String streetName;
    String country;
    Integer zipCode;
    String state;

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public Optional<String> getStreetNameOptional() {
        return Optional.of(streetName);
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public AddressOptional(Integer streetNumber, String streetName, String state, String country, Integer zipCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressOptional{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                ", state='" + state + '\'' +
                '}';
    }
}
