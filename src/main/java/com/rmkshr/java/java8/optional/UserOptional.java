package com.rmkshr.java.java8.optional;

import java.util.Optional;

public class UserOptional {

    String name;
    Double mobileNumber;
    AddressOptional address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Double mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AddressOptional getAddress() {
        return address;
    }

    public Optional<AddressOptional> getAddressOptional() {
        return Optional.of(address);
    }

    public void setAddress(AddressOptional address) {
        this.address = address;
    }

    public UserOptional(String name, Double mobileNumber, AddressOptional address) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public UserOptional() {
    }

    @Override
    public String toString() {
        return "_UserOptional{" +
                "name='" + name + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address=" + address.toString() +
                '}';
    }
}
