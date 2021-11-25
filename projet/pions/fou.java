package pions;

import java.awt.Color;

public class fou extends Piece {

    public fou(Color couleurPiece) {
		super(couleurPiece);
	}
    public int pionmoves(String grille[][], int x, int y, int val){
        int retour=0;
        int i=1;
        while(x-i>=0&&y-i>=0&&i<7 &&(grille[x-i][y-i]==null||i==0)){//vers bas droite
            grille[x-i][y-i] = "I";
            retour=1;
            i++;
        }i=1;
        while(x-i>=0&&y+i>=0&&i<7 &&(grille[x-i][y+i]==null||i==0)){//vers bas gauche
            grille[x-i][y+i] = "I";
            retour=1;  
            i++;
        }i=1;
        while(x+i>=0&&y-i>=0&&i<7 &&(grille[x+i][y-i]==null||i==0)){//vers haut droite
            grille[x+i][y-i] = "I";
            retour=1;
            i++;
        }i=1;
        while(x+i>=0&&y+i>=0&&i<7 &&(grille[x+i][y+i]==null||i==0)){//vers haut gauche
            grille[x+i][y+i] = "I";
            retour=1;
            i++;
        }
        
        //for(int i=-7; i<7; i++)
        //    for(int j=-7; j<7; j++){
        //        if(i==j||-i==j){
        //            //ici
        //            if(x+i>=0&&y+j>=0&&grille[x+i][y+j]==null){
        //                grille[x+i][y+j] = "I";
        //                retour=1;
        //            }  
        //        }      
        //}
		
		//PARTI SI UN PION EST MANGEABLE -------------------------------
		eatPiece(grille, val,x,y);
		return retour;
	}
    //j'ai pas changer eat piece par rapport a pion.
	public int eatPiece(String grille[][], int val, int x, int y){
        int retour=0;
        int i=1;
        for(i=1;x-i>0&&y-i>0&&i<7&&x-i<14&&y-i<14 &&(grille[x-i][y-i]==null||grille[x-i][y-i]=="I");i++);
        //System.out.println("1 "+(x-i<0||y-i<0));
        if((x-i<0||y-i<0)||grille[x-i][y-i]=="I");
        else if(grille[x-i][y-i]!=null){
           grille[x-i][y-i] = grille[x-i][y-i]+"M";
            retour=1; 
        }

        for(i=1;x-i>0&&y+i>0&&i<7&&x-i<14&&y+i<14 &&(grille[x-i][y+i]==null||grille[x-i][y+i]=="I");i++);
        System.out.println("2 "+(x-i<0||y+i<0));
        if((x-i<0||y+i<0)||grille[x-i][y+i]=="I");
        else if(grille[x-i][y+i]!=null){
            grille[x-i][y+i] = grille[x-i][y+i]+"M";
            retour=1;  
        }

        for(i=1;x+i>0&&y-i>0&&i<7&&(grille[x+i][y-i]==null||grille[x+i][y-i]=="I");i++);
        //System.out.println("3 "+(x+i<0||y-i<0));
        if((x+i<0||y-i<0)||grille[x+i][y-i]=="I");
        else if(grille[x+i][y-i]!=null){
            grille[x+i][y-i] = grille[x+i][y-i]+"M";
            retour=1;
        }

        for(i=1;x+i>0&&y+i>0&&i<7&&x+i<14&&y+i<14 &&(grille[x+i][y+i]==null||grille[x+i][y+i]=="I");i++);
        //System.out.println("4 "+(x+i<0||y+i<0));
        if((x+i<0||y+i<0)||grille[x+i][y+i]!="I");
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
