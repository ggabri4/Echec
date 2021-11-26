package pions;

import java.awt.Color;

public class roi extends piece {

    public roi(Color couleurPiece) {
		super(couleurPiece);
	}
    public int pionmoves(String grille[][], int x, int y){
        int retour=0;
        int i=1;
        for(i=-1;i<2;i++)
            for(int j=-1;j<2;j++)
                if(x+i>=0&&y+j>=0 &&(grille[x+i][y+j]==null)){//vers bas droite
                    grille[x+i][y+j] = "I";
                    retour=1;
                }
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		eatPiece(grille,x,y);
		return retour;
	}

    public int eatPiece(String grille[][], int x, int y){
        int retour=0;
        int i=1;
        for(i=-1;i<2;i++)
            for(int j=-1;j<2;j++)
                if(x+i>=0&&y+j>=0 &&grille[x+i][y+j]!=null&&(grille[x+i][y+j]!="I")){//vers bas droite
                    grille[x+i][y+j] = grille[x+i][y+j]+"M";
                    retour=1;
                }
        
		return retour;
	}
    
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "RB" : "RN";
    }
}
