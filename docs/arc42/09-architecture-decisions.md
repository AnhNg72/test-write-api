# 9. Architekturentscheidungen

## Nachvollziehbare Entscheidungen aus dem Repository
TEST-WRITE-API

| Entscheidung | Begründbare Evidenz |
| --- | --- |
| Nutzung von Camel auf Quarkus | RouteBuilder, Camel-Komponenten und Quarkus-Plugins sind im Inbound-Modul konfiguriert. |
| Ausgabe als BOD-JSON | JSON-Schema wird aus dem gemeinsamen Repository `lis_bridge_contract_bod` bezogen, Mapping erfolgt auf `SyncLHWeatherStationMeasurementBod`. |
| Entkopplung via Kafka | Die Camel-Route publiziert auf `kafka:weather-station`. |
| Helm für Kubernetes-Deployment | Chart und Templates liegen unter `helmchart/`. |
| MkDocs für Projektdokumentation | `mkdocs.yml`, `pyproject.toml` und `deploy-docs.yml` bauen und veröffentlichen die Dokumentation. |