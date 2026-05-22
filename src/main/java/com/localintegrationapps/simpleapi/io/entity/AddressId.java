package com.localintegrationapps.simpleapi.io.entity;

import java.io.Serializable;
import java.util.Objects;

public class AddressId implements Serializable {

    private String geschaeftspartnernummer;
    private String geschaeftspartnertyp;

    // default constructor
    public AddressId(String geschaeftspartnernummer, String geschaeftspartnertyp) {
        this.geschaeftspartnernummer = geschaeftspartnernummer;
        this.geschaeftspartnertyp = geschaeftspartnertyp;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return Objects.equals(geschaeftspartnernummer, addressId.geschaeftspartnernummer) && Objects.equals(geschaeftspartnertyp, addressId.geschaeftspartnertyp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geschaeftspartnernummer, geschaeftspartnertyp);
    }
}
