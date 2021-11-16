package echecVue;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class plateau extends JFrame implements Observer{
 
    private int x,y;
    private echecPanel echecP;
	private static final long serialVersionUID = 1L;

	public plateau(int x, int y) {
        super("plateau");
        // initialization code...
        this.x=x;
        this.y=y;
        afficheinterface();
    }

	public void afficheinterface(){
        this.setTitle("Chess game");
        this.setMinimumSize(new Dimension(500,500));
        Image icon = Toolkit.getDefaultToolkit().getImage("../../img/chess.png");
        this.setIconImage(icon); // Change l'icone de l'application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.echecP = new echecPanel(x, y, this) ;
        this.setContentPane(echecP);
    }

	public void afficheCase() {//Affichage des cases 
		int chiffre = 7;
		int lettre = 65;
		this.setSize(x, y);
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
        
        add(pan);
        setVisible(true);
	}

    public void affichePiece(Graphics g){
        
        g.drawImage(ImagePiece.pion , 250 , 250, null);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}