package echecVue;
import java.awt.Image;
import javax.swing.ImageIcon;

public final class ImagePiece {
    //j'ai mis les chemin de chaque image
    public static Image TB=new ImageIcon ("./img/blanc/tour.png").getImage();
	public static Image TN=new ImageIcon ("./img/noir/tour.png").getImage();
	
	public static Image CB=new ImageIcon ("./img/blanc/cavalier.png").getImage();
	public static Image CN=new ImageIcon ("./img/noir/cavalier.png").getImage();
	
	public static Image FN=new ImageIcon ("./img/noir/fou.png").getImage();
	public static Image FB=new ImageIcon ("./img/blanc/fou.png").getImage();
	
	public static Image DB=new ImageIcon ("./img/blanc/reine.png").getImage();
	public static Image DN=new ImageIcon ("./img/noir/reine.png").getImage();
	
	public static Image RB=new ImageIcon ("./img/blanc/roi.png").getImage();
	public static Image RN=new ImageIcon ("./img/noir/roi.png").getImage();
	
	public static Image PB=new ImageIcon ("./img/blanc/pion.png").getImage();
	public static Image PN=new ImageIcon ("./img/noir/pion.png").getImage();
}
