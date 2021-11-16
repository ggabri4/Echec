package echecVue;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class echecPanel extends JPanel{
    private plateau monPlateau;
    private int x, y;

    public echecPanel(int x, int y, plateau monPlateau){
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(1000, 1000));
        this.monPlateau = monPlateau;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        monPlateau.affichePiece(g);
    }
}
