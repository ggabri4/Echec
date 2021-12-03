package pions;

import java.awt.Color;
import java.util.ArrayList;

public class cavalier extends piece {
    //chaque piece a une couleur et une appelation, "C" pour cavalier etc.. pour leur bonne affichage dans le plateau.
    public cavalier(Color couleurPiece) {
		super(couleurPiece);
	}
    
    public int pionmoves(String grille[][], int x, int y, ArrayList<String> List){
        int retour = 0;
        
        for(int i=-2; i<3; i++)
            for(int j=-2; j<3; j++){
                if(i!=j&&-i!=j&&i!=0&&j!=0)
                    if(x+i>=0&&y+j>0&&y+j<9&&grille[x+i][y+j]==null){
                        grille[x+i][y+j] = "I";
                        retour=1;
                        if(List!=null)  List.add((x+i)+";"+(y+j));
                    }
            }
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		int eat = eatPiece(grille, x, y, List);
		if(retour==0) retour = eat;
		return retour;
	}
    //j'ai pas changer eat piece par rapport a pion.
	public int eatPiece(String grille[][], int x, int y, ArrayList<String> List){
        int retour = 0;
        for(int i=-2; i<3; i++)
            for(int j=-2; j<3; j++){
                if(i!=j&&-i!=j&&i!=0&&j!=0)
                    if(x+i>=0&&y+j>=0&& grille[x+i][y+j]!=null && grille[x+i][y+j]!="I"){
                        if(!(grille[x+i][y+j].contains(grille[x][y].substring(1, 2)))){
                            grille[x+i][y+j] = grille[x+i][y+j].substring(0, 2)+"M";
                            if(List!=null)  List.add((x+i)+";"+(y+j));
                            retour=1;
                        }
                    }
        }
		
		return retour;
	}
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "CB" : "CN";
    }
}