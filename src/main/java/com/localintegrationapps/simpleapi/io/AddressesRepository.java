package com.localintegrationapps.simpleapi.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressesRepository {
    private Logger log = LoggerFactory.getLogger(AddressesRepository.class);

    public static final String UPSERT_SQL = "MERGE INTO ADDRESSES AS T USING (VALUES (?,?,?,?,?,?,?,?,?,?,?,?)) AS S \n" +
            "(geschaeftspartnernummer,name1,name2,strasse,ort,postfach,plz_strasse,plz_postfach,land_iso_code,sprachschluessel,geschaeftspartnertyp,datensatztyp) \n" +
            " ON (T.geschaeftspartnernummer = S.geschaeftspartnernummer AND T.geschaeftspartnertyp = S.geschaeftspartnertyp) \n" +
            " WHEN MATCHED \n" +
            " AND ( \n" +
            " COALESCE(T.name1,'') <> COALESCE(S.name1,'') \n" +
            " OR COALESCE(T.name2,'') <> COALESCE(S.name2,'') \n" +
            " OR COALESCE(T.strasse,'') <> COALESCE(S.strasse,'') \n" +
            " OR COALESCE(T.ort,'') <> COALESCE(S.ort,'') \n" +
            " OR COALESCE(T.postfach,'') <> COALESCE(S.postfach,'') \n" +
            " OR COALESCE(T.plz_strasse,'') <> COALESCE(S.plz_strasse,'') \n" +
            " OR COALESCE(T.plz_postfach,'') <> COALESCE(S.plz_postfach,'') \n" +
            " OR COALESCE(T.land_iso_code,'') <> COALESCE(S.land_iso_code,'') \n" +
            " OR COALESCE(T.sprachschluessel,'') <> COALESCE(S.sprachschluessel,'') \n" +
            " OR COALESCE(T.datensatztyp,'') <> COALESCE(S.datensatztyp,'')) \n" +
            " THEN UPDATE SET T.name1=S.name1, T.name2 =S.name2, T.strasse=S.strasse, T.ort=S.ort, T.postfach=S.postfach, T.plz_strasse =S.plz_strasse, T.plz_postfach =S.plz_postfach, T.land_iso_code =S.land_iso_code, T.sprachschluessel =S.sprachschluessel, T.datensatztyp =S.datensatztyp, T.updated_at = CURRENT_TIMESTAMP \n" +
            " WHEN NOT MATCHED THEN INSERT (geschaeftspartnernummer,name1,name2,strasse,ort,postfach,plz_strasse,plz_postfach,land_iso_code,sprachschluessel,geschaeftspartnertyp,datensatztyp) \n" +
            " VALUES (S.geschaeftspartnernummer,S.name1,S.name2,S.strasse,S.ort,S.postfach,S.plz_strasse,S.plz_postfach,S.land_iso_code,S.sprachschluessel,S.geschaeftspartnertyp,S.datensatztyp);";


    private final JdbcTemplate jdbc;

    public AddressesRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void upsertBatch(List<AddressEntity> addresses) {
        jdbc.batchUpdate(UPSERT_SQL, addresses, 10, (ps, it) -> {
            ps.setString(1, trim(it.getGeschaeftspartnernummer()));
            ps.setString(2, trim(it.getName1()));
            ps.setString(3, trim(it.getName2()));
            ps.setString(4, trim(it.getStrasse()));
            ps.setString(5, trim(it.getOrt()));
            ps.setString(6, trim(it.getPostfach()));
            ps.setString(7, trim(it.getPlz_strasse()));
            ps.setString(8, trim(it.getPlz_postfach()));
            ps.setString(9, trim(it.getLand_iso_code()));
            ps.setString(10, trim(it.getSprachschluessel()));
            ps.setString(11, trim(it.getGeschaeftspartnertyp()));
            ps.setString(12, trim(it.getDatensatztyp()));
        });

        log.info("The upsert command is: {}", UPSERT_SQL);
        log.info("The upsert batch is: {}", addresses);
    }

    public static String trim(String s) {
        return s == null ? null : s.trim();
    }

}
