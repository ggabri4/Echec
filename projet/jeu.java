//import pions.*;
//import javax.swing.JFrame;

import java.io.FileNotFoundException;
import java.io.IOException;

import echecController.*;
import echecVue.Popup;
import echecVue.XMLTools;

public class jeu {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//ici je crée une grille esuite j'ai crée un controller qui prend la grille crée
		new Popup();
		Grille grille;
		if (Popup.getResult()==0) {
			grille = (Grille) XMLTools.decodeFromFile("grille.xml");
		}else {
			grille = new Grille();
		}
		System.out.println(Popup.getResult());
		echequierController controler=new echequierController(grille);
		System.out.println("Lancement de l'application : " + controler);
		controler.init();//Init finale avec tous le reste du programme prêt.
	}

}
