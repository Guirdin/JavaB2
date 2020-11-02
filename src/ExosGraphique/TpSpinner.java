package ExosGraphique;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TpSpinner extends JFrame
{

    public SpinnerModel MoisModel = new SpinnerDateModel(); public JLabel Mois = new JLabel("Month :");
    public JSpinner Mois_spinner = new JSpinner(MoisModel);

    public SpinnerModel AnneModel = new SpinnerDateModel(); public JLabel Annee = new JLabel("Annee :");
    public JSpinner Annee_spinner = new JSpinner(AnneModel);

    public SpinnerModel AutreModel = new SpinnerDateModel(); public JLabel AutreDate = new JLabel("Another Date :");
    public JSpinner AutreDate_spinner = new JSpinner(AutreModel);


    public TpSpinner()
    {
        super("Spinner Demo"); // Titre de ma fenetre

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        this.setSize(350, 250); // Donne une dimension
        this.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        JPanel ContentPane = (JPanel) this.getContentPane(); // permet d'ajouter des éléments dans ma fenetre
        ContentPane.setLayout( null ); // Creation d'un layout pour positionner mes éléments/widgets en ligne

        ContentPane.add(Mois);                             ContentPane.add(Mois_spinner);
        Mois.setBounds(20, 20, 90, 30); Mois_spinner.setBounds(130, 20, 200, 30);

        JComponent Mois_spin_edit = new JSpinner.DateEditor(Mois_spinner, "MMMM");
        Mois_spinner.setEditor(Mois_spin_edit);


        ContentPane.add(Annee);                             ContentPane.add(Annee_spinner);
        Annee.setBounds(20, 80, 90, 30); Annee_spinner.setBounds(130, 80, 200, 30);

        JComponent Annee_spin_edit = new JSpinner.DateEditor(Annee_spinner, "YYYY");
        Annee_spinner.setEditor(Annee_spin_edit);


        ContentPane.add(AutreDate);                              ContentPane.add(AutreDate_spinner);
        AutreDate.setBounds(20, 140, 90, 30); AutreDate_spinner.setBounds(130, 140, 200, 30);

        JComponent AutreDate_spin_edit = new JSpinner.DateEditor(AutreDate_spinner, "MMMM YYYY");
        AutreDate_spinner.setEditor(AutreDate_spin_edit);
    }

    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpSpinner frame = new TpSpinner(); // Creation et démarre ma fenetre
        frame.setVisible(true); // Visibilité de ma fenetre

    }
}