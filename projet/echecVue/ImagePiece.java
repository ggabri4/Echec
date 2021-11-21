package echecVue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class ImagePiece {
    //j'ai mis les chemin de chaque image
	public static BufferedImage TB;
	public static BufferedImage TN;
	
    public static void ImageLoader(){
		try{
		TB=ImageIO.read(new File("./img/blanc/tour.png"));
		TN=ImageIO.read(new File("./img/noir/tour.png"));
	}catch(Exception e){}
	}


	
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

	public static Image Indicateur = new ImageIcon ("./img/Indicateur.png").getImage();
}
