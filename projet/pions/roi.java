package pions;

import echecVue.grille.*;
import java.awt.Color;

public class roi extends Piece {

    public roi(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (couleurPiece==Color.white) ? "RB" : "RN";
    }
}
