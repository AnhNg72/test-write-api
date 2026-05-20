package com.localintegrationapps.simpleapi.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentsRepository {
    private Logger log = LoggerFactory.getLogger(OrdersRepository.class);

    public static final String UPSERT_SQL = "MERGE INTO DOCUMENTS AS T USING (VALUES (?,?,?,?,?,?,?)) AS S \n" +
            "(belegnummer,bestellnummer,belegsdatum,belegtyp,artikelnummer,artikelpositionsnummer,datensatztyp) \n" +
            " ON (T.bestellnummer = S.bestellnummer AND T.belegtyp = S.belegtyp AND T.artikelpositionsnummer = S.artikelpositionsnummer) \n" +
            " WHEN MATCHED \n" +
            " AND ( \n" +
            " COALESCE(T.belegnummer,'') <> COALESCE(S.belegnummer,'') \n" +
            " OR COALESCE(T.belegsdatum,'') <> COALESCE(S.belegsdatum,'') \n" +
            " OR COALESCE(T.artikelnummer,'') <> COALESCE(S.artikelnummer,'') \n" +
            " OR COALESCE(T.datensatztyp,'') <> COALESCE(S.datensatztyp,'')) \n" +
            " THEN UPDATE SET T.belegnummer=S.belegnummer, T.bestellnummer =S.bestellnummer, T.belegsdatum=S.belegsdatum, T.belegtyp=S.belegtyp, T.artikelnummer=S.artikelnummer, T.artikelpositionsnummer =S.artikelpositionsnummer, T.datensatztyp =S.datensatztyp, T.updated_at = CURRENT_TIMESTAMP \n" +
            " WHEN NOT MATCHED THEN INSERT (belegnummer,bestellnummer,belegsdatum,belegtyp,artikelnummer,artikelpositionsnummer,datensatztyp) \n" +
            " VALUES (S.belegnummer,S.bestellnummer,S.belegsdatum,S.belegtyp,S.artikelnummer,S.artikelpositionsnummer,S.datensatztyp);";


    private final JdbcTemplate jdbc;

    public DocumentsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void upsertBatch(List<DocumentEntity> documents) {
        jdbc.batchUpdate(UPSERT_SQL, documents, 10, (ps, it) -> {
            ps.setString(1, trim(it.getBelegnummer()));
            ps.setString(2, trim(it.getBestellnummer()));
            ps.setString(3, trim(it.getBelegsdatum()));
            ps.setString(4, trim(it.getBelegtyp()));
            ps.setString(5, trim(it.getArtikelnummer()));
            ps.setString(6, trim(it.getArtikelpositionsnummer()));
            ps.setString(7, trim(it.getDatensatztyp()));
        });

        log.info("The upsert command is: {}", UPSERT_SQL);
        log.info("The upsert batch is: {}", documents);
    }

    public static String trim(String s) {
        return s == null ? null : s.trim();
    }
}
