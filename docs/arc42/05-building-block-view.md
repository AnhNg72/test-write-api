# 5. Bausteinsicht

## Ebene 1

```likec4-view project=weather-station color-scheme=light
component-inbound
```
TEST-WRITE-API

### MainRoute

- definiert die Camel-Routen `ftp-to-kafka`, `process-record` und `dead-letter`
- pollt den FTP-Endpunkt, unmarshalt die Datei und splittet sie in einzelne Zeilen
- setzt Metadaten wie `recordIndex` und den Kafka-Key (Sender-`componentId`)
- behandelt `RecoverableException` mit bis zu 3 Wiederholungen (exponentielles Backoff), bevor der Datensatz
  ins Dead-Letter-Topic geht
- leitet `UnrecoverableException`, Validierungsfehler und unerwartete Exceptions direkt ins Dead-Letter-Topic

### WeatherStationCsvDataFormat

- Camel-`DataFormat`, das die tabgetrennten Zeilen der `RECENT.TXT` mittels Jackson CSV parst
- ersetzt Kommas durch Punkte, um Dezimalwerte im `de_DE`-Format lesbar zu machen
- erzeugt je Zeile ein `WeatherStationRawDto`

### WeatherStationRawDto

- Java-Record mit Jakarta-Bean-Validation-Annotationen (Pflichtfelder, Wertebereiche)
- wird in der Route über den Camel-`bean-validator`-Baustein validiert; es existiert keine separate Validator-Klasse

### WeatherStationMapper

- erzeugt aus dem Rohdatensatz ein `SyncLHWeatherStationMeasurementBod`
- setzt technische Metadaten wie `bodId`, Sender und Erstellungszeitpunkt

### Generierte Vertragsklassen

- die BOD-JSON-Schemata liegen nicht mehr im eigenen Repository, sondern im mit LIS gemeinsam genutzten
  Artefakt-Repository `com.liebherr.bridge:lis_bridge_contract_bod`
- beim Build wird das Artefakt aufgelöst und entpackt; anschließend werden nur die tatsächlich benötigten
  Schemas (`sync-lh-weatherstation-measurement-bod.json`, `bod-common.json`) herausgefiltert
  (siehe `inbound/build.gradle.kts`, Zeile 29 ff.)
- aus diesen gefilterten Schemas erzeugt `jsonSchema2Pojo` die Java-Klassen
- die generierten Klassen liegen zur Compile-Zeit im Package `com.liebherr.bridge.contracts.bod`
