package echecVue;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class plateau extends JFrame implements Observer{
 
    private int x,y,r;
    private echecPanel echecP;
	private static final long serialVersionUID = 1L;

	public plateau(int x, int y) {
        super("plateau");
        // initialization code...
        this.x=x;
        this.y=y;
        r=0;
        afficheinterface();
    }

	public void afficheinterface(){
        this.setTitle("Chess game");
        this.setMinimumSize(new Dimension(500,500));
        // Taille minimum 
        this.setPreferredSize(new Dimension(800,800));
        this.setLocationRelativeTo(null); 
        // Position de la fenetre à l'ouverture.
        Image icon = Toolkit.getDefaultToolkit().getImage("./img/chess.png"); 
        // On va cercher l'icone
        this.setIconImage(icon); 
        // Change l'icone de l'application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Stop le prog lorsqu'on ferme la fenetre
        this.echecP = new echecPanel(this);
        //afficheCase();
        this.setContentPane(echecP);
        setVisible(true);
        //On peut rendre la frame visible
    }

	public void afficheCase() {//Affichage des cases 
		int chiffre = 8;
		int lettre = 65;
		this.setSize(x, y);
        echecP.setLayout(new GridLayout(9,9));
        for(int i = 0; i<81;i++){
           JPanel ptest = new JPanel();
           if(i%9==0) {
        	   if(chiffre != 0) {
        		   JLabel label = new JLabel(""+chiffre);
        		   ptest.add(label);
            	   chiffre--;
        	   }
           }
           if(i>72) {
        	   char l = (char) lettre;
        	   JLabel label = new JLabel(""+l); 
        	   ptest.add(label);
        	   lettre++;
           }
        	  
           else if(i%2==0 && i%9!=0) ptest.setBackground(Color.gray);
           echecP.add(ptest);
        }
        r=1;
	}
    
    public void affichePiece(Graphics g){
        if(this.r == 0){
            //afficheCase();
            System.out.println("yess");
        }
        System.out.println("yess"); 
        for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
                g.drawImage(ImagePiece.pion , 25 , 25, this);
            }
        }  
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}