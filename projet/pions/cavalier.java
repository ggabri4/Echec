package pions;

import java.awt.Color;

public class cavalier extends Piece {
    //chaque piece a une couleur et une appelation, "C" pour cavalier etc.. pour leur bonne affichage dans le plateau.
    public cavalier(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "CB" : "CN";
    }
}
