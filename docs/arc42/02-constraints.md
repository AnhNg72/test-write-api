# 2. Randbedingungen

## Technische Randbedingungen
TEST-WRITE-API

| Thema | Feststellung |
| --- | --- |
| Runtime | Quarkus 3.38.x |
| Sprache | Java 25 |
| Build | Gradle mit Kotlin DSL |
| Integrationsframework | Apache Camel auf Quarkus |
| Messaging | Kafka |
| API-Dokumentation | SmallRye OpenAPI / Swagger UI |
| Health | SmallRye Health |
| Dokumentation | MkDocs Material, LikeC4 |

## Organisatorische und infrastrukturelle Randbedingungen

- Das Projekt verwendet gemeinsame Liebherr-Gradle-Plugins für Checkstyle, PMD, SpotBugs, JaCoCo, Observability und Integrationstests.
- Abhängigkeiten und Plugins werden teilweise aus GitHub Packages geladen; dafür sind Zugangsdaten erforderlich.
- Die Dokumentation wird per GitHub Actions mit `mkdocs build --strict` gebaut.

## Sicherheits- und Betriebsrandbedingungen

- Das Helm-Deployment erzwingt `runAsNonRoot`, entfernt Linux-Capabilities und verwendet Health-Probes auf `/q/health/live` und `/q/health/ready`.
- Die Konfiguration deaktiviert Camel Auto-Configuration-Log-Summaries, um sensible Informationen nicht unnötig zu loggen.
