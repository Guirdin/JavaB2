package ExosGraphique;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TpBoxLayout extends JFrame implements ActionListener {

    private JButton BtnOk = new JButton("OK"); // creation d'un widget bouton
    private JButton BtnCancel = new JButton("Cancel"); // creation d'un widget bouton
    private JTextField Name;
    private JLabel Nom = new JLabel("Nom:");
    private JLabel Password = new JLabel("Password:");
    public JPasswordField MDP;

    public TpBoxLayout()
    {
        super("Box Layout"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(500, 200); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout( null ); // Creation d'un layout pour positionner mes éléments/widgets en ligne


        ContentPane.add(Nom);
        Nom.setBounds(160,10,70,30);

        Name = new JTextField();
        Name.addActionListener(this);
        ContentPane.add(Name);
        Name.setBounds(200,10,70,30);

        ContentPane.add(Password);
        Password.setBounds(130,60,60,30);

        MDP = new JPasswordField();
        MDP.addActionListener(this);
        ContentPane.add(MDP);
        MDP.setBounds(200,60,140,30);

        BtnOk.addActionListener(this);
        ContentPane.add(BtnOk);
        BtnOk.setBounds(0,130,70,30);

        BtnCancel.addActionListener(this);
        ContentPane.add(BtnCancel);
        BtnCancel.setBounds(410,130,70,30);

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        String le_nom = Name.getText();
        String le_mdp = MDP.getText();

        if ( event.getSource() == BtnCancel)
        {
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Cancel"
                    + "\nNom : " + le_nom + "\nPwd : "+ le_mdp );

        }
        if ( event.getSource() == BtnOk)
        {
            JOptionPane.showMessageDialog(null, "Vous avez appuyé sur : Ok \n"
                    + "\nNom : " + le_nom + "\nPwd : "+ le_mdp );
        }
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpBoxLayout MenuBouton = new TpBoxLayout(); // Creation et démarre ma fenetre
        MenuBouton.setVisible(true); // Visibilité de ma fenetre
    }
}
