package echecController;
import pions.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observer;

import java.util.Iterator;

import echecObservable.*;
import echecVue.plateau;

public class Grille implements Observable{

    //on creé un tableau de case
    private String[][] grille;
	private ArrayList<Observer> listObs;
	private ArrayList<String> pieces;
	private tour tourN;
	private cavalier cavalierN;
	private fou fouN;
	private reine reineN;
	private roi roiN;
	private pion pionN;
	//Blanc :
	private tour tourB;
	private cavalier cavalierB;
	private fou fouB;
	private reine reineB;
	private roi roiB;
	private pion pionB;

    public Grille() {
    // on initialise le tableau de case.
    	this.grille  = new String[15][15];	//Grille légérement trop grande pour éviter le out hors range lors du calcul des déplacements
											//Les partis de la grille pas utilisées ne causeront pas de problèmes 
		this.pieces = new ArrayList<String>();
		listObs = new ArrayList<Observer>();
        //ici on crée les objet correspondant aux piéces et a la position qu'il ont sur l'echequier au début.
		//Noir :
		tourN = new tour(Color.black);
		cavalierN = new cavalier(Color.black);
		fouN = new fou(Color.black);
		reineN = new reine(Color.black);
		roiN = new roi(Color.black);
		pionN = new pion(Color.black);
		//Blanc :
		tourB = new tour(Color.white);
		cavalierB = new cavalier(Color.white);
		fouB = new fou(Color.white);
		reineB = new reine(Color.white);
		roiB = new roi(Color.white);
		pionB = new pion(Color.white);

		grille[0][1]= tourN.toString();
		grille[0][2]= cavalierN.toString();
		grille[0][3]= fouN.toString();
		grille[0][4]= reineN.toString();
		grille[0][5]= roiN.toString();
		grille[0][6]= fouN.toString();
		grille[0][7]= cavalierN.toString();
		grille[0][8]= tourN.toString();
		grille[1][1]= pionN.toString();
		grille[1][2]= pionN.toString();
		grille[1][3]= pionN.toString();
		grille[1][4]= pionN.toString();
		grille[1][5]= pionN.toString();
		grille[1][6]= pionN.toString();
		grille[1][7]= pionN.toString();
		grille[1][8]= pionN.toString();

		grille[6][1]= tourB.toString();
		grille[6][2]= cavalierB.toString();;
		grille[6][3]= fouB.toString();
		grille[6][4]= reineB.toString();
		grille[6][5]= roiB.toString();
		grille[6][6]= fouB.toString();
		grille[6][7]= cavalierB.toString();
		grille[6][8]= tourB.toString();
		grille[5][1]= pionB.toString();
		grille[5][2]= pionB.toString();
		grille[5][3]= pionB.toString();
		grille[5][4]= pionB.toString();
		grille[5][5]= pionB.toString();
		grille[5][6]= pionB.toString();
		grille[5][7]= pionB.toString();
		grille[5][8]= pionB.toString();
		addObserver();
    }
	
	public int MovePiece(int x1, int y1, int x2, int y2){
		try{
			//System.out.println("x1 y1 : "+x1+" "+y1+"  x2, y2 : "+x2+" "+y2);
			if(grille[x1][y1]==null || grille[x2][y2]==null || x2>6 || y2==0)
				return 0;
			else if(grille[x2][y2]=="I")
			{
				grille[x2][y2]=grille[x1][y1];
				grille[x1][y1]=null;
				resetIndicateur();
				notifyObserver(pieces);
				return 1;
			}
			else if(grille[x1][y1].substring(1, 2).contains(grille[x2][y2].substring(1, 2))){
				resetIndicateur();
				return 3;
			}
			else if(grille[x2][y2].contains("M")){
				if(grille[x2][y2].contains("D"))//Si la piece est une dame
					if(pieces.contains(grille[x2][y2].substring(0,2)))//et que la liste contient déjà une dame
						grille[x2][y2] = "P"+grille[x2][y2].substring(1, 2);//une des dames est un pion ayant eu une promotion
				pieces.add(grille[x2][y2].substring(0,2));
				System.out.println(pieces);
				grille[x2][y2]=grille[x1][y1];
				grille[x1][y1]=null;
				resetIndicateur();
                //System.out.println(pieces);
				notifyObserver(pieces);
				return 1;
			}
			
		}catch(Exception e){
			throw(e);
		}
		return 0;
	}
	public void resetIndicateur(){
		for (int i = 0; i < 7; i++)
			for (int j = 1; j < 9; j++){
                if(grille[i][j]!=null && grille[i][j].contains("I"))
					grille[i][j]=null;
                else if(grille[i][j]!=null && grille[i][j].contains("M"))
					if(grille[i][j]!=null && grille[i][j].contains("nu"))//cas d'erreur de reset où case = "nullM" par ex.
						grille[i][j]=null;	
					else
						grille[i][j] = grille[i][j].substring(0,2);
				else if(grille[i][j]!=null && grille[i][j].startsWith("M"))
					grille[i][j] = null;
            }
				
	}
	public int PossibleMoves(int x, int y){
		int retour = 0;
		try{
			if(grille[x][y] == null || grille[x][y] == "I")
				return 0;
			if(grille[x][y].substring(1, 2).contains("N"))
				return 0;
			int	val = (grille[x][y].substring(1, 2).contains("N"))?1:-1;

			switch(grille[x][y].substring(0, 1)){
				case "P":
						retour = pionB.pionmoves(grille, x, y, val, null);
					break;
				case "C":
						retour = cavalierB.pionmoves(grille, x, y, null);
					break;
				case "F":
						retour = fouB.pionmoves(grille, x, y, null);
					break;
				case "T":
					retour = tourB.pionmoves(grille, x, y, null);
				break;
				case "D":
					retour = reineB.pionmoves(grille, x, y, null);
				break;
				case "R":
					retour = roiB.pionmoves(grille, x, y, null);
				break;
			}
			
			notifyObserver(pieces);
			//if(pionmoves(x,y,val)==1){
			//	notifyObserver(null);//afficher les indicateurs de déplacements
			//	return 1;
			//}
	
		}catch(Exception e){throw(e);}
		return retour;
	}

