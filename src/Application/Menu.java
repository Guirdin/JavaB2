package Application;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame implements ActionListener {

    private JButton BtnNombreMystere = new JButton("Nombre mystère"); // creation d'un widget bouton
    private JButton BtnJeuDu421 = new JButton("421"); // creation d'un widget bouton
    private JButton BtnJeuDesAllumettes = new JButton("Jeu des allumettes"); // creation d'un widget bouton

    public Menu()
    {
        super("Menu"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(600, 400); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout( new FlowLayout() ); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        BtnNombreMystere.addActionListener(this);
        ContentPane.add(BtnNombreMystere); // ajout du widget bouton

        BtnJeuDu421.addActionListener(this);
        ContentPane.add(BtnJeuDu421); // ajout du widget bouton

        BtnJeuDesAllumettes.addActionListener(this);
        ContentPane.add(BtnJeuDesAllumettes); // ajout du widget bouton

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if ( event.getSource() == BtnNombreMystere )
        {
            dispose();
            Interface_NombreMystere MonInterface = new Interface_NombreMystere(); // Creation et démarre ma fenetre
            MonInterface.setVisible(true); // Visibilité de ma fenetre
        }

        if ( event.getSource() == BtnJeuDu421 )
        {
            dispose();
            Interface_JeuDu421 MonInterface = new Interface_JeuDu421(); // Creation et démarre ma fenetre
            MonInterface.setVisible(true); // Visibilité de ma fenetre
        }
        if ( event.getSource() == BtnJeuDesAllumettes )
        {
            dispose();
            Interface_JeuDesAllumettes MonInterface = new Interface_JeuDesAllumettes(); // Creation et démarre ma fenetre
            MonInterface.setVisible(true); // Visibilité de ma fenetre
        }
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        Menu MonMenu = new Menu(); // Creation et démarre ma fenetre
        MonMenu.setVisible(true); // Visibilité de ma fenetre
    }
}
