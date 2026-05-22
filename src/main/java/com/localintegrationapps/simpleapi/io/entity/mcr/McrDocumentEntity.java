package com.localintegrationapps.simpleapi.io.entity.mcr;

import com.localintegrationapps.simpleapi.io.entity.BaseDocument;
import com.localintegrationapps.simpleapi.io.entity.DocumentId;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="documents", schema="mcr")
@IdClass(DocumentId.class)
public class McrDocumentEntity extends BaseDocument {}


//    private String belegnummer;
//    @Id
//    private String bestellnummer;
//    private String belegsdatum;
//    @Id
//    private String belegtyp;
//    private String artikelnummer;
//    @Id
//    private String artikelpositionsnummer;
//    private String datensatztyp;
//
//    @CreationTimestamp
//    @Column(name="createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @CreationTimestamp
//    @Column(name="updatedAt", insertable = false, updatable = true)
//    private LocalDateTime updatedAt ;
//
//    public String getBelegnummer() {
//        return belegnummer;
//    }
//
//    public void setBelegnummer(String belegnummer) {
//        this.belegnummer = belegnummer;
//    }
//
//    public String getBestellnummer() {
//        return bestellnummer;
//    }
//
//    public void setBestellnummer(String bestellnummer) {
//        this.bestellnummer = bestellnummer;
//    }
//
//    public String getBelegsdatum() {
//        return belegsdatum;
//    }
//
//    public void setBelegsdatum(String belegsdatum) {
//        this.belegsdatum = belegsdatum;
//    }
//
//    public String getBelegtyp() {
//        return belegtyp;
//    }
//
//    public void setBelegtyp(String belegtyp) {
//        this.belegtyp = belegtyp;
//    }
//
//    public String getArtikelnummer() {
//        return artikelnummer;
//    }
//
//    public void setArtikelnummer(String artikelnummer) {
//        this.artikelnummer = artikelnummer;
//    }
//
//    public String getArtikelpositionsnummer() {
//        return artikelpositionsnummer;
//    }
//
//    public void setArtikelpositionsnummer(String artikelpositionsnummer) {
//        this.artikelpositionsnummer = artikelpositionsnummer;
//    }
//
//    public String getDatensatztyp() {
//        return datensatztyp;
//    }
//
//    public void setDatensatztyp(String datensatztyp) {
//        this.datensatztyp = datensatztyp;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}
