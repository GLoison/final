package graphics.shapes.attributes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageAttributes extends Attributes {
	
	private boolean image;
	public static final String ID = "Image";
	private Image img;
	private File fl;
	
	public ImageAttributes(File fl,boolean i) throws IOException {
		this.fl=fl;
		this.img=ImageIO.read(this.fl);
		this.image=i;
	}
	
	public ImageAttributes() {
		
	}
	
	public File getFile() {
		return fl;
	}
	
	public Image getImage() {
		return img;
	}

	
	public boolean isImage() {
		return image;
	}
	


	@Override
	public String getId() {
		return ID;
	}
	
}