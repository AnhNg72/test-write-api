# 8. Querschnittskonzepte

## Konfiguration
TEST-WRITE-API

- Quarkus-Konfiguration liegt unter `inbound`.
- Relevante Properties betreffen Logging, HTTP-Grenzen, OpenAPI, Kafka und FTP.
- Dev-spezifische Dev-Overrides liegen in `application-dev.properties`.

## Observability

- strukturierte Console-Logs enthalten `traceId` und `spanId`
- Health-Endpunkte werden sowohl lokal als auch im Helm-Deployment genutzt
- Swagger UI ist explizit aktiviert

## Fehlerbehandlung

Im Code dokumentiert, dass die Fehlerbehandlung noch nicht final ist.

Der aktuelle Stand:

- Parser- und Validierungsfehler führen auf Datensatzebene zu Exceptions
- die Route fängt `Exception` im Verarbeitungspfad ab und loggt Fehlermeldung plus Record-Index

## Vertragsmodell

- Das Ausgabemodell basiert auf BOD-JSON-Schemata aus dem mit LIS gemeinsam genutzten Repository
  `lis_bridge_contract_bod`; nur die benötigten Schemas werden zur Build-Zeit extrahiert.
- Die Klassen werden im Build generiert und in der Coverage ausgeschlossen.
