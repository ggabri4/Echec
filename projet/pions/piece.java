package pions;

import java.awt.Color;


public abstract class piece {

    //classe piece on a leur couleur
    protected  Color couleurPiece; 
	
	public piece(Color couleurPiece) {
		this.couleurPiece = couleurPiece;
	}

    public abstract String toString();
	
	public Color getCouleur(){
		return couleurPiece;
	}
}