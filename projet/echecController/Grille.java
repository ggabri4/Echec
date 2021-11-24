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
	private  ArrayList<Observer> listObs;
	private ArrayList<String> moves;
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
		moves = new ArrayList<String>();
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
			if(grille[x1][y1]==null || grille[x2][y2]==null || x2>6 || y2==0)
				return 0;
			else if(grille[x2][y2]=="I")
			{
				grille[x2][y2]=grille[x1][y1];
				grille[x1][y1]=null;
				resetIndicateur();
				moves.add("move("+x1+","+y1+";"+x2+","+y2+")");
				notifyObserver(moves);
				return 1;
			}
			else if(grille[x1][y1].substring(1, 2).contains(grille[x2][y2].substring(1, 2))){
				resetIndicateur();
				return 3;
			}
			else if(grille[x2][y2].contains("M")){
				grille[x2][y2]=grille[x1][y1];
				grille[x1][y1]=null;
				resetIndicateur();
				moves.add("move("+x1+","+y1+";"+x2+","+y2+")");
                //System.out.println(moves);
				notifyObserver(moves);
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
                if(grille[i][j]=="I")
					grille[i][j]=null;
                else if(grille[i][j]!=null && grille[i][j].contains("M"))
                    grille[i][j] = grille[i][j].substring(0,2);
            }
				
	}
	public int PossibleMoves(int x, int y){
		int retour = 0;
		try{
			if(grille[x][y] == null || grille[x][y] == "I")
				return 0;

			int	val = (grille[x][y].substring(1, 2).contains("N"))?1:-1;

			if(x+val<0 || x+val>6)
				return 0;
			
			switch(grille[x][y].substring(0, 1)){
				case "P":
						retour = pionB.pionmoves(grille, x, y, val);
					break;
				case "C":
					retour = cavalierB.pionmoves(grille, x, y, val);
					break;
			}
			
			notifyObserver(moves);
			//if(pionmoves(x,y,val)==1){
			//	notifyObserver(null);//afficher les indicateurs de déplacements
			//	return 1;
			//}
	
		}catch(Exception e){throw(e);}
		return retour;
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

	@Override
	public void addObserver() {
		this.listObs.add(new plateau(700,700,new echequierController(this)));
		//notifyObserver(null);
	}


	@Override
	public void notifyObserver(ArrayList<String> moves) {
		Iterator<Observer> it = listObs.iterator();
		
		while (it.hasNext()) {
			((plateau) it.next()).update(null, null);
		}
	}

	@Override
	public void removeObserver(Observer obs) {
		listObs.remove(obs);
	}
}
