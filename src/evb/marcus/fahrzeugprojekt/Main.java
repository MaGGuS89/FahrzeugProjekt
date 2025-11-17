package evb.marcus.fahrzeugprojekt;

import evb.marcus.fahrzeugprojekt.fahrzeuge.Auto;
import evb.marcus.fahrzeugprojekt.fahrzeuge.Motorrad;
import evb.marcus.fahrzeugprojekt.fahrzeuge.Lkw;
import evb.marcus.fahrzeugprojekt.fahrzeuge.Fahrzeug;
import evb.marcus.fahrzeugprojekt.werkstatt.Werkstatt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen im Werkstatt-Testprogramm!");
        System.out.println("1 = Auto, 2 = Motorrad, 3 = Lkw");
        System.out.println("Bitte wählen Sie ein Fahrzeugtyp:");


        int typ = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Marke: ");
        String marke = scanner.nextLine();

        System.out.print("Baujahr: ");
        int baujahr = scanner.nextInt();

        System.out.print("Maximales Tankvolumen (Liter): ");
        double tankMax = scanner.nextDouble();

        System.out.print("Aktueller Tankinhalt (Liter): ");
        double tank = scanner.nextDouble();

        Fahrzeug fahrzeug = null;

        switch (typ) {
            case 1 -> {
                System.out.print("Anzahl Türen: ");
                int tueren = scanner.nextInt();
                fahrzeug = new Auto(marke, baujahr, tank, tankMax, tueren);
            }
            case 2 -> fahrzeug = new Motorrad(marke, baujahr, tank, tankMax);
            case 3 -> {
                System.out.print("Max. Zuladung (kg): ");
                double zuladung = scanner.nextDouble();
                fahrzeug = new Lkw(marke, baujahr, tank, tankMax, zuladung);
            }
            default -> {
                System.out.println("Ungültige Auswahl!");
                System.exit(0);
            }
        }

        Werkstatt werkstatt = new Werkstatt();

        /// Menüschleife
        int auswahl;
        do {
            System.out.println("\n--- Menü ---");
            System.out.println("1 = starten");
            System.out.println("2 = beschleunigen");
            System.out.println("3 = tanken");
            System.out.println("4 = Werkstattprüfung");
            System.out.println("0 = beenden");
            System.out.print("Ihre Wahl: ");

            auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1 -> fahrzeug.starten();
                case 2 -> {
                    System.out.print("Beschleunigungswert: ");
                    double delta = scanner.nextDouble();
                    fahrzeug.beschleunigen(delta);
                }
                case 3 -> {
                    System.out.print("Tankmenge: ");
                    double liter = scanner.nextDouble();
                    fahrzeug.tanken(liter);
                }
                case 4 -> werkstatt.pruefeFahrzeug(fahrzeug);
                case 0 -> System.out.println("Programm beendet.");
                default -> System.out.println("Ungültige Eingabe!");
            }
        } while (auswahl != 0);

        scanner.close();
    }
}
