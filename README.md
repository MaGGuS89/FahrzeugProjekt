# FahrzeugProjekt 🚗🛵🚚

Ein Java-Konsolenprojekt zur Simulation verschiedener Fahrzeugtypen mit Tanklogik, Werkstattprüfung und Benutzerinteraktion.

## 🔧 Funktionen

- Auswahl zwischen Auto, Motorrad und Lkw
- Benutzerdefinierte Eingabe von Marke, Baujahr, Tankinhalt und Tankvolumen
- Menüsystem mit Optionen:
  - Fahrzeug starten
  - Beschleunigen
  - Tanken (inkl. Überfüllungsschutz)
  - Werkstattprüfung
- Realistische Tanklogik mit Rundung und Kapazitätsgrenzen

## 📁 Projektstruktur

src/ 
└── evb/ 
  └── marcus/ 
    └── fahrzeugprojekt/ 
      ├── Main.java
      └── fahrzeuge/
        ├── Fahrzeug.java
        ├── Auto.java
        ├── Motorrad.java
        ├── Lkw.java
      └── werkstatt/
        ├── Werkstatt.java


## ▶️ Starten

1. Projekt in IntelliJ öffnen
2. `Main.java` ausführen
3. Menüoptionen per Tasteneingabe steuern

## 📚 Lernziele

- Objektorientierte Programmierung (Vererbung, Polymorphie)
- Konsoleninteraktion mit Scanner
- Fehlerbehandlung und Zustandsprüfung
- GitHub-Projektstruktur und Versionskontrolle

## 🛠 Erweiterungsideen (in Arbeit :))

- Verbrauchslogik beim Fahren
- Tankwarnung bei niedrigem Füllstand
- GUI mit Swing oder JavaFX
- Speicherung von Fahrzeugen in Datei oder Datenbank
