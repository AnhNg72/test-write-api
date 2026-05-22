package com.localintegrationapps.simpleapi.io.entity;

import java.io.Serializable;
import java.util.Objects;

public class ComponentId implements Serializable {

    private String artikelnummer;
    private String stuecklistenelement;

    // default constructor


    public ComponentId(String artikelnummer, String stuecklistenelement) {
        this.artikelnummer = artikelnummer;
        this.stuecklistenelement = stuecklistenelement;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ComponentId stueliId = (ComponentId) o;
        return Objects.equals(artikelnummer, stueliId.artikelnummer) && Objects.equals(stuecklistenelement, stueliId.stuecklistenelement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artikelnummer, stuecklistenelement);
    }
}
