package Exos;

import java.util.Scanner;

public class JeuDesAllumettes {

// Initialisation variable
    static Scanner input = new Scanner(System.in);
    static int Allumettes;
    static int Choix;
    static int Joueur;
    static int nb_tour = 0;
// Initialisation variable

    public static void Tour_De_Jeu() // Utilisation d'un compteur qui est paire ou impaire afin de changer de joueur
    {

        if (nb_tour%2 == 0){
            Joueur = 2;
        }
        else {
            Joueur = 1;
        }
    }


    public static void Affiche_Allumettes() {  // Affichage des allumettes avec une boucle
        for (int i = 1; i < Allumettes; i++) {
            System.out.println(" | " + i);
        }
        System.out.println(" | " + Allumettes);
    }

    public static void Retirer_Allumettes() // Nombre d'allumette retirable celon des conditions
    {
        if (Allumettes > 2)
        {
            System.out.println("\nCombien d'allumettes voulez vous retirer 1, 2 ou 3: ");
            if (Choix != 1 || Choix != 2 || Choix != 3)
            {
                return;
            }
        }
        if (Allumettes == 2)
        {
            System.out.println("\nCombien d'allumettes voulez vous retirer 1 ou 2: ");
            if (Choix != 1 || Choix != 2)
            {
                return;
            }
        }
        if (Allumettes == 1)
        {
            System.out.println("\nVous ne pouvez retirer qu'1 allumettes: ");
            if (Choix != 1)
            {
                return;
            }
        }
    }


    public static void main(String[] args)
    {

        System.out.println("Avec combien d'Allumettes souhaitez vous jouer: ");
        Allumettes = input.nextInt();

        Affiche_Allumettes();

        while (Allumettes != 0) { // Permet de relancer le jeu tant qu'il reste plus d'une allumettes
            nb_tour++;
            Tour_De_Jeu();
            System.out.println("Joueur " + Joueur + " à vous de jouer" );
            Retirer_Allumettes();
            Choix = input.nextInt();

            switch (Choix) { // Permet de décrémenter le nombre d'allumettes selons le choix utilisateur
                case 1:
                    Allumettes--;
                    Affiche_Allumettes();
                    break;

                case 2:

                    Allumettes -= 2;
                    Affiche_Allumettes();

                    break;

                case 3:

                    Allumettes -= 3;
                    Affiche_Allumettes();

                    break;
            }
        }
        nb_tour++;
        System.out.println("\nLa partie à durer " + nb_tour + " tours et le joueur " + Joueur + " à perdu !!");
    }
}