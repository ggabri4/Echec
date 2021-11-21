package pions;

import echecVue.grille.*;
import java.awt.Color;

public class reine extends Piece {

    public reine(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (couleurPiece==Color.white) ? "DB" : "DN"; // Dame car R déjà pris
    }
}
