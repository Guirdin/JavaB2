package ExosGraphique;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class TpJDialog extends JFrame {

    private static JDialog d;


    public TpJDialog() {

        JFrame f= new JFrame();
        d = new JDialog(f , "About Dialog Test");
        d.setLayout( null );

        d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Par défaut JFrame est en HIDE_ON_CLOSE
        // Permet d'arrêter le Process de mon application une fois que toutes les fenêtre ont été fermé.
        d.setLocationRelativeTo(null); // Permet de localiser ma fenetre
        // RelativeTo avec pointer(null) permet de centrer ma fenetre par rapport au desktop/bureau

        d.setResizable(false);

        d.add( new JLabel ("Core Java")).setBounds(0,5,70,30);
        d.add(new JLabel("bla bla bla")).setBounds(0,30,70,30);
        d.add(new JButton("Ok")).setBounds(70,75,70,30);

        d.setSize(150,150);
        d.setVisible(true);
    }
    public static void main(String args[])
    {
        new TpJDialog();
    }
}