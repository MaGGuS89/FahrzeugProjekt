package evb.marcus.fahrzeugprojekt.fahrzeuge;

/**
 * Abstrakte Basisklasse für verschiedene Fahrzeugtypen.
 */

public abstract class Fahrzeug {

    private final String marke;
    private final int baujahr;
    private final double tankinhaltMax;   // maximales Tankvolumen
    private double tankinhalt;
    private double geschwindigkeit;

    protected Fahrzeug(String marke, int baujahr, double tankinhalt, double tankinhaltMax) {
        this.marke = marke;
        this.baujahr = baujahr;
        this.tankinhaltMax = Math.max(0, tankinhaltMax);
        this.tankinhalt = Math.min(tankinhalt, tankinhaltMax); // Startwert darf max. Volumen nicht überschreiten
        this.geschwindigkeit = 0.0;
    }

    public String getMarke() { return marke; }
    public int getBaujahr() { return baujahr; }
    public double getTankinhalt() { return tankinhalt; }
    public double getTankinhaltMax() { return tankinhaltMax; }
    public double getGeschwindigkeit() { return geschwindigkeit; }

    /**
     * Tanken mit Max-Kapazitätskontrolle:
     * - Bei Übermenge wird nur die Restkapazität getankt.
     * - Meldungen zeigen das maximale Volumen beim „voll“-Hinweis.
     */

    public void tanken(double liter) {
        if (liter <= 0) {
            System.out.println(getMarke() + ": Ungültiger Tankwert, keine Änderung.");
            return;
        }

        double restKapazitaet = tankinhaltMax - tankinhalt;

        if (restKapazitaet <= 0) {
            System.out.println(getMarke() + ": Tank ist bereits voll (" + getTankinhaltMax() + " L).");
            return;
        }

        if (liter > restKapazitaet) {
            tankinhalt += restKapazitaet;
            System.out.println("Zuviel Kraftstoff im Tank, es wurden nur "
                    + restKapazitaet + " Liter getankt. Tank ist jetzt voll ("
                    + tankinhaltMax + " L).");
        } else {
            tankinhalt += liter;
            System.out.println(getMarke() + " wurde um " + liter
                    + " Liter betankt. Neuer Tankinhalt: "
                    + tankinhalt + " L.");
        }
    }

    public void beschleunigen(double delta) {
        if (delta <= 0) {
            System.out.println(getMarke() + ": Ungültiger Beschleunigungswert, keine Änderung.");
            return;
        }
        geschwindigkeit += delta;
        System.out.println(getMarke() + " beschleunigt auf " + geschwindigkeit + " km/h.");
    }

    public abstract void starten();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + marke + " (BJ " + baujahr + ")";
    }
}
