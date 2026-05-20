package com.localintegrationapps.simpleapi.io;

import java.io.Serializable;
import java.util.Objects;

public class DocumentId implements Serializable {

    private String bestellnummer;
    private String belegtyp;
    private String artikelpositionsnummer;

    // default constructor
    public DocumentId(String bestellnummer, String belegtyp, String artikelpositionsnummer) {
        this.bestellnummer = bestellnummer;
        this.belegtyp = belegtyp;
        this.artikelpositionsnummer = artikelpositionsnummer;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DocumentId that = (DocumentId) o;
        return Objects.equals(bestellnummer, that.bestellnummer) && Objects.equals(belegtyp, that.belegtyp) && Objects.equals(artikelpositionsnummer, that.artikelpositionsnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestellnummer, belegtyp, artikelpositionsnummer);
    }
}
