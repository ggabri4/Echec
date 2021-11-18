package echecVue;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class echecPanel extends JPanel{
    private plateau monPlateau;

    public echecPanel(plateau monPlateau){
        setPreferredSize(new Dimension(800, 800));
        this.monPlateau = monPlateau;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        monPlateau.affichePiece(g);
    }
}
