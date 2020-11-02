package Application;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


public class Interface_JeuDesAllumettes extends JFrame implements ActionListener {

    private JButton Retour_Menu = new JButton("Retour au Menu");
    private JButton Rejouer = new JButton("Rejouer");

    private JFormattedTextField Texte_Allumette = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JButton Valider = new JButton("Valider");

    private int Nb_Allumette;
    private JLabel[] Tab_Allumettes = new JLabel[Nb_Allumette];

    private JButton Retire1 = new JButton("Retiré 1 allumettes");
    private JButton Retire2 = new JButton("Retiré 2 allumettes");
    private JButton Retire3 = new JButton("Retiré 3 allumettes");

    private JLabel Texte = new JLabel("Veuillez entrer un nombre d'allumette compris entre 1 et 20: ");
    private ImageIcon Allumette = new ImageIcon("Allumettes/Allumette.png");
    private JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
    private JPanel Panel_Allumette = new JPanel(); // permet d'ajouter des éléments dans ma fenetre


    private int PositionX = 0;
    private int PositionY = 20;

// Initialisation variable
    private int Joueur = 0;
    private int nb_tour = 0;
// Initialisation variable


    public Interface_JeuDesAllumettes() {
        super("Jeu des allumettes"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(610, 500); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        ContentPane.setLayout(null); // Creation d'un layout pour positionner mes éléments/widgets comme je veux
        ContentPane.add(Panel_Allumette); Panel_Allumette.setLayout(null);
        Panel_Allumette.setBounds(0,120,610,500);
        Panel_Allumette.add(new JLabel(Allumette)).setBounds(PositionX, PositionY, 40, 140);
        Panel_Allumette.setBorder(BorderFactory.createLineBorder(Color.black));



        Retour_Menu.setBounds(5, 5, 110, 30);
        Retour_Menu.addActionListener(this);
        ContentPane.add(Retour_Menu); // ajout du widget bouton

        Texte.setBounds(180,10,350,30);
        ContentPane.add(Texte); // ajout du widget Label

        Texte_Allumette.setBounds(260, 50, 40, 30);
        ContentPane.add(Texte_Allumette); // ajout du widget TextField

        Valider.setBounds(310, 50, 70, 30);
        Valider.addActionListener(this);
        ContentPane.add(Valider); // ajout du widget bouton
        Valider.setVisible(true);


//Les Boutons pour retiré les allumettes
        ContentPane.add(Retire1); ContentPane.add(Retire2); ContentPane.add(Retire3);
        Retire1.setVisible(false); Retire2.setVisible(false); Retire3.setVisible(false);
        Retire1.addActionListener(this); Retire2.addActionListener(this); Retire3.addActionListener(this);

        Retire1.setBounds(70,70,130,30);

        Retire2.setBounds(250,70,130,30);

        Retire3.setBounds(430,70,130,30);
//Les Boutons pour retiré les allumettes




        ContentPane.add(Rejouer); // ajout du widget bouton
        Rejouer.setBounds(250, 230, 90, 30);
        Rejouer.addActionListener(this);
        Rejouer.setVisible(false);


    }


    public void Tour_De_Jeu() // Utilisation d'un compteur qui est paire ou impaire afin de changer de joueur
    {
        nb_tour++;
        if (nb_tour%2 == 0){
            Joueur = 2;
        }
        else {
            Joueur = 1;
        }
    }

    public void Affiche_Allumettes() // Affichage des allumettes avec une boucle
    {
        if (Nb_Allumette <= 15)
        {
            for (int i = 0; i < Nb_Allumette; i++)
            {
                Panel_Allumette.add(new JLabel(Allumette)).setBounds(PositionX, PositionY, 40, 140);
                PositionX += 40;

            }
        }

        if (Nb_Allumette > 15)
        {
            for (int i = 1; i < Nb_Allumette; i++)
            {
                Panel_Allumette.add(new JLabel(Allumette)).setBounds(PositionX, PositionY, 40, 140);
                PositionX += 40;
                if (i == 15)
                {
                    for (int n = 0; n < i; n++)
                    {
                        PositionX = 0;
                        PositionY = 180;
                        Panel_Allumette.add(new JLabel(Allumette)).setBounds(PositionX, PositionY, 40, 140);
                        PositionX += 40;
                    }
                }
            }
        }
    }

    public void Retire_Allumettes() // Affichage des allumettes avec une boucle
    {
        Nb_Allumette--;
        Affiche_Allumettes();
    }


    @Override
    public void actionPerformed(ActionEvent event)
    {

        if (event.getSource() == Valider)
        {
            Nb_Allumette = Integer.parseInt(Texte_Allumette.getText());
            Affiche_Allumettes();
            Retire1.setVisible(true); Retire2.setVisible(true); Retire3.setVisible(true);
            Valider.setVisible(false); Texte_Allumette.setVisible(false);
            Tour_De_Jeu();
            Texte.setText("Joueur " + Joueur + " Veuillez choisir un nombre d'allumettes à retirer");
        }

        if (event.getSource() == Retire1)
        {
            Tour_De_Jeu();
            Texte.setText("Joueur " + Joueur + " Veuillez choisir un nombre d'allumettes à retirer");
            new JLabel(Allumette).removeAll();
            Nb_Allumette--;

        }
        if (event.getSource() == Retire2)
        {
            Tour_De_Jeu();
            Texte.setText("Joueur " + Joueur + " Veuillez choisir un nombre d'allumettes à retirer");
            Nb_Allumette -= 2;
            Affiche_Allumettes();
        }
        if (event.getSource() == Retire3)
        {
            Tour_De_Jeu();
            Texte.setText("Joueur " + Joueur + " Veuillez choisir un nombre d'allumettes à retirer");
            Nb_Allumette -= 3;
            Affiche_Allumettes();
        }


        if (event.getSource() == Retour_Menu) {
            dispose();
            Menu Fenetre = new Menu(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }

        if (event.getSource() == Rejouer) {
            dispose();
            Interface_JeuDesAllumettes Fenetre = new Interface_JeuDesAllumettes(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }
    }
    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        Interface_JeuDesAllumettes MonMenu = new Interface_JeuDesAllumettes(); // Creation et démarre ma fenetre
        MonMenu.setVisible(true); // Visibilité de ma fenetre

    }
}