# Entwickler-How-to

## Dokumentation starten

```shell
uv sync --frozen --group docs
npm ci
uv run --frozen --group docs mkdocs serve
```

## Voraussetzungen für die Dokumentation

- Python 3.12, `uv` und Node.js müssen installiert sein.
- Die Dokumentationsabhängigkeiten sind in `../pyproject.toml` definiert und durch `uv.lock` reproduzierbar festgeschrieben.
- Die Diagramme werden über LikeC4 lokal erzeugt (siehe unten).

## LikeC4-Diagramme

- LikeC4-Projekte benötigen eine `likec4.config.json`. Die Konfiguration in `diagrams/src/` definiert das Projekt `weather-station` und erfasst die dort abgelegten `.c4`-Dateien.
- Diagramme werden ohne Vorab-Export direkt in Markdown eingebettet. Aus einer beliebigen Dokumentationsseite wird eine View mit ihrer ID und dem Projekt eingebunden: