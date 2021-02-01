package Exos;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Suite
{
// Initialisation variable
    static Scanner input = new Scanner(System.in);
    static int a = 0;
    static int b = 0;
    static int U0;
    static int NMAX;
    static int epsilon;
    static int Unmoins1 = 1;
// Initialisation variable
    public static void main(String[] args)
    {

        System.out.println("\nVeuillez saisir une valeur pour a: ");
        a = input.nextInt();

        System.out.println("\nVeuillez saisir une valeur pour b: ");
        b = input.nextInt();

        System.out.println("\nVeuillez saisir une valeur pour U0: ");
        U0 = input.nextInt();

        System.out.println("\nVeuillez saisir une valeur pour NMAX: ");
        NMAX = input.nextInt();

        System.out.println("\nVeuillez saisir une valeur pour epsilon: ");
        epsilon = input.nextInt();

        int Un = a + b / Unmoins1;
        int n = 1;

// Calcule de la suite
        while (abs(Un - Unmoins1) > epsilon)
        {
            Unmoins1 = U0;
            Un = a + (b / Unmoins1);
            n += 1;

            continue;
        }
        while (n > NMAX)
        {
            Unmoins1 = U0;
            Un = a + (b / Unmoins1);
            n += 1;

        }
// Calcule de la suite

        System.out.println("\nPour un nombre d'itérations égal à " + n + " le résultat de Un est " + Un );
    }

}
