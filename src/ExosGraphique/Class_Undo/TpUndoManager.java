package ExosGraphique.Class_Undo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class TpUndoManager extends JFrame implements ActionListener{

    protected JButton BtnUndo = new JButton("Undo");
    protected JButton BtnRedo = new JButton("Redo");
    protected JTextArea Editor = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque congue leo eu laoreet fringilla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean luctus augue at dui tincidunt tristique. Curabitur dui magna, euismod non euismod sit amet, feugiat a erat.");
    protected UndoManager Manager = new UndoManager();

    public TpUndoManager(){
        super("Text Démo");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel tableau = (JPanel) this.getContentPane();
        tableau.setLayout(null);

        BtnUndo.addActionListener(this);
        tableau.add(BtnUndo);
        BtnUndo.setBounds(0, 0, 170, 42);

        BtnRedo.addActionListener(this);
        tableau.add(BtnRedo);
        BtnRedo.setBounds(168, 0, 170, 42);


        Editor.setBounds(0, 38, 337, 325);
        tableau.add(Editor);
        Editor.setLineWrap(true);

        Editor.getDocument().addUndoableEditListener(Manager);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == BtnUndo)
        {
            try
            {
                Manager.undo();
            }
            catch(CannotUndoException ex)
            {
                Toolkit.getDefaultToolkit().beep();

            }
        }

        if(e.getSource() == BtnRedo)
        {
            try
            {
                Manager.redo();
            }
            catch(CannotRedoException ex)
            {
                Toolkit.getDefaultToolkit().beep();

            }
        }
    }
}

