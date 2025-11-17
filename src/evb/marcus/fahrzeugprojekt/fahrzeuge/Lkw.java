package evb.marcus.fahrzeugprojekt.fahrzeuge;

/**
 * Beispiel für weitere Spezialisierung.
 */

public class Lkw extends Fahrzeug {

    private final double zuladungMaxKg;

    public Lkw(String marke, int baujahr, double tankinhalt, double tankinhaltMax, double zuladungMaxKg) {
        super(marke, baujahr, tankinhalt, tankinhaltMax);
        this.zuladungMaxKg = Math.max(0, zuladungMaxKg);
    }


    public double getZuladungMaxKg() {
        return zuladungMaxKg;
    }

    @Override
    public void starten() {
        System.out.println("Lkw " + getMarke() + " (BJ " + getBaujahr() + ") startet mit Druckluftsystem.");
    }
}