package com.localintegrationapps.simpleapi.io.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@IdClass(OrderId.class)
public abstract class BaseOrder {
    @Id
    private String bestellnummer;
    private String artikelnummer;
    @Id
    private String lieferantennummer;
    private String bestellungsdatum;
    @Id
    private String artikelpositionsnummer;
    private String artikelnummer_des_lieferanten;
    private String einkaufspreis;
    private String losgroesse;
    private String mengeneinheit;
    private String kalkulationsrelevant;
    private String datensatztyp;

    @CreationTimestamp
    @Column(name="createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreationTimestamp
    @Column(name="updatedAt", insertable = false, updatable = true)
    private LocalDateTime updatedAt ;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}


