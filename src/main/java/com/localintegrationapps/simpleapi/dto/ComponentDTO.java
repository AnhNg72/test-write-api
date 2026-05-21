package com.localintegrationapps.simpleapi.dto;

import java.util.List;

public class ComponentDTO {

    private String artikelnummer;
    private String satzart;
    private String stuecklistenelement;
    private String beschreibung;
    private String mengeneinheit;
    private String theoretische_menge;
    private String preis_kosten_fuer_1000_me;
    private String zuschlagsfaktor;
    private String fiktive_stueckliste;
    private String datensatztyp;

    public String getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getSatzart() {
        return satzart;
    }

    public void setSatzart(String satzart) {
        this.satzart = satzart;
    }

    public String getStuecklistenelement() {
        return stuecklistenelement;
    }

    public void setStuecklistenelement(String stuecklistenelement) {
        this.stuecklistenelement = stuecklistenelement;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getMengeneinheit() {
        return mengeneinheit;
    }

    public void setMengeneinheit(String mengeneinheit) {
        this.mengeneinheit = mengeneinheit;
    }

    public String getTheoretische_menge() {
        return theoretische_menge;
    }

    public void setTheoretische_menge(String theoretische_menge) {
        this.theoretische_menge = theoretische_menge;
    }

    public String getPreis_kosten_fuer_1000_me() {
        return preis_kosten_fuer_1000_me;
    }

    public void setPreis_kosten_fuer_1000_me(String preis_kosten_fuer_1000_me) {
        this.preis_kosten_fuer_1000_me = preis_kosten_fuer_1000_me;
    }

    public String getZuschlagsfaktor() {
        return zuschlagsfaktor;
    }

    public void setZuschlagsfaktor(String zuschlagsfaktor) {
        this.zuschlagsfaktor = zuschlagsfaktor;
    }

    public String getFiktive_stueckliste() {
        return fiktive_stueckliste;
    }

    public void setFiktive_stueckliste(String fiktive_stueckliste) {
        this.fiktive_stueckliste = fiktive_stueckliste;
    }

    public String getDatensatztyp() {
        return datensatztyp;
    }

    public void setDatensatztyp(String datensatztyp) {
        this.datensatztyp = datensatztyp;
    }
}
