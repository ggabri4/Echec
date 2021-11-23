//import pions.*;
//import javax.swing.JFrame;

import echecController.*;

public class jeu {

	public static void main(String[] args) {
		
		//ici je crée une grille esuite j'ai crée un controller qui prend la grille crée
		Grille grille = new Grille();
		echequierController controler=new echequierController(grille);
		System.out.println("Lancement de l'application : " + controler);
	}

}
