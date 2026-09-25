# 6. Laufzeitsicht

## Import eines Wetterstationsfiles

```likec4-view project=weather-station color-scheme=light dynamic-variant=diagram
runtime-sequence
```
TEST-WRITE-API

## Ablaufbeschreibung

1. Camel pollt den FTP-Pfad und liest `RECENT.TXT`.
2. Der Dateiinhalt wird per `WeatherStationCsvDataFormat` (Jackson CSV) in `WeatherStationRawDto`-Zeilen aufgeteilt.
3. Jede Zeile wird über den Camel-`bean-validator` gegen die Jakarta-Bean-Validation-Annotationen von
   `WeatherStationRawDto` validiert.
4. Gültige Datensätze werden von `WeatherStationMapper` in ein `SyncLHWeatherStationMeasurementBod` gemappt,
   JSON-serialisiert und mit dem Sender-`componentId` als Kafka-Key auf `Bod.WeatherstationMeasurement`
   veröffentlicht.
5. `RecoverableException` löst bis zu 3 Wiederholungen mit exponentiellem Backoff aus, bevor der Datensatz ins
   Dead-Letter-Topic (`Bod.WeatherstationMeasurement.DeadLetter`) geht.
6. Validierungsfehler, `UnrecoverableException` und unerwartete Exceptions werden sofort geloggt und ohne
   Wiederholung ins Dead-Letter-Topic geleitet.

## Beobachtungen

- Die Verarbeitung ist datensatzorientiert und nicht transaktional über die gesamte Datei.
- Die FTP-Konfiguration verschiebt verarbeitete Dateien nach `.processed`.
