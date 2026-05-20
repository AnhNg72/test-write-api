package com.localintegrationapps.simpleapi.dto;

public class AddressDTO {

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
    private String geschaeftspartnertyp;
    private String datensatztyp;

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
}
