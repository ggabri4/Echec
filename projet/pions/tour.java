package pions;

import java.awt.Color;
import java.util.ArrayList;

public class tour extends piece {

    public tour(Color couleurPiece) {
		super(couleurPiece);
	}
    public int pionmoves(String grille[][], int x, int y, ArrayList<String> List){
        int retour=0;
        int i=1;
        while(x-i>=0&&y>=0&&i<8 &&(grille[x-i][y]==null||i==0)){//vers bas droite
            grille[x-i][y] = "I";
            if(List!=null)  List.add((x-i)+";"+(y));
            retour=1;
            i++;
        }i=1;
        while(x>=0&&y+i>=0&&i<8&&y+i<14&&(grille[x][y+i]==null||i==0)){//vers bas gauche
            grille[x][y+i] = "I";
            if(List!=null)  List.add((x)+";"+(y+i));
            retour=1;  
            i++;
        }i=1;
        while(x+i>=0&&y>=0&&i<8 &&(grille[x+i][y]==null||i==0)){//vers haut droite
            grille[x+i][y] = "I";
            if(List!=null)  List.add((x+i)+";"+(y));
            retour=1;
            i++;
        }i=1;
        while(x>=0&&y-i>=0&&i<8 &&(grille[x][y-i]==null||i==0)){//vers haut gauche
            grille[x][y-i] = "I";
            if(List!=null)  List.add((x)+";"+(y-i));
            retour=1;
            i++;
        }
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		eatPiece(grille,x,y,List);
		return retour;
	}

    public int eatPiece(String grille[][], int x, int y, ArrayList<String> List){
        int retour=0;
        int i=0;

        while(x-i>=0&&i<8 &&(i==0||grille[x-i][y]=="I")){//vers haut
            i++;
            if(x-i>=0&&grille[x-i][y]!="I"){
                grille[x-i][y] = grille[x-i][y]+"M";
                if(List!=null)  List.add((x-i)+";"+(y));
                retour=1;
            }
        }i=0;
        while(y+i>=0&&i<8&&y+i<14&&(i==0||grille[x][y+i]=="I")){//vers droite
            i++;
            if(y+i>=0&&grille[x][y+i]!="I"){
                grille[x][y+i] = grille[x][y+i]+"M";
                if(List!=null)  List.add((x)+";"+(y+i));
                retour=1;  
            }
        }i=0;
        while(x+i>=0&&i<8 &&(i==0||grille[x+i][y]=="I")){//vers gauche
            i++;
            if(x+i>=0&&grille[x+i][y]!="I"){
                grille[x+i][y] = grille[x+i][y]+"M";
                if(List!=null)  List.add((x+i)+";"+(y));
                retour=1;
            }
        }i=0;
        //System.out.println(grille[x+i][y]+"  =  "+(grille[x+i][y]==null||grille[x][y-i]=="I"));
        while(y-i>=0&&i<8 &&(grille[x][y-i]=="I"||i==0)){//vers gauche 
            //System.out.println(""+grille[x][y-i]);
            i++;
            if(y-i>=0&&grille[x][y-i]!="I"){
                grille[x][y-i] = grille[x][y-i]+"M";
                retour=1;
            }
        }
		return retour;
	}

    @Override
    public String toString() {
        return (couleurPiece==Color.white) ? "TB" : "TN";
    }
}
