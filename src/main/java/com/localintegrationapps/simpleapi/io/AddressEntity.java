package com.localintegrationapps.simpleapi.io;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="addresses")
@IdClass(AddressId.class)
public class AddressEntity {

    @Id
    private String geschaeftspartnernummer;
    private String name1;
    private String name2;
    private String strasse;
    private String ort;
    private String postfach;
    private String plz_strasse;
    private String plz_postfach;
    private String land_iso_code;
    private String sprachschluessel;
    @Id
    private String geschaeftspartnertyp;
    private String datensatztyp;

    @CreationTimestamp
    @Column(name="createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreationTimestamp
    @Column(name="updatedAt", insertable = false, updatable = true)
    private LocalDateTime updatedAt ;

    public String getGeschaeftspartnernummer() {
        return geschaeftspartnernummer;
    }

    public void setGeschaeftspartnernummer(String geschaeftspartnernummer) {
        this.geschaeftspartnernummer = geschaeftspartnernummer;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostfach() {
        return postfach;
    }

    public void setPostfach(String postfach) {
        this.postfach = postfach;
    }

    public String getPlz_strasse() {
        return plz_strasse;
    }

    public void setPlz_strasse(String plz_strasse) {
        this.plz_strasse = plz_strasse;
    }

    public String getPlz_postfach() {
        return plz_postfach;
    }

    public void setPlz_postfach(String plz_postfach) {
        this.plz_postfach = plz_postfach;
    }

    public String getLand_iso_code() {
        return land_iso_code;
    }

    public void setLand_iso_code(String land_iso_code) {
        this.land_iso_code = land_iso_code;
    }

    public String getSprachschluessel() {
        return sprachschluessel;
    }

    public void setSprachschluessel(String sprachschluessel) {
        this.sprachschluessel = sprachschluessel;
    }

    public String getGeschaeftspartnertyp() {
        return geschaeftspartnertyp;
    }

    public void setGeschaeftspartnertyp(String geschaeftspartnertyp) {
        this.geschaeftspartnertyp = geschaeftspartnertyp;
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
