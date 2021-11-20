package echecVue;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import echecVue.grille.Piece;

import javax.swing.*;

import echecController.echequierController;


public class plateau extends JFrame implements Observer{
 
    private int x,y,r;
    private echecPanel echecP;
	private static final long serialVersionUID = 1L;
    //on creé le controller pour récuperer la grille.
    private echequierController controler;

	public plateau(int x, int y, echequierController controler) {
        super("plateau");
        // initialization code...
        this.x=x;
        this.y=y;
        this.controler=controler;// on récupére le controller passé en paramètre dans jeu.java pour la grille
        afficheinterface();
    }

	public void afficheinterface(){
        this.setTitle("Chess game");
        this.setMinimumSize(new Dimension(600,600));
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
        afficheCase();
        this.setContentPane(echecP);
        setVisible(true);
        //On peut rendre la frame visible
    }

	public void afficheCase() {//Affichage des cases 
		int chiffre = 7;
		int lettre = 65;
        Color gris = new Color(0, 0, 0, 50);//Case noir
        Color blanc = new Color(255, 255, 255, 0);//Case blanches
		this.setSize(x, y);
        echecP.setLayout(new GridLayout(8,9));
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
           
           else if(i%2==1 && i%9!=0) ptest.setBackground(gris);
           else ptest.setBackground(blanc);
           echecP.add(ptest);
        }
	}
    
    public void affichePiece(Graphics g){
        Dimension dim = echecP.getSize();
        System.out.println(dim.height + "   "+ dim.width); 
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                //g.drawImage(ImagePiece.pion , ((dim.width/9)*j)+(((dim.width/9)-70)/2), ((dim.height/8)*i)+(((dim.height/8)-70)/2), this); 
                // (dim.width/9)*j) = avoir le x du début de la case
                // (((dim.width/9)-70)/2) = ((taille de la case)- taille de l'image de la piece)/2 = centre l'image dans la case
                // Puis idem pour Y ...
                //Centrage de l'image dans la case.

                try{ //on vérifie si la case de la grille est pas vide.
					if(controler.getModel().grille[i][j] !=null ) {
                        //si elle est pas vide on recupére la piece présente
						Piece pieceCase=controler.getModel().grille[i][j].getPiece();
						String nomPiece=pieceCase.toString();
						switch (nomPiece){// en fonction de la pièce on met l'image correspondante.

						case "T":
                            //la on récupére la couleur de la piéce si elle est blanche on met l'image blanche et sinon noir. TB TN etc.. sont dans imagePiece.
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.TB : ImagePiece.TN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "C":
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.CB : ImagePiece.CN), ((dim.width/9)*j)+(((dim.width/9)-70)/2), ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "F":
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.FB : ImagePiece.FN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "D":
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.DB : ImagePiece.DN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "R":
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.RB : ImagePiece.RN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "":
							g.drawImage(((pieceCase.getCouleur()==Color.white) ? ImagePiece.PB : ImagePiece.PN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;
						default:

						}
					}
				}catch(Exception e){
				}
            }
        }   
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}