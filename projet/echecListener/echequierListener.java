package echecListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import echecController.echequierController;

public class echequierListener extends MouseAdapter{
    int x,y;
    int x1, y1;//position premier click
    int x2, y2;//position deuxième click
    echequierController controller;
    boolean FirstClick;

    public echequierListener(int x, int y, echequierController controller){
        super();
        this.x = x;
        this.y = y;
        this.controller = controller;
        this.FirstClick=true;
    }
    public void mousePressed(MouseEvent e){
        int MouseX = e.getX();
        int MouseY = e.getY();
        String pos = new String(calculcase(MouseX, MouseY));
        MouseX= Integer.parseInt(pos.substring(0,1));
        MouseY= Integer.parseInt(pos.substring(2,3));
        if(FirstClick){
            x1 = MouseX;
            y1 = MouseY;
            if(controller.PossibleMoves(x1, y1) == 1)
                FirstClick=false;
            
        }
        else{
            x2 = MouseX;
            y2 = MouseY;
            //System.out.println("2");
            if(controller.MovePiece(x1,y1,x2,y2)==1)
                FirstClick=true;
            else if(controller.MovePiece(x1,y1,x2,y2)==3){
                x1 = MouseX;
                y1 = MouseY;
                controller.PossibleMoves(x2, y2);
            }
                
            //System.out.println("grille["+ x1+"]["+ y1+"]");//position click 1
            //System.out.println("grille["+ x2+"]["+ y2+"]");//position click 2
        }
        //System.out.println(x1 + " " + y1 + " et " + x2 + " " + y2 + " " + FirstClick);
    }
    public void setsize(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String calculcase(int i, int j){
        //System.out.println("grille["+ i/(x/9)+"]["+ j/(y/8)+"]");//affiche la case clické
        return i/(x/9)+";"+j/(y/8);
    }
    
}
