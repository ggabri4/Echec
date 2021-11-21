package echecListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class echequierListener extends MouseAdapter{
    int x,y;
    boolean FirstClick;

    public echequierListener(int x, int y){
        super();
        this.x = x;
        this.y = y;
        this.FirstClick=true;
    }
    public void mousePressed(MouseEvent e){
        int MouseX = e.getX();
        int MouseY = e.getY();
        System.out.println(MouseX+"  "+MouseY);
        if(FirstClick){
            
        }

    }
    
}
