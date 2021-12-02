package echecController;

public class echequierController {

	protected Grille Model;
	
    //on crée un model qui correspond a la grille défini dans grille
    // c'est le controller mais j'ai rien mis dedans pour l'instant. il initialise juste la grille pour la récupérer dans plateau.
	public echequierController(echecController.Grille grille){
		this.Model=grille;
	}
	
	public Grille getModel(){
		return Model;
	}
	public int PossibleMoves(int x, int y){
		return Model.PossibleMoves(y,x);//On inverse les valeurs pour la grille
	}
	public int botmoves(int x, int y, String pion, String coups[][]){
		return Model.botmoves(x,y,pion, coups);
	}
	public int MovePiece(int x1, int y1, int x2, int y2){
		return Model.MovePiece(y1, x1, y2, x2);//On inverse les valeurs pour la grille
	}
}
