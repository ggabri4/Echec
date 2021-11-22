package pions;

import java.awt.Color;

public class roi extends Piece {

    public roi(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "RB" : "RN";
    }
}
