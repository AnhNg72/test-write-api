package com.localintegrationapps.simpleapi.io.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderId implements Serializable {

    private String bestellnummer;
    private String lieferantennummer;
    private String artikelpositionsnummer;

    // default constructor
    public OrderId(String bestellnummer, String lieferantennummer, String artikelpositionsnummer) {
        this.bestellnummer = bestellnummer;
        this.lieferantennummer = lieferantennummer;
        this.artikelpositionsnummer = artikelpositionsnummer;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderId that = (OrderId) o;
        return Objects.equals(bestellnummer, that.bestellnummer) && Objects.equals(lieferantennummer, that.lieferantennummer) && Objects.equals(artikelpositionsnummer, that.artikelpositionsnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestellnummer, lieferantennummer, artikelpositionsnummer);
    }
}
