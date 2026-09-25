# Entwicklung und Betrieb

## Voraussetzungen

- JDK 25
- Docker bzw. Docker Compose
- Gradle Wrapper (`gradlew` bzw. `gradlew.bat`)

Für die Dokumentation zusätzlich:

- Python 3.12
- `uv`

## Build und Tests

| Kommando | Zweck |
| --- | --- |
| `.\gradlew build` | Kompilieren, Tests ausführen und paketieren |
| `.\gradlew test` | Tests ausführen |
| `.\gradlew :Inbound:quarkusDev` | Inbound-Adapter im Dev-Modus starten |
| `.\gradlew clean` | Build-Artefakte entfernen |

## Lokaler Start im Dev-Modus

### Anwendung im Dev-Modus

- Windows: `.\dev\scripts\start.ps1`
- macOS / Linux: `./dev/scripts/start.sh`

Die Startskripte führen aktuell `clean quarkusDev` im Wurzelprojekt aus.

### Lokale Infrastruktur

Die lokale Docker-Compose-Datei liegt unter `misc/docker/compose.yaml` und startet:

- Kafka und Kafka UI als Integration Layer
- FTP-Server als Wetterstation (Quelle)
- Microsoft SQL Server 2022 (Ziel)

Start:

```powershell
docker compose -f .\misc\docker\compose.yaml up -d
```

### Relevante lokale Endpunkte

| Zweck | Adresse |
| --- | --- |
| Kafka Broker | `localhost:9092` |
| Kafka UI | `http://localhost:9080` |
| MSSQL Server | `localhost:1433` |
| FTP Server | `localhost:21` |
| Swagger UI | `http://localhost:8080/q/swagger-ui` |
| Health | `http://localhost:8080/q/health` |
| Liveness | `http://localhost:8080/q/health/live` |
| Readiness | `http://localhost:8080/q/health/ready` |

## Testdaten und Datenfluss

Der Adapter pollt eine Datei `RECENT.TXT` per FTP.
Konfiguriert ist `ftp.fileName=RECENT.TXT`.

Für lokale Datenflusstests:

- Tab-getrennte Datei `RECENT.TXT` in das FTP-Datenverzeichnis legen.
- Das Compose-Setup mountet `./ftp-data` in den FTP-Container.

## CI/CD und Auslieferung

- `build-pipeline.yml` baut das Modul `Inbound` und triggert anschließend den Docker-Build.
- `helm-pipeline.yml` paketiert und veröffentlicht das Helm-Chart als OCI-Artefakt.
- `deploy-docs.yml` baut die MkDocs-Seite strikt und veröffentlicht sie auf GitHub Pages.
