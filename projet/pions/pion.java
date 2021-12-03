package pions;

import java.awt.Color;
import java.util.ArrayList;

public class pion extends piece {

    public pion(Color couleurPiece) {
		super(couleurPiece);
	}

    public int pionmoves(String grille[][], int x, int y, int val, ArrayList<String> List){
		int retour=0;
		if(x+val>=0 && grille[x+val][y]==null){
			grille[x+val][y] = "I";
			retour = 1;
			if(List!=null)  List.add((x+val)+";"+y);
		}
		int eat = eatPiece(grille, val, x, y, List);
		if(retour==0) retour = eat;
		
		return retour;
	}

	public int eatPiece(String grille[][], int val, int x, int y, ArrayList<String> List){
		int retour=0;
		if (x+val>=0 && grille[x+val][y+1] != null && !grille[x+val][y+1].contains("I")) {
			if (!(grille[x+val][y+1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y+1] = grille[x+val][y+1].substring(0, 2) + "M";//M pour mangeable, substring pour éviter d'accumuler les M
				if(List!=null)  List.add((x+val)+";"+(y+1));
				retour = 1;
			}
		}
		if(x+val>=0 && grille[x+val][y-1] != null && !grille[x+val][y-1].contains("I")){
			if (!(grille[x+val][y-1].contains(grille[x][y].substring(1, 2)))){
				grille[x+val][y-1] = grille[x+val][y-1].substring(0, 2) + "M";//M pour mangeable, substring pour éviter d'accumuler les M
				if(List!=null)  List.add((x+val)+";"+(y-1));
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