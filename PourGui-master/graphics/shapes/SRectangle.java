package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import graphics.shapes.attributes.ImageAttributes;

public class SRectangle extends Shape {
	
	private Rectangle rect;
	private int width;
	private int height;
	
	public SRectangle(Point loc,int width,int height) {
		this.width=width;
		this.height=height;
		this.rect = new Rectangle(loc.x , loc.y ,this.width ,this.height);
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	
	@Override
	public Point getLoc() {
		return this.rect.getLocation();
	}
	
	@Override
	public void setLoc(Point loc) {
		this.rect.setLocation(loc);;
	}

	@Override
	public void translate(int dx, int dy) {
		this.rect.translate(dx, dy);
	}

	@Override
	public Rectangle getBounds() {
		ImageAttributes i= (ImageAttributes) getAttributes(ImageAttributes.ID);
		if (i.isImage()) {
			this.width=i.getWidth();
			this.height=(i.getImage().getHeight(null)*i.getWidth())/i.getImage().getWidth(null);
			Rectangle bd = new Rectangle(this.getLoc().x,this.getLoc().y,width,height);
			return bd;
		}
		return rect.getBounds();
	}

	@Override
	public void accept(ShapeVisitor sv) {
		sv.visitRectangle(this);
	}
	
	@Override
	public void setSize(int dw, int dh) {
		if(((ImageAttributes) this.getAttributes(ImageAttributes.ID)).isImage()){
			((ImageAttributes) this.getAttributes(ImageAttributes.ID)).setSize(dw);
		}
		else {
			rect.setSize(rect.width+dw, rect.height+dh);
		}
	}
	
	public void grow() {
		this.setSize(5, 5);
	}
	
	public void shrink() {
		this.setSize(-5, -5);
	}

	
}
