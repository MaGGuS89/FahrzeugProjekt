package evb.marcus.fahrzeugprojekt.fahrzeuge;

/**
 * Unterklasse von Fahrzeug, die ein Motorrad konkretisiert.
 *
 * OOP-Dokumentation:
 * - Vererbung: Motorrad extends Fahrzeug.
 * - Polymorphie: eigenes Startverhalten (Kickstart) als Implementierung der abstrakten Methode.
 */

public class Motorrad extends Fahrzeug {

    public Motorrad(String marke, int baujahr, double tankinhalt, double tankinhaltMax) {
        super(marke, baujahr, tankinhalt, tankinhaltMax);
    }


    @Override
    public void starten() {
        System.out.println("Motorrad " + getMarke() + " (BJ " + getBaujahr() + ") startet mit Kickstart.");
    }
}