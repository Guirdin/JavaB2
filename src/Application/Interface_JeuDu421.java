package Application;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import Application.CountDown;

public class Interface_JeuDu421 extends JFrame implements ActionListener {

// Initialisation variable
    private int[] Resultat = {4,2,1};
    private int[] Main = {0,0,0};
    private int[] De_Lance = {0,0,0};
    private int Nb_Dé = 3;
    private int Essai = 3;
    static Random rnd = new Random();
// Initialisation variable

    private JButton Retour_Menu = new JButton("Retour au Menu");
    private JButton Rejouer = new JButton("Rejouer");

    private JLabel Regles = new JLabel("Vous avez " + Essai + " essais pour avoir les chiffres 4,2,1");

    private ImageIcon LeQuatre = new ImageIcon("Dés/Le4.png");
    private ImageIcon LeDeux = new ImageIcon("Dés/Le2.png");
    private ImageIcon LeUn = new ImageIcon("Dés/Le1.png");
    private JLabel Le4 = new JLabel(LeQuatre);
    private JLabel Le2 = new JLabel(LeDeux);
    private JLabel Le1 = new JLabel(LeUn);

    private JButton Lancer1 = new JButton("Lancé 1 dé");
    private JButton Lancer2 = new JButton("Lancé 2 dé");
    private JButton Lancer3 = new JButton("Lancé 3 dé");

    private ImageIcon PointInterrogation = new ImageIcon("Dés/PointInterrogation.png");
    private JLabel Place1 = new JLabel(PointInterrogation);
    private JLabel Place2 = new JLabel(PointInterrogation);
    private JLabel Place3 = new JLabel(PointInterrogation);

    private ImageIcon DeUn = new ImageIcon("Dés/Dé1.png");
    private ImageIcon DeDeux = new ImageIcon("Dés/Dé2.png");
    private ImageIcon DeTrois = new ImageIcon("Dés/Dé3.png");
    private ImageIcon DeQuatre = new ImageIcon("Dés/Dé4.png");
    private ImageIcon DeCinq = new ImageIcon("Dés/Dé5.png");
    private ImageIcon DeSix = new ImageIcon("Dés/Dé6.png");
    private ImageIcon[] Tab_Des = {PointInterrogation,DeUn,DeDeux,DeTrois,DeQuatre,DeCinq,DeSix};

