import java.awt.*;
import javax.swing.*;


public class plateau extends JFrame{
 
    private int x,y;
	private static final long serialVersionUID = 1L;

	public plateau(int x, int y) {
        super("plateau");
        // initialization code...
        this.x=x;
        this.y=y;
    }
	
	public void affiche() {
		int chiffre = 7;
		int lettre = 65;
		setSize(x, y);
        JPanel pan = new JPanel (new GridLayout(8,9));
        for(int i = 0; i<72;i++){
           JPanel ptest = new JPanel();
           if(i%9==0) {
        	   if(chiffre != 0) {
        		   JLabel label = new JLabel(""+chiffre);
        		   ptest.add(label);
            	   chiffre--;
        	   }
           }
           if(i>63) {
        	   char l = (char) lettre;
        	   JLabel label = new JLabel(""+l); 
        	   ptest.add(label);
        	   lettre++;
           }
        	  
           else if(i%2==1 && i%9!=0) ptest.setBackground(Color.gray);
           
           pan.add(ptest);
        }
        Image icon = Toolkit.getDefaultToolkit().getImage("chess.png");  
        setIconImage(icon); // Change l'icone de l'application
        add(pan);
        setVisible(true);
	}
}