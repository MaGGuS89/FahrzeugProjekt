package evb.marcus.fahrzeugprojekt.werkstatt;

import evb.marcus.fahrzeugprojekt.fahrzeuge.Fahrzeug;
import evb.marcus.fahrzeugprojekt.fahrzeuge.Auto;

/**
 * Werkstatt führt Prüfungen an beliebigen Fahrzeugen durch.
 *
 * OOP-Dokumentation:
 * - Polymorphie: Die Methode arbeitet mit dem Obertyp Fahrzeug.
 *   Zur Laufzeit wird die konkrete starten()-Implementierung der übergebenen Unterklasse aufgerufen.
 * - Kapselung: Zugriff auf spezifische Eigenschaften (z. B. Türen) erfolgt über Getter.
 */

public class Werkstatt {

    /**
     * Prüft ein Fahrzeug durch Starten, Beschleunigen und Tanken.
     * Verwendet ausschließlich den Typ Fahrzeug (kein Wissen über konkrete Unterklassen nötig).
     */

    public void pruefeFahrzeug(Fahrzeug f) {
        System.out.println("Werkstatt prüft: " + f.getMarke());
        // Zusätzliche Ausgabe für Autos
        if (f instanceof Auto auto) {
            System.out.println("Dieses Auto ist ein " + auto.getAnzahlTueren() + " Türer.");
        }
        f.starten();                 /// Polymorpher Aufruf
        f.tanken(10);           /// Gemeinsame Methode
        f.beschleunigen(30);   /// Gemeinsame Methode

    }
}