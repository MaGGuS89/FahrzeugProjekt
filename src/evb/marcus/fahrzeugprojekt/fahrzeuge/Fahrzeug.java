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
    public abstract double getVerbrauch();
    public abstract String getAsciiSymbol();

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

    public boolean fahren(double streckeKm) {
        double verbrauchPro100Km = getVerbrauch();
        double spritBenoetigt = (verbrauchPro100Km / 100.0) * streckeKm;

        if (spritBenoetigt > tankinhalt) {
            System.out.println("Nicht genug Kraftstoff für die Strecke!");
            return false;
        }

        tankinhalt -= spritBenoetigt;
        System.out.printf("%.2f km gefahren. %.2f Liter verbraucht.%n", streckeKm, spritBenoetigt);
        return true;
    }

    public void simuliereTestfahrt(double km) {
        System.out.println("Testfahrt gestartet: " + km + " km");

        double verbrauchProKm = getVerbrauch() / 100.0;
        double tankVorher = tankinhalt;

        for (int i = 1; i <= (int) km; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            tankinhalt -= verbrauchProKm;

            if (tankinhalt <= 0) {
                System.out.println("\nTank leer nach " + i + " km!");
                tankinhalt = 0;
                return;
            }

            // ASCII-Symbol zeilenweise einrücken
            String[] lines = this.getAsciiSymbol().split("\n");
            StringBuilder shifted = new StringBuilder();
            for (String line : lines) {
                shifted.append(" ".repeat(i)).append(line).append("\n");
            }

            System.out.print("\r" + shifted.toString());
        }

        System.out.printf("%nTeststrecke erfolgreich gefahren. Verbrauch: %.2f Liter%n", tankVorher - tankinhalt);
    }


    public abstract void starten();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + marke + " (BJ " + baujahr + ")";
    }
}
