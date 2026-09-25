# 1. Einführung und Ziele

## Aufgabenstellung

Dieses Repository enthält den TEST-WRITE-API-Adapter im MCC-Bridge-Umfeld. Der derzeit klar belegbare Schwerpunkt liegt auf dem **Inbound-Pfad**:

1. Wetterstationsdaten werden als Datei `RECENT.TXT` von einem FTP-Server gelesen.
2. Jede Zeile wird geparst, validiert und in ein BOD-Format überführt.
3. Gültige Datensätze werden als JSON auf das Kafka-Topic `weather-station` publiziert.

## Nutzen

Die Implementierung entkoppelt den dateibasierten Eingangskanal von nachgelagerten Konsumenten, 
indem die Messwerte zunächst auf Kafka veröffentlicht werden.

## Qualitäts- und Dokumentationsziele

- schneller technischer Einstieg für Entwickler
- nachvollziehbare Beschreibung des aktuellen Inbound-Datenflusses

## Abgrenzung

Nicht belastbar aus dem Repository ableitbar sind:

- fachliche Anforderungen außerhalb des Dateiimports
- eine tatsächlich implementierte Datenbankschreibstrecke

Diese Punkte werden in der Dokumentation daher nur als `TODO` markiert.
