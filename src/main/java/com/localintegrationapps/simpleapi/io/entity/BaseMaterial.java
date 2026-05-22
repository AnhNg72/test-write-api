package com.localintegrationapps.simpleapi.io.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseMaterial {
    @Id
    private String artikelnummer;
    private String aktives_teil;
    private String eigenfertigung_oder_zukaufteil;
    private String artikelbezeichnung_teil_1;
    private String artikelbezeichnung_teil_2;
    private String zolltarifnummer;
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

    public String getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getAktives_teil() {
        return aktives_teil;
    }

    public void setAktives_teil(String aktives_teil) {
        this.aktives_teil = aktives_teil;
    }

    public String getEigenfertigung_oder_zukaufteil() {
        return eigenfertigung_oder_zukaufteil;
    }

    public void setEigenfertigung_oder_zukaufteil(String eigenfertigung_oder_zukaufteil) {
        this.eigenfertigung_oder_zukaufteil = eigenfertigung_oder_zukaufteil;
    }

    public String getArtikelbezeichnung_teil_1() {
        return artikelbezeichnung_teil_1;
    }

    public void setArtikelbezeichnung_teil_1(String artikelbezeichnung_teil_1) {
        this.artikelbezeichnung_teil_1 = artikelbezeichnung_teil_1;
    }

    public String getArtikelbezeichnung_teil_2() {
        return artikelbezeichnung_teil_2;
    }

    public void setArtikelbezeichnung_teil_2(String artikelbezeichnung_teil_2) {
        this.artikelbezeichnung_teil_2 = artikelbezeichnung_teil_2;
    }

    public String getZolltarifnummer() {
        return zolltarifnummer;
    }

    public void setZolltarifnummer(String zolltarifnummer) {
        this.zolltarifnummer = zolltarifnummer;
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


