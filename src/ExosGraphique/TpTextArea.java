package ExosGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class TpTextArea extends JFrame implements ActionListener{

    private JButton bSimple = new JButton("Add text");
    private JButton bWrap = new JButton("wrap");
    private JButton bNoWrap = new JButton("No Wrap");
    private JTextArea textArea = new JTextArea();


    public TpTextArea() {
        super("TextArea");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel tableau = (JPanel) this.getContentPane();
        tableau.setLayout(null);


        bSimple.addActionListener(this);
        tableau.add(bSimple);
        bSimple.setBounds(40, 310, 100, 30);

        bNoWrap.addActionListener(this);
        bNoWrap.setBounds(190, 310, 100, 30);
        tableau.add(bNoWrap);
        bNoWrap.setVisible(false);

        bWrap.addActionListener(this);
        tableau.add(bWrap);
        bWrap.setBounds(190, 310, 100, 30);

        JScrollPane pane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setBounds(0, 5, 337, 290);
        tableau.add(pane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bSimple) {
            textArea.append("On ajoute une ligne de texte");
        }
        if(e.getSource() == bWrap) {
            textArea.setLineWrap(true);
            bWrap.setVisible(false);
            bNoWrap.setVisible(true);
        }
        if(e.getSource() == bNoWrap) {
            textArea.setLineWrap(false);
            bWrap.setVisible(true);
            bNoWrap.setVisible(false);
        }
    }

    public static void main(String[] main) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpTextArea fen = new TpTextArea();
        fen.setVisible(true);
    }
}
