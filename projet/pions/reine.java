package pions;

import java.awt.Color;

public class reine extends Piece {

    public reine(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "DB" : "DN"; // Dame car R déjà pris
    }
}
