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
}
