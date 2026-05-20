package com.localintegrationapps.simpleapi.dto;

public class DocumentDTO {

    private String belegnummer;
    private String bestellnummer;
    private String belegsdatum;
    private String belegtyp;
    private String artikelnummer;
    private String artikelpositionsnummer;
    private String datensatztyp;

    public String getBelegnummer() {
        return belegnummer;
    }

    public void setBelegnummer(String belegnummer) {
        this.belegnummer = belegnummer;
    }

    public String getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(String bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getBelegsdatum() {
        return belegsdatum;
    }

    public void setBelegsdatum(String belegsdatum) {
        this.belegsdatum = belegsdatum;
    }

    public String getBelegtyp() {
        return belegtyp;
    }

    public void setBelegtyp(String belegtyp) {
        this.belegtyp = belegtyp;
    }

    public String getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getArtikelpositionsnummer() {
        return artikelpositionsnummer;
    }

    public void setArtikelpositionsnummer(String artikelpositionsnummer) {
        this.artikelpositionsnummer = artikelpositionsnummer;
    }

    public String getDatensatztyp() {
        return datensatztyp;
    }

    public void setDatensatztyp(String datensatztyp) {
        this.datensatztyp = datensatztyp;
    }
}
