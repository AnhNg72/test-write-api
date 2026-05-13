package com.localintegrationapps.simpleapi.io;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialRepository  {

    public static final String UPSERT_SQL = "MERGE INTO MATERIAL AS T USING (VALUES (?,?,?,?,?,?,?,?,?,?,?)) AS S \n" +
            "(artikelnummer,aktives_teil,eigenfertigung_oder_zukaufteil,artikelbezeichnung_teil_1,artikelbezeichnung_teil_2,zolltarifnummer,einkaufspreis,losgroesse,mengeneinheit,kalkulationsrelevant,datensatztyp) \n" +
            " ON T.artikelnummer = S.artikelnummer \n" +
            " WHEN MATCHED \n" +
            " AND ( \n" +
            " COALESCE(T.artikelnummer,'') <> COALESCE(S.artikelnummer,'') \n" +
            " OR COALESCE(T.aktives_teil,'') <> COALESCE(S.aktives_teil,'') \n" +
            " OR COALESCE(T.eigenfertigung_oder_zukaufteil,'') <> COALESCE(S.eigenfertigung_oder_zukaufteil,'') \n" +
            " OR COALESCE(T.artikelbezeichnung_teil_1,'') <> COALESCE(S.artikelbezeichnung_teil_1,'') \n" +
            " OR COALESCE(T.artikelbezeichnung_teil_2,'') <> COALESCE(S.artikelbezeichnung_teil_2,'') \n" +
            " OR COALESCE(T.zolltarifnummer,'') <> COALESCE(S.zolltarifnummer,'') \n" +
            " OR COALESCE(T.einkaufspreis,'') <> COALESCE(S.einkaufspreis,'') \n" +
            " OR COALESCE(T.losgroesse,'') <> COALESCE(S.losgroesse,'') \n" +
            " OR COALESCE(T.mengeneinheit,'') <> COALESCE(S.mengeneinheit,'') \n" +
            " OR COALESCE(T.kalkulationsrelevant,'') <> COALESCE(S.kalkulationsrelevant,'') \n" +
            " OR COALESCE(T.datensatztyp,'') <> COALESCE(S.datensatztyp,'')) \n" +
            " THEN UPDATE SET T.artikelnummer =S.artikelnummer, T.aktives_teil =S.aktives_teil, T.eigenfertigung_oder_zukaufteil =S.eigenfertigung_oder_zukaufteil, T.artikelbezeichnung_teil_1 =S.artikelbezeichnung_teil_1, T.artikelbezeichnung_teil_2 =S.artikelbezeichnung_teil_2, T.zolltarifnummer =S.zolltarifnummer, T.einkaufspreis =S.einkaufspreis, T.losgroesse =S.losgroesse, T.mengeneinheit =S.mengeneinheit, T.kalkulationsrelevant =S.kalkulationsrelevant, T.datensatztyp =S.datensatztyp, T.updated_at = CURRENT_TIMESTAMP \n" +
            " WHEN NOT MATCHED THEN INSERT (artikelnummer,aktives_teil,eigenfertigung_oder_zukaufteil,artikelbezeichnung_teil_1,artikelbezeichnung_teil_2,zolltarifnummer,einkaufspreis,losgroesse,mengeneinheit,kalkulationsrelevant,datensatztyp) \n" +
            " VALUES (S.artikelnummer,S.aktives_teil,S.eigenfertigung_oder_zukaufteil,S.artikelbezeichnung_teil_1,S.artikelbezeichnung_teil_2,S.zolltarifnummer,S.einkaufspreis,S.losgroesse,S.mengeneinheit,S.kalkulationsrelevant,S.datensatztyp);";

    private final JdbcTemplate jdbc;

    public MaterialRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void upsertBatch(List<MaterialEntity> articles) {
        jdbc.batchUpdate(UPSERT_SQL, articles, 200, (ps, it) -> {
            ps.setString(1, trim(it.getArtikelnummer()));
            ps.setString(2, trim(it.getAktives_teil()));
            ps.setString(3, trim(it.getEigenfertigung_oder_zukaufteil()));
            ps.setString(4, trim(it.getArtikelbezeichnung_teil_1()));
            ps.setString(5, trim(it.getArtikelbezeichnung_teil_2()));
            ps.setString(6, trim(it.getZolltarifnummer()));
            ps.setString(7, trim(it.getEinkaufspreis()));
            ps.setString(8, trim(it.getLosgroesse()));
            ps.setString(9, trim(it.getMengeneinheit()));
            ps.setString(10, trim(it.getKalkulationsrelevant()));
            ps.setString(11, trim(it.getDatensatztyp()));
        });
    }

    public static String trim(String s) {
        return s == null ? null : s.trim();
    }

}
