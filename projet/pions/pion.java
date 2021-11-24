package pions;

import java.awt.Color;

public class pion extends Piece {

    public pion(Color couleurPiece) {
		super(couleurPiece);
	}

    public int pionmoves(String grille[][], int x, int y, int val){
		if(x+val>=0 && grille[x+val][y]==null){
			grille[x+val][y] = "I";
			if(x+val<0 || x+val>6){System.out.println("OUT OF RANGE");}
			else if(grille[x+val][y]==null)
				grille[x+val*1][y] = "I";

			//PARTI SI UN PION EST MANGEABLE -------------------------------
			eatPiece(grille, val,x,y);
			return 1;
		}
		else if(eatPiece(grille, val,x,y)==1){
			return 1;
		}
		return 0;
	}

	public int eatPiece(String grille[][], int val, int x, int y){
		int retour=0;
		if (x+val>=0 && grille[x+val][y+1] != null) {
			if (!(grille[x+val][y+1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y+1] = grille[x+val][y+1] + "M";//M pour mangeable
				retour = 1;
			}
		}
		if(x+val>=0 && grille[x+val][y-1] != null){
			if (!(grille[x+val][y-1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y-1] = grille[x+val][y-1] + "M";//M pour mangeable
				retour = 1;
			}	
		}
		return retour;
	}
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "PB" : "PN";
    }
}
