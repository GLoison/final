package graphics.Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import graphics.shapes.STriangle;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.ImageAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.Editor;

public class DialogTriangle extends Dialog{

	private static final long serialVersionUID = 1L;
	
	private static final Dimension DEFAULT_DIMENSION_PANEL = new Dimension(250,60);
	private static final Dimension DEFAULT_DIMENSION_TEXT_FIELD = new Dimension(60,25);
	private static final int DEFAULT_VALUE=100;
	private static final String DEFAULT_TITLE = "Créer un nouveau triangle";
	private static final String POINT = "Points";

	private static final String X_LABEL = "x : ";
	private static final String Y_LABEL = "y : ";
	private JTextField x1,y1,x2,y2;
	
	public DialogTriangle() {
		
		super.setTitle(DEFAULT_TITLE);
		
		JPanel panelPosition = super.panelPosition();	
		JPanel panelColor = super.panelColor();
		JPanel panelFilled = super.panelFilled();
		JPanel panelStrocked = super.panelStrocked();
		JPanel panelValidation = super.panelValidation();
		JPanel panelPoint1 = this.panelPoint1();
		JPanel panelPoint2 = this.panelPoint2();
		JPanel panelSettings = super.panelSettings(panelPosition, panelFilled, panelStrocked, panelColor);
		panelSettings.add(panelPoint1);
		panelSettings.add(panelPoint2);
	    this.getContentPane().add(panelSettings, BorderLayout.CENTER);
	    this.getContentPane().add(panelValidation, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(super.getOk())) {
			STriangle t = new STriangle(new Point(getX(),getY()),new Point(getX1(),getY1()),new Point(getX2(),getY2()));
			t.addAttributes(new ColorAttributes(super.getfTrue(),super.getsTrue(),false,super.getFilledColor(),super.getStrockedColor(),null,null,null));
			t.addAttributes(new SelectionAttributes());
			t.addAttributes(new ImageAttributes());
			Editor.model.add(t);
			Editor.sview.repaint();
			super.setVisible(false);
		}
	}
	
	public JPanel panelPoint1() {
		JPanel panelPoint1 = new JPanel();
		panelPoint1.setBorder(BorderFactory.createTitledBorder(POINT));
		panelPoint1.setPreferredSize(DialogTriangle.DEFAULT_DIMENSION_PANEL);
		JLabel xLabel = new JLabel(X_LABEL);
		panelPoint1.add(xLabel);
		this.x1 = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.x1.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelPoint1.add(x1);
		JLabel yLabel = new JLabel(Y_LABEL);
		panelPoint1.add(yLabel);
		this.y1 = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.y1.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelPoint1.add(y1);
		return panelPoint1;
	}
	
	public JPanel panelPoint2() {
		JPanel panelPoint2 = new JPanel();
		panelPoint2.setBorder(BorderFactory.createTitledBorder(POINT));
		panelPoint2.setPreferredSize(DialogTriangle.DEFAULT_DIMENSION_PANEL);
		JLabel xLabel = new JLabel(X_LABEL);
		panelPoint2.add(xLabel);
		this.x2 = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.x2.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelPoint2.add(x2);
		JLabel yLabel = new JLabel(Y_LABEL);
		panelPoint2.add(yLabel);
		this.y2 = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.y2.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelPoint2.add(y2);
		return panelPoint2;
	}
	
	public int getX1() {
		return Integer.parseInt(this.x1.getText());
	}
	
	public int getY1() {
		return Integer.parseInt(this.y1.getText());
	}
	
	public int getX2() {
		return Integer.parseInt(this.x2.getText());
	}
	
	public int getY2() {
		return Integer.parseInt(this.y2.getText());
	}
	
	

}
