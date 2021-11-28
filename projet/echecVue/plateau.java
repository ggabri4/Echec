package echecVue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import echecController.echequierController;
import echecListener.echequierListener;



public class plateau extends JFrame implements Observer{
 
    private int x,y;
    private echecPanel echecP;
	private static final long serialVersionUID = 1L;
    //on creé le controller pour récuperer la grille.
    private echequierController controler;
    private echequierListener echecListener;    

	public plateau(int x, int y, echequierController controler) {
        super("plateau");
        // initialization code...
        this.x=x;
        this.y=y;
        this.controler=controler;// on récupére le controller passé en paramètre dans jeu.java pour la grille
        afficheinterface();
    }

	public void afficheinterface(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
               try {
                   controler.getModel().resetIndicateur();
                   XMLTools.encodeToFile(controler.getModel(), "grille.xml");
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
               dispose();
               System.exit(0);
        }});
        this.setTitle("Chess game");
        Image icon = Toolkit.getDefaultToolkit().getImage("./img/chess.png"); 
        this.setIconImage(icon);    // Change l'icone de l'application.
        this.setMinimumSize(new Dimension(700,700));    //Taille minimum
        this.setPreferredSize(new Dimension(800,800));  //Taille préférée
        this.setLocationRelativeTo(null);   //Position de la fenetre à l'ouverture.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Stop le prog lorsqu'on ferme la fenetre
        this.echecP = new echecPanel(this);
        this.echecListener = new echequierListener(x, y, controler);  //Création du listener
        this.echecP.addMouseListener(echecListener);    //Ajout du listener
        
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
        		   JLabel label = new JLabel("         "+chiffre);
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
        this.echecListener.setsize((int)dim.getWidth(), (int)dim.getHeight());
        
        int nbPN = 0;
        int nbCN = 0;
        int nbFN = 0;
        int nbTN = 0;

        int nbPB = 0;
        int nbCB = 0;
        int nbFB = 0;
        int nbTB = 0;
        
        for (String piece : controler.getModel().getPiece()) {
            int val=1;
            if(piece.contains("N")) val=0;
            switch(piece.substring(0, 1)){
                case "R":
					g.drawImage(((piece.contains("RB")) ? ImagePiece.RBM : ImagePiece.RNM), 2 , ((val==0)?0:dim.height/2)+10, this);//Un seul roi possible, calculs plus simples
					break;
                case "D":
					g.drawImage(((piece.contains("DB")) ? ImagePiece.DBM : ImagePiece.DNM), 2 , ((val==0)?0:dim.height/2)+40, this);//Une seule dame possible...
					break;
                case "T":
                    if(piece.contains("TN")) nbTN++; else nbTB++;
					g.drawImage(((piece.contains("TB")) ? ImagePiece.TBM : ImagePiece.TNM),(((val==0)?nbTN:nbTB)*10)-8 , ((val==0)?0+(nbTN*10):dim.height/2+(nbTB*10))+60, this);
					break;
				case "C":
                    if(piece.contains("CN")) nbCN++; else nbCB++;
					g.drawImage(((piece.contains("CB")) ? ImagePiece.CBM : ImagePiece.CNM),(((val==0)?nbCN:nbCB)*10)-8 , ((val==0)?0+(nbCN*10):dim.height/2+(nbCB*10))+90, this);
					break;
				case "F":
                    if(piece.contains("FN")) nbFN++; else nbFB++;
					g.drawImage(((piece.contains("FB")) ? ImagePiece.FBM : ImagePiece.FNM),(((val==0)?nbFN:nbFB)*10)-8 , ((val==0)?0+(nbFN*10):dim.height/2+(nbFB*10))+120, this);
					break;
				case "P":
                    if(piece.contains("PN")) nbPN++; else nbPB++;
					g.drawImage(((piece.contains("PB")) ? ImagePiece.PBM : ImagePiece.PNM), 2 , ((val==0)?0+(nbPN*18):dim.height/2+(nbPB*18))+150, this);
					break;
				default:
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                // (((dim.width/9)-70)/2) = ((taille de la case)- taille de l'image de la piece)/2 = centre l'image dans la case
                // Puis idem pour Y ...
                //Centrage de l'image dans la case.

                try{ //on vérifie si la case de la grille est pas vide.
					if(controler.getModel().getCase(i,j) !=null ) {
                        //si elle est pas vide on recupére la piece présente
						String nomPiece= controler.getModel().getCase(i,j);
					    
						switch (nomPiece.substring(0,1)){// en fonction de la pièce on met l'image correspondante.
        
						case "T":
                            //la on récupére la couleur de la piéce si elle est blanche on met l'image blanche et sinon noir. TB TN etc.. sont dans imagePiece.
                            //ImagePiece.TB.setRGB(0, 0, 70, 70, null, 0, 70);;
							g.drawImage(((nomPiece.contains("TB")) ? ImagePiece.TB : ImagePiece.TN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "C":
							g.drawImage(((nomPiece.contains("CB")) ? ImagePiece.CB : ImagePiece.CN), ((dim.width/9)*j)+(((dim.width/9)-70)/2), ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "F":
							g.drawImage(((nomPiece.contains("FB")) ? ImagePiece.FB : ImagePiece.FN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "D":
							g.drawImage(((nomPiece.contains("DB")) ? ImagePiece.DB : ImagePiece.DN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "R":
							g.drawImage(((nomPiece.contains("RB")) ? ImagePiece.RB : ImagePiece.RN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
							break;

						case "P":
                            g.drawImage(((nomPiece.contains("PB")) ? ImagePiece.PB : ImagePiece.PN), ((dim.width/9)*j)+(((dim.width/9)-70)/2) , ((dim.height/8)*i)+(((dim.height/8)-70)/2) , this);
                            if((nomPiece.contains("PB") && i==0) || (nomPiece.contains("PN") && i==6)){// fonction qui permet de savoir quand promote 
                                Promote(i,j);// lance le jdialog
                            }
							break;
                        case "I":
                            g.drawImage(ImagePiece.Indicateur, ((dim.width/9)*j)+(((dim.width/9)-30)/2) , ((dim.height/8)*i)+(((dim.height/8)-30)/2) , this);
                            break;
						default:
                        }
					}
				}catch(Exception e){
				}
            }
        }   
    }
    public Dimension getsize(){
        Dimension dime = echecP.getSize();
        return dime;
    }
    //Vraiment pas sur de lemplacement de cette fonction
    public void Promote(int x, int y) throws InterruptedException{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JDialog dialog;
        echecListener.setPromocase(x,y);
        dialog = new JDialog(this, "Promotion");
        dialog.setSize(300, 250);
        
        dialog.setLocation((int)(screenSize.getWidth()/2-150), (int)(screenSize.getHeight()/2-125));
        //On le place bien parce que plus possible de le déplacer après.
        System.out.println(controler.getModel().getCase(x,y));
        Icon cav = new ImageIcon((controler.getModel().getCase(x,y)=="PN") ? ImagePiece.CN : ImagePiece.CB);
        Icon tour = new ImageIcon((controler.getModel().getCase(x,y)=="PN") ? ImagePiece.TN : ImagePiece.TB);
        Icon fou = new ImageIcon((controler.getModel().getCase(x,y)=="PN") ? ImagePiece.FN : ImagePiece.FB);
        Icon dame = new ImageIcon((controler.getModel().getCase(x,y)=="PN") ? ImagePiece.DN : ImagePiece.DB);
        JPanel p = new JPanel();
        JButton c = new JButton(cav);   
        JButton t = new JButton(tour);  
        JButton f = new JButton(fou);   
        JButton d = new JButton(dame);  
        c.setBackground(Color.white);   c.setName("c");
        t.setBackground(Color.white);   t.setName("t");
        f.setBackground(Color.white);   f.setName("f");
        d.setBackground(Color.white);   d.setName("d");
        
        JLabel j= new JLabel("Quelle pièce voulez vous choisir ?");
        
        c.addActionListener(echecListener);
        t.addActionListener(echecListener);
        f.addActionListener(echecListener);
        d.addActionListener(echecListener);
        p.add(j);
        p.add(c);
        p.add(t);
        p.add(f);
        p.add(d);
        
        dialog.add(p);
        dialog.setUndecorated(true);
        dialog.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        // set visibility of dialog
        dialog.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}