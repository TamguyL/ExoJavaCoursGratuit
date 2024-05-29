package org.example;

import java.util.Scanner;

// https://www.cours-gratuit.com/java/exercice-java-condition-if-nombre-pair-ou-impair

public class PairImpair {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre un nombre");
        int nombre = scanner.nextInt();

        // test si le nombre = 0
        if (nombre == 0) {
            System.out.println("le chiffre est égal a zero, donc c'est un chiffre pair");
        } else {
            // test si le nombre est inferieur 0
            if (nombre < 0) {
                System.out.println(nombre + " est negatif");
            } else {
                System.out.println(nombre + " est positif");
            }
        }

        // test si le modulo de 2 du nombre est egal a 0 (pair)
        int testpair = nombre % 2;
        if (testpair == 0) {
            System.out.println("et il est pair");
        } else {
            System.out.println("et il est impair");
        }

    }
}
