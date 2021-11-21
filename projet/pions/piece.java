package pions;

import java.awt.Color;


public abstract class Piece {

    //classe piece on a leur couleur
    protected  Color couleurPiece; 
	
	public Piece(Color couleurPiece) {
		this.couleurPiece = couleurPiece;
	}

    public abstract String toString();
	
	public Color getCouleur(){
		return couleurPiece;
	}
}
