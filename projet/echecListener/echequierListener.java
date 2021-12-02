package echecListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.Window;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import echecController.echequierController;

public class echequierListener extends MouseAdapter implements ActionListener{
    public int x,y;
    public int xpromo,ypromo;
    public int x1, y1;//position premier click
    public int x2, y2;//position deuxième click
    public echequierController controller;
    public boolean FirstClick;

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
            if(controller.MovePiece(x1,y1,x2,y2)==1){
                FirstClick=true;
                robot();
            }
            else if(controller.MovePiece(x1,y1,x2,y2)==3){
                x1 = MouseX;
                y1 = MouseY;
                controller.PossibleMoves(x2, y2);
            }
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
    public void setPromocase(int x, int y){
        xpromo = x;
        ypromo = y;
    }
    public void robot(){
        String pion;
        String coups[][] = new String[9][9];
		for (int i = 0; i < 7; i++)
			for (int j = 1; j < 9; j++){
                pion = controller.getModel().getCase(i, j);
                if(pion != null && pion.contains("N")){
                    pion = pion.substring(0, 1);
                    controller.botmoves(i, j, pion,coups);
                }
            }
        Arrays.sort(coups, 3, 5);
        for(String element[] : coups){
            System.out.println("1 depart "+element[0]+ "  arrivee "+element[1] + "  valeur "+element[2]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nompiece = controller.getModel().getCase(xpromo,ypromo);
        JButton button = (JButton)e.getSource();
        Window window = SwingUtilities.windowForComponent(button);

        String buttonName = button.toString().substring(20, 21);
        //System.out.println(bouton.substring(20, 21) + "  "+ nompiece);
        if (buttonName.contains("c"))
        {  
            nompiece = "C" + nompiece.substring(1,2);//nompiece et promo variable de la class car pas trouvé moyen de les mettres dans cette fonction
            controller.getModel().setCase(xpromo, ypromo, nompiece);
        }
        if (buttonName.contains("t"))
        {
            nompiece = "T" + nompiece.substring(1,2);;
            controller.getModel().setCase(xpromo, ypromo, nompiece);
        }
        if (buttonName.contains("f"))
        {
            nompiece = "F" + nompiece.substring(1,2);;
            controller.getModel().setCase(xpromo, ypromo, nompiece);
        }
        if (buttonName.contains("d"))
        {
            nompiece = "D" + nompiece.substring(1,2);;
            controller.getModel().setCase(xpromo, ypromo, nompiece);
        }
        window.dispose();
    }
    
}
