package Application;

import Exos.NombreMystere;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;

public class Interface_NombreMystere extends JFrame implements ActionListener {

    private JButton Retour_Menu = new JButton("Retour au Menu");
    private JFormattedTextField Chiffre = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JButton Valider = new JButton("Valider");
    private JButton Rejouer = new JButton("Rejouer");
    private JLabel Texte = new JLabel("Afin de trouver le nombre mystère");
    Random rand = new Random();
    int Nbr_Mystere = -10 + rand.nextInt(20);

    public Interface_NombreMystere() {
        super("Nombre Mystère"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(600, 400); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout(null); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        Retour_Menu.setBounds(5,5,110,30);
        Retour_Menu.addActionListener(this);
        ContentPane.add(Retour_Menu); // ajout du widget bouton

        JLabel Regles = new JLabel("Veuillez entrer un nombre compris entre -10 et 10");
        Regles.setBounds(170,20,280,30);
        ContentPane.add(Regles); // ajout du widget Label


        Texte.setBounds(200,50,280,30);
        ContentPane.add(Texte); // ajout du widget Label

        Chiffre.setBounds(230,90,40,30);
        ContentPane.add(Chiffre); // ajout du widget TextField

        Valider.setBounds(280,90,70,30);
        Valider.addActionListener(this);
        ContentPane.add(Valider); // ajout du widget bouton
        Valider.setVisible(true);


        ContentPane.add(Rejouer); // ajout du widget bouton
        Rejouer.setBounds(280,90,70,30);
        Rejouer.addActionListener(this);
        Rejouer.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == Retour_Menu)
        {
            dispose();
            Menu Fenetre = new Menu(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }

        if (event.getSource() == Rejouer)
        {
            dispose();
            Interface_NombreMystere Fenetre = new Interface_NombreMystere(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }

        int Nombre;

        if (event.getSource() == Valider)
        {
            Nombre = Integer.parseInt(Chiffre.getText());

            if (Nombre < -10 || Nombre > 10) {
                Texte.setText("Veuillez saisir un nombre correct ");
                Chiffre.setText("");
            }
            else
            {
                if (Nombre < Nbr_Mystere)
                {
                    Texte.setText("C'est plus ! ");
                    Chiffre.setText("");
                }
                if (Nombre > Nbr_Mystere)
                {
                    Texte.setText("C'est moins ! ");
                    Chiffre.setText("");
                }
                else
                {
                    Texte.setText("Vous avez Gagné !");
                    Valider.setVisible(false);
                    Rejouer.setVisible(true);

                }
            }
        }
    }
}
