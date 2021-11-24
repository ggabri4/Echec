package pions;

import java.awt.Color;

public class cavalier extends Piece {
    //chaque piece a une couleur et une appelation, "C" pour cavalier etc.. pour leur bonne affichage dans le plateau.
    public cavalier(Color couleurPiece) {
		super(couleurPiece);
	}
    
    public int pionmoves(String grille[][], int x, int y, int val){
        int retour = 0;
        
		if(grille[x+2][y+1]==null){
		    grille[x+2][y+1] = "I";
            retour=1;
        }
        
		if(y-1>=0 && grille[x+2][y-1]==null){
			grille[x+2][y-1] = "I";
            retour=1;
        }
        if(x-1>=0 && grille[x-1][y+2]==null){
            grille[x-1][y+2] = "I";
            retour=1;
        }
        if(x-1>=1 && y-2>=0 && grille[x-1][y-2]==null){
            grille[x-1][y-2] = "I";
            retour=1;
        }
        if(grille[x+1][y+2]==null){
		    grille[x+1][y+2] = "I";
            retour=1;
        }
		if(y-2>=0 && grille[x+1][y-2]==null){
			grille[x+1][y-2] = "I";
            retour=1;
        }
        if(x-2>=0 && grille[x-2][y+1]==null){
            grille[x-2][y+1] = "I";
            retour=1;
        }
        if(x-2>=0 && y-1>0 && grille[x-2][y-1]==null){
            grille[x-2][y-1] = "I";
            retour=1;
        }
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		eatPiece(grille, val,x,y);
		return retour;
	}
    //j'ai pas changer eat piece par rapport a pion.
	public int eatPiece(String grille[][], int val, int x, int y){
        int retour = 0;
		if(grille[x+2][y+1]!=null && grille[x+2][y+1] != "I"){
            if(!(grille[x+2][y+1].contains(grille[x][y].substring(1, 2)))){
                grille[x+2][y+1] = grille[x+2][y+1]+"M";
                retour=1;
            }
        }
        
		if(y-1>=0 && grille[x+2][y-1]!=null && grille[x+2][y-1] != "I"){
			if(!(grille[x+2][y-1].contains(grille[x][y].substring(1, 2)))){
                grille[x+2][y-1] = grille[x+2][y-1]+"M";
                retour=1;
            }
        }
        if(x-1>=0 && grille[x-1][y+2]!=null && grille[x-1][y+2] != "I"){
            if(!(grille[x-1][y+2].contains(grille[x][y].substring(1, 2)))){
                grille[x-1][y+2] = grille[x-1][y+2]+"M";
                retour=1;
            }
        }
        if(x>=1 && y-2>=0 && grille[x-1][y-2]!=null && grille[x-1][y-2] != "I"){
            if(!(grille[x-1][y-2].contains(grille[x][y].substring(1, 2)))){
                grille[x-1][y-2] = grille[x-1][y-2]+"M";
                retour=1;
            }
        }
        if(grille[x+1][y+2]!=null && grille[x+1][y+2] != "I"){
		    if(!(grille[x+1][y+2].contains(grille[x][y].substring(1, 2)))){
                grille[x+1][y+2] = grille[x+1][y+2]+"M";
                retour=1;
            }
        }
		if(y-2>=0 && grille[x+1][y-2]!=null && grille[x+1][y-2] != "I"){
			if(!(grille[x+1][y-2].contains(grille[x][y].substring(1, 2)))){
                grille[x+1][y-2] = grille[x+1][y-2]+"M";
                retour=1;
            }
        }
        if(x-2>=0 && grille[x-2][y+1]!=null && grille[x-2][y+1] != "I"){
            if(!(grille[x-2][y+1].contains(grille[x][y].substring(1, 2)))){
                grille[x-2][y+1] = grille[x-2][y+1]+"M";
                retour=1;
            }
        }
        if(x-2>=0 && y-1>=0 && grille[x-2][y-1]!=null && grille[x-2][y-1] != "I"){
            if(!(grille[x-2][y-1].contains(grille[x][y].substring(1, 2)))){
                grille[x-2][y-1] = grille[x-2][y-1]+"M";
                retour=1;
            }
        }
		return retour;
	}
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "CB" : "CN";
    }
}