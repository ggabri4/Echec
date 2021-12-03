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
		return Model.PossibleMoves(x,y);//On inverse les valeurs pour la grille
	}
	public int botmoves(int x, int y, String pion, String coups[][],int compt){
		return Model.botmoves(x,y,pion, coups,compt);
	}
	public int MovePiece(int x1, int y1, int x2, int y2){
		return Model.MovePiece(x1, y1, x2, y2);//On inverse les valeurs pour la grille
	}
	public int init(){
		return Model.init();
	}
	
}
