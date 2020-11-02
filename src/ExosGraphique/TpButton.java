package ExosGraphique;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TpButton extends JFrame implements ActionListener {

    private JButton BtnSimple = new JButton("Bouton simple"); // creation d'un widget bouton
    private JButton Btnfantasie = new JButton("Bouton Fantasie"); // creation d'un widget bouton

    public TpButton()
    {
        super("test des boutons"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(450, 250); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout( null ); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        BtnSimple.addActionListener(this);
        ContentPane.add(BtnSimple); // ajout du widget bouton
        BtnSimple.setBounds(20,30,130,40);

        Btnfantasie.addActionListener(this);
        ContentPane.add(Btnfantasie); // ajout du widget bouton
        Btnfantasie.setBounds(180,10,220,80);

        Image photo = new ImageIcon(this.getClass().getResource("CannardIcon.png")).getImage();
        Btnfantasie.setIcon(new ImageIcon(photo));


    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if ( event.getSource() == BtnSimple )
        {
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Bouton simple");
        }

        if ( event.getSource() == Btnfantasie )
        {
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Bouton fantasie");
        }
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpButton MenuBouton = new TpButton(); // Creation et démarre ma fenetre
        MenuBouton.setVisible(true); // Visibilité de ma fenetre

    }
}