	public int botmoves(int x, int y, String pion, String coups[][],int compt){
		ArrayList<String> listeCoups = new ArrayList<String>();

		switch(pion){
			case "P":
				pionB.pionmoves(grille, x, y, 1, listeCoups);	
				break;
			case "C":
				cavalierB.pionmoves(grille, x, y, listeCoups);
				break;
			case "F":
				fouB.pionmoves(grille, x, y, listeCoups);
				break;
			case "T":
				tourB.pionmoves(grille, x, y, listeCoups);
			break;
			case "D":
				reineB.pionmoves(grille, x, y, listeCoups);
			break;
			case "R":
				roiB.pionmoves(grille, x, y, listeCoups);
			break;
		}
		notifyObserver(null);
		
		for(String element : listeCoups){
			String coord[] = new String[2];
			coord = element.split(";");
			int i =Integer.parseInt(coord[0]);
			int j =Integer.parseInt(coord[1]);

			if(grille[i][j]!=null && !grille[i][j].contains("N") && i<7 && j <8){
				//System.out.println(" depart "+i+";"+j+ "  arrivee "+element);
				coups[compt][0] = x+";"+y;
				coups[compt][1] = element;
				coups[compt][2] = String.valueOf(valeurcoup(x,y,element));
				compt++;
			}
		}
		return compt;
	}

	public int valeurcoup(int xd, int yd,String coup){
		int valeur=0;
		String coord[] = new String[2];
		coord = coup.split(";");
		int x =Integer.parseInt(coord[0]);
		int y =Integer.parseInt(coord[1]);
		if(y==1 || y==8)	valeur+=1;
		if(y==2 || y==7)	valeur+=2;
		if(y==3 || y==6)	valeur+=3;
		if(y==4 || y==5)	valeur+=4;
		if(grille[xd][yd].contains("R"))
			valeur-=500;
		if(grille[x][y]==null){}
		else if(grille[x][y].contains("R"))
			valeur+=999;
		else if(grille[x][y].contains("D"))
			valeur+=90;
		else if(grille[x][y].contains("T"))
			valeur+=50;
		else if(grille[x][y].contains("F"))
			valeur+=30;
		else if(grille[x][y].contains("C"))
			valeur+=30;
		else if(grille[x][y].contains("P"))
			valeur+=10;
		return valeur;
	}

	public void setPiece(ArrayList<String> pieces){
		this.pieces = pieces;
	}
	public ArrayList<String> getPiece(){
		return pieces;
	}
	public void setGrille(String[][] grille) {
		this.grille = grille;
	}

	public String[][] getGrille() {
		return grille;
	}
	public String getCase(int i, int j){
		return grille[i][j];
	}

	public void setCase(int i, int j, String piece){
		this.grille[i][j]= piece;
		notifyObserver(null);
	}
	public int init(){
		notifyObserver(null);
		return 1;
	}
	
	@Override
	public void addObserver() {
		this.listObs.add(new plateau(700,700,new echequierController(this)));
		//notifyObserver(null);
	}


	@Override
	public void notifyObserver(ArrayList<String> pieces) {
		Iterator<Observer> it = listObs.iterator();
		while (it.hasNext()) {
			plateau plateau = ((plateau) it.next());
			plateau.update(null, null);
			if(pieces!=null && (pieces.contains("RN") || pieces.contains("RN"))){
				try {
					plateau.Perdu((pieces.contains("RN"))?"N":"B");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
		}
		
	}

	@Override
	public void removeObserver(Observer obs) {
		listObs.remove(obs);
	}
}
