package echecVue.grille;



public class Case{ 

	private Piece piece;
	private int ligne,colonne;
    //ici pour chaque case on a la piece la rangée et la colonne
	public Case(Piece piece, int ligne, int colonne) {

		this.piece = piece;
		this.ligne=ligne;
		this.colonne=colonne;
	}

    public String toString(){
		return ""+ligne+colonne;
	}
    
    public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
    // ça c'est pas obligatoire ça sert a avoir la notation pgn des echec genre cf6 pour cavalier f 6 etc...
    /**public String[] toStringPGN() {
		String retour[]=new String[2];

		switch(ligne){
		case 0:
			retour[1]="8";
			break;
		case 1: 
			retour[1]="7";
			break;
		case 2: 
			retour[1]="6";
			break;
		case 3: 
			retour[1]="5";
			break;
		case 4: 
			retour[1]="4";
			break;
		case 5: 
			retour[1]="3";
			break;
		case 6: 
			retour[1]="2";
			break;
		case 7: 
			retour[1]="1";
			break;
		default:
			retour[1]="";
			break;
		}

		switch (colonne){
		case 7:
			retour[0]="h";
			break;
		case 6:
			retour[0]="g";
			break;
		case 5:
			retour[0]="f";
			break;
		case 4:
			retour[0]="e";
			break;
		case 3:
			retour[0]="d";
			break;
		case 2:
			retour[0]="c";
			break;
		case 1:
			retour[0]="b";
			break;
		case 0:
			retour[0]="a";
			break;

		default:
			retour[0]="";
			break;
		}

		return retour;
	}*/

    public Object clone() throws CloneNotSupportedException {   
		return super.clone();
	}
}