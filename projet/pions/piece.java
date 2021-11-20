package pions;

public abstract class piece {
    //classe inutilisé si t'as des truc ici que tu veux garder tu peux les mettres dans Piece.
    private int team;

    public piece(int team){
        this.team = team;
    }

    public abstract void deplacement();
    public abstract void deplacementpossible();
    public int getCouleur(){
        return team;
    }
}
