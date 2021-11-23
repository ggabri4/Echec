package pions;

import java.awt.Color;

public class cavalier extends Piece {
    //chaque piece a une couleur et une appelation, "C" pour cavalier etc.. pour leur bonne affichage dans le plateau.
    public cavalier(Color couleurPiece) {
		super(couleurPiece);
	}
    
    public int pionmoves(String grille[][], int x, int y, int val){
        int a =val;
        if(val==a){//c'était pour rentrer dans l'action pour tout vérifier.
		    if(grille[x+val*2][y+val]==null){
			grille[x+val*2][y+val] = "I";
            }
			if(x+val<0 || x+val>15){System.out.println("OUT OF RANGE");}
			if(grille[x+val*2][y-val]==null)
				grille[x+val*2][y-val] = "I";

            if(grille[x+val][y+val*2]==null){
                    grille[x+val][y+val*2] = "I";
            }
                    if(x+val<0 || x+val>15){System.out.println("OUT OF RANGE");}
                    else if(grille[x+val][y-val*2]==null)
                        grille[x+val][y-val*2] = "I";
        
                    //PARTI SI UN PION EST MANGEABLE -------------------------------
                    //eatPiece(grille, val,x,y);
                    //return 1;
            
            if(grille[x-val*2][y+val]==null){
                    grille[x-val*2][y+val] = "I";
            }
                    if(x+val<0 || x+val>15){System.out.println("OUT OF RANGE");}
                    else if(grille[x-val*2][y-val]==null)
                        grille[x-val*2][y-val] = "I";
        
                    //PARTI SI UN PION EST MANGEABLE -------------------------------
                    //eatPiece(grille, val,x,y);
                    //return 1;
            
            if(grille[x-val][y+val*2]==null)
                    grille[x-val][y+val*2] = "I";
            
                    if(x+val<0 || x+val>15){System.out.println("OUT OF RANGE");}
                    else if(grille[x-val][y-val*2]==null)
                        grille[x-val][y-val*2] = "I";
        
                    //PARTI SI UN PION EST MANGEABLE -------------------------------
                    //eatPiece(grille, val,x,y);
                    //return 1;
			//PARTI SI UN PION EST MANGEABLE -------------------------------
			eatPiece(grille, val,x,y);
			return 1;
		}
        
		//else if(eatPiece(grille, val,x,y)==1){
		//	return 1;
		//}
		return 0;
	}
    //j'ai pas changer eat piece par rapport a pion.
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
        return (couleurPiece==Color.white) ? "CB" : "CN";
    }
}
