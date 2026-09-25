# 3. Kontext und Scope

## Fachlicher Kontext
TEST-WRITE-API

Der aktuelle Scope dieses Repositories umfasst das Einlesen und Aufbereiten von Wetterstationsmesswerten aus einer 
FTP-Datei und deren Übergabe an Kafka.

`TODO`: Welches fachliche Zielsystem die Kafka-Nachrichten weiterverarbeitet, ist im Repository nicht dokumentiert.
Vermutlich wird hier noch ein Outbound-Adapter implementiert für die Weiterleitung an eine MS-SQL-Datenbank.

## Technischer Kontext

Externe technische Nachbarn:

- FTP-Server als Quelle für `RECENT.TXT`
- Kafka als Ziel für aufbereitete Messdaten (inkl. separatem Dead-Letter-Topic für abgelehnte Datensätze)
- Entwickler bzw. Operatoren über Swagger UI und Health-Endpunkte

`TODO`: Ein früher im Compose-Setup vorhandener lokaler MSSQL-Server ist im aktuellen `dev/docker`-Setup nicht mehr
enthalten. Ob ein Outbound-Adapter mit MS-SQL-Anbindung weiterhin geplant ist, ist im Repository nicht dokumentiert.

## Systemkontext

```likec4-view project=weather-station color-scheme=light
system-context
```
