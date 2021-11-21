package echecController;

import echecVue.grille.Grille;

public class echequierController {

	protected Grille Model;
	
    //on crée un model qui correspond a la grille défini dans grille
    // c'est le controller mais j'ai rien mis dedans pour l'instant. il initialise juste la grille pour la récupérer dans plateau.
	public echequierController(Grille Model){
		this.Model=Model;
	}
	
	public Grille getModel(){
		return Model;
	}
	public void MovePiece(int x1, int y1, int x2, int y2){
		Model.MovePiece(y1, x1, y2, x2);//inverser les valeurs pour la grille
	}
}
