package pions;

import java.awt.Color;

public class tour extends Piece {

    public tour(Color couleurPiece) {
		super(couleurPiece);
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (couleurPiece==Color.white) ? "TB" : "TN";
    }
}
