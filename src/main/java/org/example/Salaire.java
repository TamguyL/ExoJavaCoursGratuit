package org.example;


// https://www.cours-gratuit.com/java/exercice-java-heritage-et-interfaces-primes-de-risque

abstract class Employe {
    private String nom;
    private String prenom;
    private int age;
    private String dateEntrer;
    public Employe(String prenom, String nom, int age, String dateEntrer) {
        this.dateEntrer = dateEntrer;
        this.age = age;
        this.prenom = prenom;
        this.nom = nom;
    }
    public abstract double calculerSalaire();
    public String getTitre(){return "L'employé ";}
    public String getNom(){
        return getTitre()+prenom+" "+nom;
    }
}

abstract class Commercial extends Employe {
    private double chiffreAffaire;
    public Commercial(String prenom, String nom, int age, String dateEntrer, double chiffreAffaire) {
        super(prenom, nom, age, dateEntrer);
        this.chiffreAffaire = chiffreAffaire;
    }
    public double getChiffreAffaire()
    {
        return chiffreAffaire;
    }
}

class Vendeur extends Commercial {
    private final static double primeDeChiffreAffaire = 0.2;
    private final static int bonus = 88;
    public Vendeur(String prenom, String nom, int age, String dateEntrer, double chiffreAffaire) {
        super(prenom, nom, age, dateEntrer, chiffreAffaire);
    }
    @Override
    public double calculerSalaire() {
        return (primeDeChiffreAffaire * getChiffreAffaire() + bonus);
    }
    public String getTitre(){
        return "Le Vendeur ";
    }
}

class Representant extends Commercial {
    private final static double primeDeChiffreAffaire = 0.2;
    private final static int bonus = 176;
    public Representant(String prenom, String nom, int age, String dateEntrer, double chiffreAffaire) {
        super(prenom, nom, age, dateEntrer, chiffreAffaire);
    }
    @Override
    public double calculerSalaire() {
        return (primeDeChiffreAffaire * getChiffreAffaire() + bonus);
    }
    public String getTitre(){
        return "Le Representant ";
    }
}

class Technicien extends Employe {
    private final static double multiX5 = 1.12;
    private int unites;
    public Technicien(String prenom, String nom, int age, String dateEntrer, int unites) {
        super(prenom, nom, age, dateEntrer);
        this.unites = unites;
    }
    public double calculerSalaire() {
        return (unites * multiX5);
    }
    public String getTitre(){
        return "Le Technicien ";
    }
}

class Manutentionnaire extends Employe {
    private final static double salaire = 14.34;
    private int heures;
    public Manutentionnaire(String prenom, String nom, int age, String dateEntrer, int heures) {
        super(prenom, nom, age, dateEntrer);
        this.heures = heures;
    }
    public double calculerSalaire() {
        return (heures * salaire);
    }
    public String getTitre(){
        return "Le Manutentionnaire ";
    }
}

interface ARisque {int Prime = 44;}

class TechnARisque extends Technicien implements ARisque {
    public TechnARisque(String prenom, String nom, int age, String dateEntrer, int unites) {
        super(prenom, nom, age, dateEntrer, unites);
    }
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire()+ Prime;
    }
}

class ManutARisque extends Manutentionnaire implements ARisque {
    public ManutARisque(String prenom, String nom, int age, String dateEntrer, int heures) {
        super(prenom, nom, age, dateEntrer, heures);
    }
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire()+ Prime;
    }
}

class Personnel {
    private Employe[] staff;
    private int nbreEmploye;
    private final static int MAXEMPLOYE = 200;

    public Personnel() {
        staff = new Employe[MAXEMPLOYE];
        nbreEmploye = 0;
    }

    public void ajouterEmploye(Employe e) {
        ++nbreEmploye;
        if (nbreEmploye <= MAXEMPLOYE) {
            staff[nbreEmploye - 1] = e;
        } else {
            System.out.println("Pas plus de " + MAXEMPLOYE + " employés");
        }
    }

    public double salaireMoyen() {
        double somme = 0.0;
        for (int i = 0; i < nbreEmploye; i++) {
            somme += staff[i].calculerSalaire();
        }
        return somme / nbreEmploye;
    }

    public void afficherSalaires() {
        for (int i = 0; i < nbreEmploye; i++) {
            System.out.println(staff[i].getNom() + " gagne "
                    + staff[i].calculerSalaire() + " €.");
        }
    }
}

public class Salaire {
    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 6616));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 4410));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " €.");
    }
}
