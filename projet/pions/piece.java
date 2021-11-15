package pions;

public abstract class piece {
    
    private int team;

    public piece(int team){
        this.team = team;
    }

    public abstract void deplacement();
    public abstract void deplacementpossible();
}
