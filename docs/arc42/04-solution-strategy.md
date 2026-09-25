# 4. Lösungsstrategie

## Aktueller Lösungsansatz
TEST-WRITE-API

Der Inbound-Adapter setzt auf einen schlanken, dateibasierten Importpfad:

- Polling einer einzelnen FTP-Datei
- Verarbeitung zeilenweise statt als kompletter Batch im Speicher
- explizite Validierung vor der Weitergabe
- Veröffentlichung standardisierter BOD-Nachrichten auf Kafka

## Technische Leitentscheidungen

### Apache Camel für den Integrationsfluss

Camel kapselt Polling, Splitten, Fehlerbehandlung und den Kafka-Producer in einer Route.

### JSON-Schema als Vertragsquelle

Die BOD-Klassen werden per `jsonSchema2Pojo` aus JSON-Schemata generiert, die aus dem mit LIS gemeinsam genutzten
Repository `com.liebherr.bridge:lis_bridge_contract_bod` bezogen werden (siehe `inbound/build.gradle.kts`).
Dadurch ist das Ausgabeschema zentral gepflegt und muss nicht im eigenen Repository dupliziert werden.

### Entkopplung über Kafka

Der Adapter kennt im sichtbaren Code nur das Ziel-Topic `weather-station`. 
Nachgelagerte Verarbeitung wird dadurch vom Dateieingang entkoppelt.

### Pragmatische Dokumentationsstrategie

MkDocs und LikeC4 werden genutzt, um Architektur und Abläufe leichtgewichtig, aber reproduzierbar im Repository 
zu pflegen.
