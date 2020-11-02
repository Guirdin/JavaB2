package ExosGraphique.Class_Undo;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

    public static void main(String[] main) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());  // Ajout d'un look'n feel/thème

        TpUndoManager fen = new TpUndoManager();
        fen.setVisible(true);
    }
}
