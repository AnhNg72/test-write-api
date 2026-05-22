package com.localintegrationapps.simpleapi.io.repository.mcr;

import com.localintegrationapps.simpleapi.io.entity.mcr.McrOrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class McrOrdersRepository {
    private Logger log = LoggerFactory.getLogger(McrOrdersRepository.class);

    public static final String UPSERT_SQL = "MERGE INTO MCR.ORDERS AS T USING (VALUES (?,?,?,?,?,?,?,?,?,?)) AS S \n" +
            "(bestellnummer,artikelnummer,lieferantennummer,bestellungsdatum,artikelpositionsnummer,artikelnummer_des_lieferanten,einkaufspreis,losgroesse,mengeneinheit,datensatztyp) \n" +
            " ON (T.bestellnummer = S.bestellnummer AND T.lieferantennummer = S.lieferantennummer AND T.artikelpositionsnummer = S.artikelpositionsnummer) \n" +
            " WHEN MATCHED \n" +
            " AND ( \n" +
            " COALESCE(T.artikelnummer,'') <> COALESCE(S.artikelnummer,'') \n" +
            " OR COALESCE(T.bestellungsdatum,'') <> COALESCE(S.bestellungsdatum,'') \n" +
            " OR COALESCE(T.artikelnummer_des_lieferanten,'') <> COALESCE(S.artikelnummer_des_lieferanten,'') \n" +
            " OR COALESCE(T.einkaufspreis,'') <> COALESCE(S.einkaufspreis,'') \n" +
            " OR COALESCE(T.losgroesse,'') <> COALESCE(S.losgroesse,'') \n" +
            " OR COALESCE(T.mengeneinheit,'') <> COALESCE(S.mengeneinheit,'') \n" +
            " OR COALESCE(T.datensatztyp,'') <> COALESCE(S.datensatztyp,'')) \n" +
            " THEN UPDATE SET T.bestellnummer=S.bestellnummer, T.artikelnummer =S.artikelnummer, T.lieferantennummer=S.lieferantennummer, T.bestellungsdatum=S.bestellungsdatum, T.artikelpositionsnummer=S.artikelpositionsnummer, T.artikelnummer_des_lieferanten =S.artikelnummer_des_lieferanten, T.einkaufspreis =S.einkaufspreis, T.losgroesse =S.losgroesse, T.mengeneinheit =S.mengeneinheit, T.datensatztyp =S.datensatztyp, T.updated_at = CURRENT_TIMESTAMP \n" +
            " WHEN NOT MATCHED THEN INSERT (bestellnummer,artikelnummer,lieferantennummer,bestellungsdatum,artikelpositionsnummer,artikelnummer_des_lieferanten,einkaufspreis,losgroesse,mengeneinheit,datensatztyp) \n" +
            " VALUES (S.bestellnummer,S.artikelnummer,S.lieferantennummer,S.bestellungsdatum,S.artikelpositionsnummer,S.artikelnummer_des_lieferanten,S.einkaufspreis,S.losgroesse,S.mengeneinheit,S.datensatztyp);";


    private final JdbcTemplate jdbc;

    public McrOrdersRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void upsertBatch(List<McrOrderEntity> orders) {
        jdbc.batchUpdate(UPSERT_SQL, orders, 10, (ps, it) -> {
            ps.setString(1, trim(it.getBestellnummer()));
            ps.setString(2, trim(it.getArtikelnummer()));
            ps.setString(3, trim(it.getLieferantennummer()));
            ps.setString(4, trim(it.getBestellungsdatum()));
            ps.setString(5, trim(it.getArtikelpositionsnummer()));
            ps.setString(6, trim(it.getArtikelnummer_des_lieferanten()));
            ps.setString(7, trim(it.getEinkaufspreis()));
            ps.setString(8, trim(it.getLosgroesse()));
            ps.setString(9, trim(it.getMengeneinheit()));
            ps.setString(10, trim(it.getDatensatztyp()));
        });

        log.info("The upsert command is: {}", UPSERT_SQL);
        log.info("The upsert batch is: {}", orders);
    }

    public static String trim(String s) {
        return s == null ? null : s.trim();
    }

}
