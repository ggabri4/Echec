package echecVue.grille;
import pions.*;
import java.awt.Color;

public class Grille {

    //on creé un tableau de case
    public String[][] grille;

    public void setGrille(String[][] grille) {
		this.grille = grille;
	}

	public String[][] getGrille() {
		return grille;
	}

    public Grille() {
    // on initialise le tableau de case.
    this.grille  = new String[8][9];
	
        // on initalise chaque case vide
		//for(int i=0; i<grille.length; i++) {
		//	for(int j=0; j<grille[i].length; j++) {
		//		grille[i][j] = new String(null,i,j);//null correspond a "sans piéce sur la case".
		//	}
		//}
        //ici on crée les objet correspondant aux piéces et a la position qu'il ont sur l'echequier au début.
		//Noir :
		tour tourN = new tour(Color.black);
		cavalier cavalierN = new cavalier(Color.black);
		fou fouN = new fou(Color.black);
		reine reineN = new reine(Color.black);
		roi roiN = new roi(Color.black);
		pion pionN = new pion(Color.black);
		//Blanc :
		tour tourB = new tour(Color.white);
		cavalier cavalierB = new cavalier(Color.white);
		fou fouB = new fou(Color.white);
		reine reineB = new reine(Color.white);
		roi roiB = new roi(Color.white);
		pion pionB = new pion(Color.white);

		grille[0][1]= tourN.toString();
		grille[0][2]= cavalierN.toString();
		grille[0][3]= fouN.toString();
		grille[0][4]= reineN.toString();
		grille[0][5]= roiN.toString();
		grille[0][6]= fouN.toString();
		grille[0][7]= cavalierN.toString();
		grille[0][8]= tourN.toString();
		grille[1][1]= pionN.toString();
		grille[1][2]= pionN.toString();
		grille[1][3]= pionN.toString();
		grille[1][4]= pionN.toString();
		grille[1][5]= pionN.toString();
		grille[1][6]= pionN.toString();
		grille[1][7]= pionN.toString();
		grille[1][8]= pionN.toString();

		grille[6][1]= tourB.toString();
		grille[6][2]= cavalierB.toString();;
		grille[6][3]= fouB.toString();
		grille[6][4]= reineB.toString();
		grille[6][5]= roiB.toString();
		grille[6][6]= fouB.toString();
		grille[6][7]= cavalierB.toString();
		grille[6][8]= tourB.toString();
		grille[5][1]= pionB.toString();
		grille[5][2]= pionB.toString();
		grille[5][3]= pionB.toString();
		grille[5][4]= pionB.toString();
		grille[5][5]= pionB.toString();
		grille[5][6]= pionB.toString();
		grille[5][7]= pionB.toString();
		grille[5][8]= pionB.toString();
    }
	public String getcase(int x, int y){
		return grille[x][y];
	}
	public void setcase(int x, int y, String piece){
		grille[x][y] = piece;
	}

}
