package org.example;

import java.util.Scanner;

// https://www.cours-gratuit.com/java/exercice-java-modularisation-rectangle

public class Rectangle {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        double largeur = lireDonnee("largeur");
        double hauteur = lireDonnee("hauteur");

        boolean donneesOk = testerDonnees(largeur, hauteur);

        if (donneesOk) {
            calculer(largeur, hauteur);
        } else {
            afficherErreur();
        }
    }

    static double lireDonnee (String text) {
        System.out.print("Entrez la " + text + ": ");
        return (scanner.nextDouble());
    }

    static void calculer(double l, double h) {
        System.out.print("Surface ('s/S') ou perimètre ('p/P')? ");
        char typeCalcul = scanner.next().charAt(0);
        switch (typeCalcul ){
            case 's':
            case 'S': {
                double surface = l * h;
                System.out.println("La surface est " + surface);
                break;
            }
            case 'p':
            case 'P': {
                double perimetre = 2 * (l + h);
                System.out.println("Le perimetre est est " + perimetre);
                break;
            }
            default: {
                System.out.println ("Introduire un 'p' ou un 's' s.v.p");
            }
        }
    }

    static boolean testerDonnees(double largeur, double hauteur) {
        return ((largeur > 0) && (hauteur > 0));
    }

    static void afficherErreur () {
        System.out.println("Erreur: vous avez introduit une largeur ou une hauteur négative!");
    }

}

