package echecVue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Popup extends JFrame {

    private static int result;

public Popup(){
    affiche();
}

public void affiche() {
        

        result = JOptionPane.showConfirmDialog(this, "Voulez-vous reprendre la dernière partie ?");
        //
        //
        if (result == 0)
           System.out.println("You pressed Yes");
        else if (result == 1)
            System.out.println("You pressed NO");
        else if (result == 2)
            System.exit(0);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }
    
    public static int getResult(){
        return result;
    }

}