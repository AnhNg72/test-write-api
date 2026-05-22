package com.localintegrationapps.simpleapi.io.repository.lwn;

import com.localintegrationapps.simpleapi.io.entity.lwn.LwnComponentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LwnComponentsRepository {
    private Logger log = LoggerFactory.getLogger(LwnComponentsRepository.class);

    public static final String UPSERT_SQL = "MERGE INTO LWN.COMPONENTS AS T USING (VALUES (?,?,?,?,?,?,?,?,?,?)) AS S \n" +
            "(artikelnummer,satzart,stuecklistenelement,beschreibung,mengeneinheit,theoretische_menge,preis_kosten_fuer_1000_me,zuschlagsfaktor,fiktive_stueckliste,datensatztyp) \n" +
            " ON (T.artikelnummer = S.artikelnummer AND T.stuecklistenelement = S.stuecklistenelement) \n" +
            " WHEN MATCHED \n" +
            " AND ( \n" +
            " COALESCE(T.satzart,'') <> COALESCE(S.satzart,'') \n" +
            " OR COALESCE(T.beschreibung,'') <> COALESCE(S.beschreibung,'') \n" +
            " OR COALESCE(T.mengeneinheit,'') <> COALESCE(S.mengeneinheit,'') \n" +
            " OR COALESCE(T.theoretische_menge,'') <> COALESCE(S.theoretische_menge,'') \n" +
            " OR COALESCE(T.preis_kosten_fuer_1000_me,'') <> COALESCE(S.preis_kosten_fuer_1000_me,'') \n" +
            " OR COALESCE(T.zuschlagsfaktor,'') <> COALESCE(S.zuschlagsfaktor,'') \n" +
            " OR COALESCE(T.fiktive_stueckliste,'') <> COALESCE(S.fiktive_stueckliste,'') \n" +
            " OR COALESCE(T.datensatztyp,'') <> COALESCE(S.datensatztyp,'')) \n" +
            " THEN UPDATE SET T.satzart =S.satzart, T.beschreibung=S.beschreibung, T.mengeneinheit=S.mengeneinheit, T.theoretische_menge=S.theoretische_menge, " +
            "T.preis_kosten_fuer_1000_me =S.preis_kosten_fuer_1000_me, T.zuschlagsfaktor =S.zuschlagsfaktor, T.fiktive_stueckliste =S.fiktive_stueckliste, T.datensatztyp =S.datensatztyp, T.updated_at = CURRENT_TIMESTAMP \n" +
            " WHEN NOT MATCHED THEN INSERT (artikelnummer,satzart,stuecklistenelement,beschreibung,mengeneinheit,theoretische_menge,preis_kosten_fuer_1000_me,zuschlagsfaktor,fiktive_stueckliste,datensatztyp) \n" +
            " VALUES (S.artikelnummer,S.satzart,S.stuecklistenelement,S.beschreibung,S.mengeneinheit,S.theoretische_menge,S.preis_kosten_fuer_1000_me,S.zuschlagsfaktor,S.fiktive_stueckliste,S.datensatztyp);";


    private final JdbcTemplate jdbc;

    public LwnComponentsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void upsertBatch(List<LwnComponentEntity> components) {
        jdbc.batchUpdate(UPSERT_SQL, components, 10, (ps, it) -> {
            ps.setString(1, trim(it.getArtikelnummer()));
            ps.setString(2, trim(it.getSatzart()));
            ps.setString(3, trim(it.getStuecklistenelement()));
            ps.setString(4, trim(it.getBeschreibung()));
            ps.setString(5, trim(it.getMengeneinheit()));
            ps.setString(6, trim(it.getTheoretische_menge()));
            ps.setString(7, trim(it.getPreis_kosten_fuer_1000_me()));
            ps.setString(8, trim(it.getZuschlagsfaktor()));
            ps.setString(9, trim(it.getFiktive_stueckliste()));
            ps.setString(10, trim(it.getDatensatztyp()));

        });

        log.info("The upsert command is: {}", UPSERT_SQL);
        log.info("The upsert batch is: {}", components);
    }

    public static String trim(String s) {
        return s == null ? null : s.trim();
    }
}
