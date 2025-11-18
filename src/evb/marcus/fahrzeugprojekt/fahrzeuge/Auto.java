package evb.marcus.fahrzeugprojekt.fahrzeuge;

/**
 * Unterklasse von Fahrzeug, die ein Auto konkretisiert.
 *
 * OOP-Dokumentation:
 * - Vererbung: Auto extends Fahrzeug, übernimmt Eigenschaften/Methoden und ergänzt spezifische.
 * - Abstrakte Methode starten(): wird mit auto-spezifischem Verhalten implementiert (Polymorphie).
 */

public class Auto extends Fahrzeug {

    /// Zusätzliche Eigenschaft nur für Auto
    private final int anzahlTueren;

    public Auto(String marke, int baujahr, double tankinhalt, double tankinhaltMax, int anzahlTueren) {
        super(marke, baujahr, tankinhalt, tankinhaltMax);
        this.anzahlTueren = Math.max(1, anzahlTueren);
    }


    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    @Override
    public void starten() {
        System.out.println("Auto " + getMarke() + " (BJ " + getBaujahr() + ") startet mit Zündschlüssel.");
    }

    @Override
    public String toString() {
        return super.toString() + " mit " + anzahlTueren + " Türen";
    }

    @Override
    public double getVerbrauch() {
        return 7.0;
    }

    @Override
    public String getAsciiSymbol() {
        return "   __\n _/[]\\_\n(o -- o)>";
    }
}