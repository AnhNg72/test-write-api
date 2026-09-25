# 11. Risiken und technische Schulden

## Sichtbare Risiken
TEST-WRITE-API

- Die Fehlerbehandlung ist laut Code und README noch nicht final.
- Das lokale Setup enthält MSSQL, ohne dass im sichtbaren Inbound-Code eine Nutzung erkennbar ist.

## Offene Punkte

- `TODO`: Zielsysteme und fachliche Verantwortung hinter dem Kafka-Topic dokumentieren.
- `TODO`: Produktive Konfiguration, sobald vorhanden, für FTP, Kafka und Secrets dokumentieren.
- `TODO`: Gewünschte Fehlerstrategie für fehlerhafte Einzelzeilen und Dateiwiederverarbeitung festlegen.
