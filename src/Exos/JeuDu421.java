package Exos;

import java.util.Random;
import java.util.Scanner;

public class JeuDu421
{
// Initialisation variable
    static int[] Resultat = {4,2,1};
    static int[] Main = {0,0,0};
    static int[] De_Lance = {0,0,0};
    static int Nb_coup= 0;
    static int Nb_Dé = 3;
    static int Choix;
    static Scanner input = new Scanner(System.in);
    static Random rnd = new Random();
// Initialisation variable

    public static int JetDe() // Renvoie aléatoirement un chiffre compris entre 1 et 6
    {
        return rnd.nextInt(6) + 1;
    }

    public static void Nb_Lance() // Affiche les possibilité de lancer au joueur celon son nombre de dé restant
    {
        if (Nb_Dé == 3)
        {
            System.out.println("Combien de dé voulez vous lancer 1, 2 ou 3 : \n");
            Choix = input.nextInt();

            if (Choix != 1 || Choix != 2 || Choix != 3 )
            {
                return;
            }
        }

        if (Nb_Dé == 2)
        {
            System.out.println("Combien de dé voulez vous lancer 1 ou 2 : \n");
            Choix = input.nextInt();

            if (Choix != 1 || Choix != 2 )
            {
                return;
            }
        }

        if (Nb_Dé == 1)
        {
            System.out.println("\nVeuillez lancer votre dernier dé [1]:\n");
            Choix = input.nextInt();
        }
        if (Choix != 1)
        {
            return;
        }
    }

    public static void Verif_Chiffres() // Permet de récupérer les bons chiffres sur les dé lancer
    {

        for (int i=0; i<3; i++) // Parcour les dé lancer pour les ajouter si nécessaire à la main
        {

            if (De_Lance[i] == 4 && Main[0] != 4){ // Si le chiffre est déjà dans la main la conditions n'est pas faite
                Main[0] = De_Lance[i];
                Nb_Dé--;
            }

            if (De_Lance[i] == 2 && Main[1] != 2){
                Main[1] = De_Lance[i];
                Nb_Dé--;
            }

            if (De_Lance[i] == 1 && Main[2] != 1){
                Main[2] = De_Lance[i];
                Nb_Dé--;
            }
        }
        System.out.println("Votre Main = [" + Main[0] + "," + Main[1] + "," + Main[2] +  "]"); // Affiche la main
        Nb_coup++; // Rajoute 1 coup
    }



    public static void main(String[] args)
    {
        System.out.println("Bienvenu sur le jeu du 421\n");

        while (Nb_coup != 3)
        {
            Nb_Lance(); // Affiche les possibilité de lancer au joueur celon son nombre de dé restant
            switch (Choix)
            {
                case 1:

                    De_Lance[0] = JetDe();
                    System.out.println("Le dé affiche : " + De_Lance[0] + "\n");
                    Verif_Chiffres();

                break;

                case 2:

                    De_Lance[0] = JetDe();
                    De_Lance[1] = JetDe();
                    System.out.println("Le dé affiche : " + De_Lance[0] + "\n");
                    System.out.println("Le dé affiche : " + De_Lance[1] + "\n");
                    Verif_Chiffres();

                break;

                case 3:

                    De_Lance[0] = JetDe();
                    De_Lance[1] = JetDe();
                    De_Lance[2] = JetDe();
                    System.out.println("Le dé affiche : " + De_Lance[0] + "\n");
                    System.out.println("Le dé affiche : " + De_Lance[1] + "\n");
                    System.out.println("Le dé affiche : " + De_Lance[2] + "\n");
                    Verif_Chiffres();

                break;
            }

            if (Main[0] == Resultat[0] && Main[1] == Resultat[1] && Main[2] == Resultat[2])
            {
                System.out.println("\n[" + Main[0] + "," + Main[1] + "," + Main[2] +  "] Vous avez Gagné!!");
                Nb_coup = 4;
            }

            if (Nb_coup == 3)
            {
                System.out.println("\n[" + Main[0] + "," + Main[1] + "," + Main[2] +  "] Vous avez perdu!!");
            }

        }

    }
}