//import pions.*;
//import javax.swing.JFrame;

import echecController.echequierController;
import echecVue.*;
import echecVue.grille.Grille;

public class jeu {

	public static void main(String[] args) {
		
		//ici je crée une grille esuite j'ai crée un controller qui prend la grille crée
		Grille grille = new Grille();
		echequierController controler=new echequierController(grille);
		plateau plateau = new plateau(700,700, controler);
		System.out.println("Lancement de l'application");

	}

}
