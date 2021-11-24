package echecVue;
import javax.swing.*;

public class Popup extends JFrame {

    private static int result;

public Popup(){
    affiche();
}

public void affiche() {
        
        result = JOptionPane.showConfirmDialog(this, "Voulez-vous reprendre la dernière partie ?");

        
        if (result == 0)
            System.out.println("You pressed Yes");
        else if (result == 1)
            System.out.println("You pressed NO");
        else if (result == 2)
            System.exit(0);

        this.setVisible(true);
        this.dispose();
        
    }
    
    public static int getResult(){
        return result;
    }
}