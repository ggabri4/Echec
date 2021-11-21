package pions;

import java.awt.Color;

public class fou extends Piece {

    public fou(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (couleurPiece==Color.white) ? "FB" : "FN";
    }
}
