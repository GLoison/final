package graphics.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import graphics.shapes.Shape;
import graphics.shapes.ui.Editor;
import graphics.shapes.ui.ShapesController;


public class MenuBar implements ActionListener{
	
	private JMenuBar menuBar;
	private JMenuItem rectangle;
	private JMenuItem circle;
	private JMenuItem text;
	private JMenuItem triangle;
	private JMenuItem diamond;
	private JMenuItem ellipse;
	private JMenuItem arrow;
	private JMenuItem delete;
	private JMenu fichier;
	private JMenu creer;
	
	public MenuBar(){
		
		this.menuBar = new JMenuBar();
		
		this.fichier = new JMenu("Fichier");
		this.creer = new JMenu("Créer nouveau ...");
		this.delete = new JMenuItem("Delete");
		this.delete.addActionListener(this);

		this.rectangle = new JMenuItem("Rectangle");
		this.circle = new JMenuItem("Circle");
		this.text = new JMenuItem("Text");
		this.triangle = new JMenuItem("Triangle");
		this.diamond = new JMenuItem("Diamond");
		this.ellipse = new JMenuItem("Ellipse");
		this.arrow = new JMenuItem("Arrow");
		this.rectangle.addActionListener(this);
		this.circle.addActionListener(this);
		this.text.addActionListener(this);
		this.triangle.addActionListener(this);
		this.diamond.addActionListener(this);
		this.ellipse.addActionListener(this);
		this.arrow.addActionListener(this);

	    fichier.add(creer);
	    fichier.add(delete);

	    creer.add(rectangle);
	    creer.add(circle);
	    creer.add(text);
	    creer.add(triangle);
	    creer.add(diamond);
	    creer.add(ellipse);
	    creer.add(arrow);
	    
	    menuBar.add(fichier);
	    

	}

	@Override
	 public void actionPerformed(ActionEvent evt) {
		 Object source = evt.getSource();
		 
		 if (source.equals(rectangle)) {
			 DialogRectangle dr = new DialogRectangle();
			 dr.setVisible(true);
		 }
		 else if (source.equals(circle)) {
			 DialogCircle dc = new DialogCircle();
			 dc.setVisible(true);
		 }
		 else if (source.equals(text)) {
			 DialogText dt= new DialogText();
			 dt.setVisible(true);
		 }
		 else if (source.equals(triangle)) {
			 DialogTriangle dT= new DialogTriangle();
			 dT.setVisible(true);
		 }
		 else if (source.equals(diamond)) {
			 DialogDiamond dd= new DialogDiamond();
			 dd.setVisible(true);
		 }
		 else if (source.equals(ellipse)) {
			 DialogEllipse de= new DialogEllipse();
			 de.setVisible(true);
		 }
		 else if (source.equals(arrow)) {
		 DialogArrow da= new DialogArrow();
			 da.setVisible(true);
		 }
		 else if (source.equals(delete)) {
				for (Iterator<Shape> it= ShapesController.selected.iterator();it.hasNext();) {
					Shape shape = it.next();
					Editor.model.remove(shape);
					
				}
		 }
		 Editor.sview.repaint();
	}
	
	public JMenuBar getMenu() {
		return this.menuBar;
	}
}