    public Interface_JeuDu421() {
        super("Jeu du 421"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(600, 500); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout(null); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        Retour_Menu.setBounds(5,5,110,30);
        Retour_Menu.addActionListener(this);
        ContentPane.add(Retour_Menu); // ajout du widget bouton

        Regles.setBounds(170,20,270,30);
        ContentPane.add(Regles); // ajout du widget Label

// Emplacement de la Main (des chiffres 4,2,1)

        ContentPane.add(Le4);              ContentPane.add(Le2);            ContentPane.add(Le1);
        Le4.setVisible(false);             Le2.setVisible(false);           Le1.setVisible(false);

        Le4.setBounds(50,70,130,130);

        Le2.setBounds(230,70,130,130);

        Le1.setBounds(410,70,130,130);
// Emplacement de la Main (des chiffres 4,2,1)


//Les Boutons pour lancés les dés
        ContentPane.add(Lancer1); ContentPane.add(Lancer2); ContentPane.add(Lancer3);
        Lancer1.setVisible(true); Lancer2.setVisible(true); Lancer3.setVisible(true);
        Lancer1.addActionListener(this); Lancer2.addActionListener(this); Lancer3.addActionListener(this);

        Lancer1.setBounds(70,230,90,30);

        Lancer2.setBounds(250,230,90,30);

        Lancer3.setBounds(430,230,90,30);
//Les Boutons pour lancés les dés


//Emplacement des Dés lancé
        ContentPane.add(Place1); ContentPane.add(Place2); ContentPane.add(Place3);
        Place1.setVisible(true); Place2.setVisible(true); Place3.setVisible(true);

        Place1.setBounds(50,290,130,130);

        Place2.setBounds(230,290,130,130);

        Place3.setBounds(410,290,130,130);
//Emplacement des Dés lancé


        ContentPane.add(Rejouer); // ajout du widget bouton
        Rejouer.setBounds(250,230,90,30);
        Rejouer.addActionListener(this);
        Rejouer.setVisible(false);

    }

    public static int JetDe() // Renvoie aléatoirement un chiffre compris entre 1 et 6
    {
        return rnd.nextInt(6) + 1;
    }

    public void Verif_Chiffres() // Permet de récupérer les bons chiffres sur les dé lancer
    {
        for (int i=0; i<3; i++) // Parcour les dé lancer pour les ajouter si nécessaire à la main
        {

            if (De_Lance[i] == 4 && Main[0] != 4){ // Si le chiffre est déjà dans la main la conditions n'est pas faite
                Main[0] = De_Lance[i];
                Nb_Dé--;
                Le4.setVisible(true);
            }

            if (De_Lance[i] == 2 && Main[1] != 2){
                Main[1] = De_Lance[i];
                Nb_Dé--;
                Le2.setVisible(true);
            }

            if (De_Lance[i] == 1 && Main[2] != 1){
                Main[2] = De_Lance[i];
                Nb_Dé--;
                Le1.setVisible(true);
            }
        }
        Essai--; // Retire 1 essai
        Regles.setText("Vous avez " + Essai + " essais pour avoir les chiffres 4,2,1");;
    }

    public void Nb_Lance() // Affiche les possibilité de lancer au joueur celon son nombre de dé restant
    {
        if (Nb_Dé == 2)
        {
            Place3.setVisible(false);
            Lancer3.setVisible(false);
        }

        if (Nb_Dé == 1)
        {
            Place2.setVisible(false);
            Lancer2.setVisible(false);
            Place3.setVisible(false);
            Lancer3.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == Lancer1)
        {
            De_Lance[0] = JetDe();
            Place1.setIcon(Tab_Des[De_Lance[0]]);
            Verif_Chiffres();
            Nb_Lance();
        }

        if (event.getSource() == Lancer2)
        {
            De_Lance[0] = JetDe();
            De_Lance[1] = JetDe();
            Place1.setIcon(Tab_Des[De_Lance[0]]);
            Place2.setIcon(Tab_Des[De_Lance[1]]);
            Verif_Chiffres();
            Nb_Lance();
        }

        if (event.getSource() == Lancer3)
        {
            De_Lance[0] = JetDe();
            De_Lance[1] = JetDe();
            De_Lance[2] = JetDe();
            Place1.setIcon(Tab_Des[De_Lance[0]]);
            Place2.setIcon(Tab_Des[De_Lance[1]]);
            Place3.setIcon(Tab_Des[De_Lance[2]]);
            Verif_Chiffres();
            Nb_Lance();
        }

        if (Main[0] == Resultat[0] && Main[1] == Resultat[1] && Main[2] == Resultat[2])
        {
            Essai=-1;

            Place1.setVisible(false);
            Lancer1.setVisible(false);
            Place2.setVisible(false);
            Lancer2.setVisible(false);
            Place3.setVisible(false);
            Lancer3.setVisible(false);

            Regles.setBounds(140,20,440,30);
            Regles.setText("Vous avez Gagner, Vous pouvez rejouer en appuyant sur le bouton ci-dessous");
            Rejouer.setVisible(true);
        }

        if (Essai == 0)
        {
            Place1.setVisible(false);
            Lancer1.setVisible(false);
            Place2.setVisible(false);
            Lancer2.setVisible(false);
            Place3.setVisible(false);
            Lancer3.setVisible(false);

            Regles.setBounds(140,20,400,30);
            Regles.setText("Vous avez perdu, Vous pouvez rejouer en appuyant sur le bouton ci-dessous");
            Rejouer.setVisible(true);
        }


        if (event.getSource() == Retour_Menu)
        {
            dispose();
            Menu Fenetre = new Menu(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }

        if (event.getSource() == Rejouer)
        {
            dispose();
            Interface_JeuDu421 Fenetre = new Interface_JeuDu421(); // Creation et démarre ma fenetre
            Fenetre.setVisible(true); // Visibilité de ma fenetre
        }
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        Interface_JeuDu421 MonMenu = new Interface_JeuDu421(); // Creation et démarre ma fenetre
        MonMenu.setVisible(true); // Visibilité de ma fenetre

    }
}
