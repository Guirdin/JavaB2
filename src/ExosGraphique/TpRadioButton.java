package ExosGraphique;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TpRadioButton extends JFrame implements ActionListener {

    private JRadioButton PoliceNormal = new JRadioButton("Normal");
    private JRadioButton PoliceGras = new JRadioButton("Gras");
    private JRadioButton PoliceItalique = new JRadioButton("Italique");
    private JRadioButton PoliceGrasItalique = new JRadioButton("Gras/Italique");
    private JTextField ZoneText = new JTextField("Voyez les changement de style");

    public void DecocheAll()
    {
        PoliceNormal.setSelected(false);
        PoliceGras.setSelected(false);
        PoliceItalique.setSelected(false);
        PoliceGrasItalique.setSelected(false);
    }


    public TpRadioButton()
    {
        super("test Radio Button"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(300, 200); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout( null ); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        ZoneText.addActionListener(this);
        ContentPane.add(ZoneText);
        ZoneText.setBounds(0,0,286,30);

        PoliceNormal.addActionListener(this);
        ContentPane.add(PoliceNormal);
        PoliceNormal.setBounds(0,30,70,30);

        PoliceGras.addActionListener(this);
        ContentPane.add(PoliceGras);
        PoliceGras.setBounds(70,30,50,30);

        PoliceItalique.addActionListener(this);
        ContentPane.add(PoliceItalique);
        PoliceItalique.setBounds(125,30,80,30);

        PoliceGrasItalique.addActionListener(this);
        ContentPane.add(PoliceGrasItalique);
        PoliceGrasItalique.setBounds(190,30,90,30);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if ( event.getSource() == PoliceNormal )
        {
            DecocheAll();
            PoliceNormal.setSelected(true);
            ZoneText.setFont(ZoneText.getFont().deriveFont(Font.PLAIN));
        }
        if ( event.getSource() == PoliceGras )
        {
            DecocheAll();
            PoliceGras.setSelected(true);
            ZoneText.setFont(ZoneText.getFont().deriveFont(Font.BOLD));
        }
        if ( event.getSource() == PoliceItalique )
        {
            DecocheAll();
            PoliceItalique.setSelected(true);
            ZoneText.setFont(ZoneText.getFont().deriveFont(Font.ITALIC));
        }
        if ( event.getSource() == PoliceGrasItalique )
        {
            DecocheAll();
            PoliceGrasItalique.setSelected(true);
            ZoneText.setFont(ZoneText.getFont().deriveFont(Font.BOLD|Font.ITALIC));
        }
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpRadioButton MenuBouton = new TpRadioButton(); // Creation et démarre ma fenetre
        MenuBouton.setVisible(true); // Visibilité de ma fenetre

    }
}
