
package graphics.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class SDiamond extends Shape {
	private Polygon diam = new Polygon();

	private Point p;
	private int height;
	private int width;

//	public SDiamond(Point one, Point two) {
//		this.one = one;
//		this.two = two;
//		int X[] = { one.x, two.x, one.x + 2 * (two.x - one.x), two.x };
//		int Y[] = { one.y, two.y, one.y, two.y + 2 * (one.y - two.y) };
//		this.diam = new Polygon(X, Y, 4);
//	}
	
	public SDiamond(Point p,int width,int height) {
		this.width=width;
		this.height=height;
		this.p=p;
		int X[] = { p.x,p.x+width/2,p.x+width,p.x+width/2 };
		int Y[] = { p.y+height/2,p.y,p.y+height/2,p.y+height };
		this.diam = new Polygon(X, Y, 4);
		
	}

	public Point getLoc() {
		return this.p;
	}

	public void setLoc(Point p) {
		this.p=p;
	}

	public void translate(int x, int y) {
		this.diam.translate(x, y);
		this.p.setLocation(this.p.x + x, this.p.y + y);
	}

	public Rectangle getBounds() {
		return this.diam.getBounds();
	}

	public void accept(ShapeVisitor visitor) {
		visitor.visitDiamond(this);
	}

	public Polygon getPolygon() {
		return this.diam;
	}

	public void grow() {
		height+=5;
		width+=5;
		int X[] = { p.x,p.x+width/2,p.x+width,p.x+width/2 };
		int Y[] = { p.y+height/2,p.y,p.y+height/2,p.y+height };
		this.diam = new Polygon(X, Y, 4);
	}

	public void shrink() {
		height-=5;
		width-=5;
		int X[] = { p.x,p.x+width/2,p.x+width,p.x+width/2 };
		int Y[] = { p.y+height/2,p.y,p.y+height/2,p.y+height };
		this.diam = new Polygon(X, Y, 4);
	}

	@Override
	public void setSize(int dw, int dh) {
		height+=dh;
		width+=dw;
		int X[] = { p.x,p.x+width/2,p.x+width,p.x+width/2 };
		int Y[] = { p.y+height/2,p.y,p.y+height/2,p.y+height };
		this.diam = new Polygon(X, Y, 4);
	}

	public int getWidth() {
		return (int) this.getBounds().getWidth();
	}

	public int getHeight() {
		return (int) this.getBounds().getHeight();
	}
}
