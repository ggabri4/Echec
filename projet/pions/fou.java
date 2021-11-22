package pions;

import java.awt.Color;

public class fou extends Piece {

    public fou(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "FB" : "FN";
    }
}
