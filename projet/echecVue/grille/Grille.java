package echecVue.grille;
import pions.*;
import java.awt.Color;

public class Grille {

    //on creé un tableau de case
    public Case[][] grille;

    public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public Case[][] getGrille() {
		return grille;
	}

    public Grille() {
    // on initialise le tableau de case.
    this.grille  = new Case[8][9];
        // on initalise chaque case vide
		for(int i=0; i<grille.length; i++) {
			for(int j=0; j<grille[i].length; j++) {
				grille[i][j] = new Case(null,i,j);//null correspond a "sans piéce sur la case".
			}
		}
        //ici on crée les objet correspondant aux piéces et a la position qu'il ont sur l'echequier au début.
		grille[0][1].setPiece(new tour(Color.black));
		grille[0][2].setPiece(new cavalier(Color.black));
		grille[0][3].setPiece(new fou(Color.black));
		grille[0][4].setPiece(new reine(Color.black));
		grille[0][5].setPiece(new roi(Color.black));
		grille[0][6].setPiece(new fou(Color.black));
		grille[0][7].setPiece(new cavalier(Color.black));
		grille[0][8].setPiece(new tour(Color.black));
		grille[1][1].setPiece(new pion(Color.black));
		grille[1][2].setPiece(new pion(Color.black));
		grille[1][3].setPiece(new pion(Color.black));
		grille[1][4].setPiece(new pion(Color.black));
		grille[1][5].setPiece(new pion(Color.black));
		grille[1][6].setPiece(new pion(Color.black));
		grille[1][7].setPiece(new pion(Color.black));
		grille[1][8].setPiece(new pion(Color.black));

		grille[5][1].setPiece(new pion(Color.white));
		grille[5][2].setPiece(new pion(Color.white));
		grille[5][3].setPiece(new pion(Color.white));
		grille[5][4].setPiece(new pion(Color.white));
		grille[5][5].setPiece(new pion(Color.white));
		grille[5][6].setPiece(new pion(Color.white));
		grille[5][7].setPiece(new pion(Color.white));
		grille[5][8].setPiece(new pion(Color.white));
		grille[6][1].setPiece(new tour(Color.white));
		grille[6][2].setPiece(new cavalier(Color.white));
		grille[6][3].setPiece(new fou(Color.white));
		grille[6][4].setPiece(new reine(Color.white));
		grille[6][5].setPiece(new roi(Color.white));
		grille[6][6].setPiece(new fou(Color.white));
		grille[6][7].setPiece(new cavalier(Color.white));
		grille[6][8].setPiece(new tour(Color.white));
    }

}
