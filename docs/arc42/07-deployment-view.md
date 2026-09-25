# 7. Verteilungssicht

## Lokale Entwicklungsumgebung

```likec4-view project=weather-station color-scheme=light
deployment-local
```
TEST-WRITE-API

Die lokale Umgebung basiert auf `dev/docker/compose-common.yml` und `dev/docker/compose-inbound.yml` und stellt
Kafka, Kafka UI, FTP sowie einen Python-basierten Dummy-Datengenerator bereit. Die Anwendung selbst läuft lokal
per Gradle im Quarkus-Dev-Modus.

## Kubernetes / Helm

```likec4-view project=weather-station color-scheme=light
deployment-k8s
```

## Helm Chart

- ein Deployment mit einer Replik
- ein `ClusterIP`-Service auf Port 8080
- Konfiguration per ConfigMap (Kafka-Bootstrap, Dead-Letter-Topic, FTP-Host/Pfad, Cluster-Name, ...)
- FTP-Zugangsdaten werden aktiv aus dem Secret `mcc-weatherstation-ftp-secret` als `FTP_USERNAME` /
  `FTP_PASSWORD` genutzt
- Resource Requests/Limits für CPU und Speicher
- Liveness-/Readiness-Probes gegen `/q/health/live` und `/q/health/ready`
- Kafka-Topics (`Bod.WeatherstationMeasurement`, `Bod.WeatherstationMeasurement.DeadLetter`) werden per
  Strimzi-`KafkaTopic`-Custom-Resource verwaltet