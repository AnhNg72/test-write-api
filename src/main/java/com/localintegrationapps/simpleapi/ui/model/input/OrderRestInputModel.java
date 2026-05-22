package com.localintegrationapps.simpleapi.ui.model.input;

import javax.validation.constraints.NotNull;

public class OrderRestInputModel {

    @NotNull
    private String bestellnummer;
    private String artikelnummer;
    @NotNull
    private String lieferantennummer;
    private String bestellungsdatum;
    @NotNull
    private String artikelpositionsnummer;
    private String artikelnummer_des_lieferanten;
    private String einkaufspreis;
    private String losgroesse;
    private String mengeneinheit;
    private String kalkulationsrelevant;
    private String datensatztyp;

    public String getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(String bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getLieferantennummer() {
        return lieferantennummer;
    }

    public void setLieferantennummer(String lieferantennummer) {
        this.lieferantennummer = lieferantennummer;
    }

    public String getBestellungsdatum() {
        return bestellungsdatum;
    }

    public void setBestellungsdatum(String bestellungsdatum) {
        this.bestellungsdatum = bestellungsdatum;
    }

    public String getArtikelpositionsnummer() {
        return artikelpositionsnummer;
    }

    public void setArtikelpositionsnummer(String artikelpositionsnummer) {
        this.artikelpositionsnummer = artikelpositionsnummer;
    }

    public String getArtikelnummer_des_lieferanten() {
        return artikelnummer_des_lieferanten;
    }

    public void setArtikelnummer_des_lieferanten(String artikelnummer_des_lieferanten) {
        this.artikelnummer_des_lieferanten = artikelnummer_des_lieferanten;
    }

    public String getEinkaufspreis() {
        return einkaufspreis;
    }

    public void setEinkaufspreis(String einkaufspreis) {
        this.einkaufspreis = einkaufspreis;
    }

    public String getLosgroesse() {
        return losgroesse;
    }

    public void setLosgroesse(String losgroesse) {
        this.losgroesse = losgroesse;
    }

    public String getMengeneinheit() {
        return mengeneinheit;
    }

    public void setMengeneinheit(String mengeneinheit) {
        this.mengeneinheit = mengeneinheit;
    }

    public String getKalkulationsrelevant() {
        return kalkulationsrelevant;
    }

    public void setKalkulationsrelevant(String kalkulationsrelevant) {
        this.kalkulationsrelevant = kalkulationsrelevant;
    }

    public String getDatensatztyp() {
        return datensatztyp;
    }

    public void setDatensatztyp(String datensatztyp) {
        this.datensatztyp = datensatztyp;
    }
}
