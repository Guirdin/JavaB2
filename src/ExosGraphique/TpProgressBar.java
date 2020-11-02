package ExosGraphique;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TpProgressBar extends JFrame {

    // create a frame 
    static JFrame fenetre;
    static JButton btn_Start = new JButton("Start");
    static JProgressBar Barre;


    public static void main(String[] main)
    {

        // create a frame
        fenetre = new JFrame("ProgressBar demo");
        fenetre.setLayout(null);
        // set the size of the frame
        fenetre.setSize(500, 500);
        fenetre.setVisible(true);

        // create a panel
        JPanel Panel = new JPanel();

        // create a progressbar
        Barre = new JProgressBar();

        // set initial value
        Barre.setValue(0);
        Barre.setStringPainted(true);

        // add progressbar
        Panel.add(Barre);

        // add panel
        fenetre.add(Panel);
        fenetre.add(btn_Start);

        Panel.setBounds(100,0,150,50);
        btn_Start.setBounds(0,0,80,30);


        btn_Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fill();
            }
        });


    }



    // function to increase progress 
    public static void fill()
    {
        int i = 0;
        try {
            while (i <= 100) {
                // fill the menu bar
                Barre.setValue(i + 10);

                // delay the thread
                Thread.sleep(1000);
                i += 20;
            }
        }
        catch (Exception e) {
        }
    }
} 