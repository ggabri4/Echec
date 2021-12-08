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
        while(x-i>=0&&y-i>=0&&i<7 &&(grille[x-i][y-i]==null||i==0)){
            grille[x-i][y-i] = "I";
            retour=1;
            if(List!=null)  List.add((x-i)+";"+(y-i));
            i++;
        }i=1;
        while(x-i>=0&&y+i>=0&&i<7 &&(grille[x-i][y+i]==null||i==0)){
            grille[x-i][y+i] = "I";
            retour=1;  
            if(List!=null)  List.add((x-i)+";"+(y+i));
            i++;
        }i=1;
        while(x+i>=0&&y-i>=0&&i<7 &&(grille[x+i][y-i]==null||i==0)){
            grille[x+i][y-i] = "I";
            retour=1;
            if(List!=null)  List.add((x+i)+";"+(y-i));
            i++;
        }i=1;
        while(x+i>=0&&y+i>=0&&i<7 &&(grille[x+i][y+i]==null||i==0)){
            grille[x+i][y+i] = "I";
            retour=1;
            if(List!=null)  List.add((x+i)+";"+(y+i));
            i++;
        }
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		int eat = eatPiece(grille, x, y, List);
		if(retour==0) retour = eat;
		return retour;
	}
    //Comme dans chaque classe de piece, il y a des doubles verifications pour certains bugs
	public int eatPiece(String grille[][], int x, int y, ArrayList<String> List){
        int retour=0;
        int i=1;
        for(i=1;x-i>0&&y-i>0&&i<7&&x-i<14&&y-i<14 &&(grille[x-i][y-i]==null||grille[x-i][y-i]=="I");i++);
        if((x-i<0||y-i<0)||grille[x-i][y-i]=="I");
        else if(grille[x-i][y-i]!=null&&!grille[x-i][y-i].contains("I")){
           grille[x-i][y-i] = grille[x-i][y-i].substring(0, 2)+"M";
           if(List!=null)  List.add((x-i)+";"+(y-i));
            retour=1; 
        }
        for(i=1;x-i>0&&y+i>0&&i<7&&x-i<14&&y+i<14 &&(grille[x-i][y+i]==null||grille[x-i][y+i]=="I");i++);
        if((x-i<0||y+i<0)||grille[x-i][y+i]=="I");
        else if(grille[x-i][y+i]!=null&&!grille[x-i][y+i].contains("I")){
            grille[x-i][y+i] = grille[x-i][y+i].substring(0, 2)+"M";
            if(List!=null)  List.add((x-i)+";"+(y+i));
            retour=1;  
        }
        for(i=1;x+i>0&&y-i>0&&i<7&&(grille[x+i][y-i]==null||grille[x+i][y-i]=="I");i++);
        if((x+i<0||y-i<0)||grille[x+i][y-i]=="I");
        else if(grille[x+i][y-i]!=null&&!grille[x+i][y-i].contains("I")){
            grille[x+i][y-i] = grille[x+i][y-i].substring(0, 2)+"M";
            if(List!=null)  List.add((x+i)+";"+(y-i));
            retour=1;
        }
        for(i=1;x+i>0&&y+i>0&&i<7&&x+i<14&&y+i<14 &&(grille[x+i][y+i]==null||grille[x+i][y+i]=="I");i++);
        if((x+i<0||y+i<0)||grille[x+i][y+i]=="I");
        else if(grille[x+i][y+i]!=null&&!grille[x+i][y+i].contains("I")){
            grille[x+i][y+i] = grille[x+i][y+i].substring(0, 2)+"M";
            if(List!=null)  List.add((x+i)+";"+(y+i));
            retour=1;
        }
		
		return retour;
	}
    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "FB" : "FN";
    }
}