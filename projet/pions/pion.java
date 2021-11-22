package pions;

import java.awt.Color;

public class pion extends Piece {

    public pion(Color couleurPiece) {
		super(couleurPiece);
	}

    public int pionmoves(String grille[][], int x, int y, int val){
		if(grille[x+val][y]==null){
			grille[x+val][y] = "I";
			if(x+val*2<0 || x+val*2>6){System.out.println("OUT OF RANGE");}
			else if(grille[x+val*2][y]==null)
				grille[x+val*2][y] = "I";

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
		if (grille[x+val][y+1] != null) {
			if (!(grille[x+val][y+1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y+1] = grille[x+val][y+1] + "M";//M pour mangeable
				if (grille[x+val][y-1] != null&&!(grille[x+val][y-1].contains(grille[x][y].substring(1, 2)))){}
				else
					return 1;
			}
		}
		if(grille[x+val][y-1] != null){
			if (!(grille[x+val][y-1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y-1] = grille[x+val][y-1] + "M";//M pour mangeable
				return 1;
			}	
		}
		return 0;
	}
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (couleurPiece==Color.white) ? "PB" : "PN";
    }
}
