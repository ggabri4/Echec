package pions;

import java.awt.Color;
import java.util.ArrayList;

public class fou extends piece {

    public fou(Color couleurPiece) {
		super(couleurPiece);
	}
    public int pionmoves(String grille[][], int x, int y, ArrayList<String> List){
        int retour=0;
        int i=1;
        while(x-i>=0&&y-i>=0&&i<7 &&(grille[x-i][y-i]==null||i==0)){//vers bas droite
            grille[x-i][y-i] = "I";
            retour=1;
            if(List!=null)  List.add((x-i)+";"+(y-i));
            i++;
        }i=1;
        while(x-i>=0&&y+i>=0&&i<7 &&(grille[x-i][y+i]==null||i==0)){//vers bas gauche
            grille[x-i][y+i] = "I";
            retour=1;  
            if(List!=null)  List.add((x-i)+";"+(y+i));
            i++;
        }i=1;
        while(x+i>=0&&y-i>=0&&i<7 &&(grille[x+i][y-i]==null||i==0)){//vers haut droite
            grille[x+i][y-i] = "I";
            retour=1;
            if(List!=null)  List.add((x+i)+";"+(y-i));
            i++;
        }i=1;
        while(x+i>=0&&y+i>=0&&i<7 &&(grille[x+i][y+i]==null||i==0)){//vers haut gauche
            grille[x+i][y+i] = "I";
            retour=1;
            if(List!=null)  List.add((x+i)+";"+(y+i));
            i++;
        }
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		eatPiece(grille,x,y);
		return retour;
	}
    //j'ai pas changer eat piece par rapport a pion.
	public int eatPiece(String grille[][], int x, int y){
        int retour=0;
        int i=1;
        for(i=1;x-i>0&&y-i>0&&i<7&&x-i<14&&y-i<14 &&(grille[x-i][y-i]==null||grille[x-i][y-i]=="I");i++);
        if((x-i<0||y-i<0)||grille[x-i][y-i]=="I");
        else if(grille[x-i][y-i]!=null){
           grille[x-i][y-i] = grille[x-i][y-i]+"M";
            retour=1; 
        }
        for(i=1;x-i>0&&y+i>0&&i<7&&x-i<14&&y+i<14 &&(grille[x-i][y+i]==null||grille[x-i][y+i]=="I");i++);
        if((x-i<0||y+i<0)||grille[x-i][y+i]=="I");
        else if(grille[x-i][y+i]!=null){
            grille[x-i][y+i] = grille[x-i][y+i]+"M";
            retour=1;  
        }
        for(i=1;x+i>0&&y-i>0&&i<7&&(grille[x+i][y-i]==null||grille[x+i][y-i]=="I");i++);
        if((x+i<0||y-i<0)||grille[x+i][y-i]=="I");
        else if(grille[x+i][y-i]!=null){
            grille[x+i][y-i] = grille[x+i][y-i]+"M";
            retour=1;
        }
        for(i=1;x+i>0&&y+i>0&&i<7&&x+i<14&&y+i<14 &&(grille[x+i][y+i]==null||grille[x+i][y+i]=="I");i++);
        if((x+i<0||y+i<0)||grille[x+i][y+i]=="I");
        else if(grille[x+i][y+i]!=null){
            grille[x+i][y+i] = grille[x+i][y+i]+"M";
            retour=1;
        }
		
		return retour;
	}
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "FB" : "FN";
    }
}