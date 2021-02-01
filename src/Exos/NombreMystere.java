package Exos;

import java.util.*;
import java.util.Random;

public class NombreMystere
{
    static public void main(String[] args)
    {

// Initialisation variable
        int Nombre,Coups=0;
        Random rand = new Random();
        Scanner nombre = new Scanner(System.in);
        String Rejouer;
// Initialisation variable

        System.out.println("\nBienvenue dans le nombre mystère"); // Messsage Bienvenue

            int NombreMystere = -10 + rand.nextInt(20);
            System.out.println("\nTrouvez le nombre mystère compris entre -10 et 10");

            do // Boucle qui permet de relancer le jeu tant que le nombre n'est pas trouver
            {
                System.out.println("Veuillez entrer un nombre: ");
                Nombre=nombre.nextInt();

                if (Nombre == NombreMystere)
                {
                    System.out.println("Vous avez réussis en " + Coups + " coups");
                    break;
                }

                if (Nombre<NombreMystere)
                {
                    System.out.println("C'est plus");
                    Coups++;
                }

                else
                {
                    System.out.println("C'est moins");
                    Coups++;
                }

            }while(true);
    }
}
