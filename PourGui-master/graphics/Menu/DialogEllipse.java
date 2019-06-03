package graphics.Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphics.shapes.SEllipse;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.ImageAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.Editor;

public class DialogEllipse extends Dialog{

	private static final long serialVersionUID = 1L;
	
	private static final Dimension DEFAULT_DIMENSION_PANEL = new Dimension(250,60);
	private static final Dimension DEFAULT_DIMENSION_TEXT_FIELD = new Dimension(60,25);
	private static final int DEFAULT_VALUE=100;
	private static final String DEFAULT_TITLE = "Créer un nouveau rectangle";
	private static final String HEIGHT = "Height";
	private static final String WIDTH = "Width";
	private static final String HEIGHT_LABEL = "height : ";
	private static final String WIDTH_LABEL = "width : ";
	private JTextField height;
	private JTextField width;
	
	public DialogEllipse() {
		
		super.setTitle(DEFAULT_TITLE);
		
		JPanel panelPosition = super.panelPosition();	
		JPanel panelColor = super.panelColor();
		JPanel panelFilled = super.panelFilled();
		JPanel panelStrocked = super.panelStrocked();
		JPanel panelValidation = super.panelValidation();
		JPanel panelHeight = this.panelHeight();
		JPanel panelWidth = this.panelWidth();
		JPanel panelSettings = super.panelSettings(panelPosition, panelFilled, panelStrocked, panelColor);
		panelSettings.add(panelHeight);
		panelSettings.add(panelWidth);

	    this.getContentPane().add(panelSettings, BorderLayout.CENTER);
	    this.getContentPane().add(panelValidation, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(super.getOk())) {
			SEllipse el = new SEllipse(new Point(getX(),getY()),this.getW(),this.getH());
			el.addAttributes(new ColorAttributes(super.getfTrue(),super.getsTrue(),false, super.getFilledColor(),super.getStrockedColor(), null, null, null));
			el.addAttributes(new SelectionAttributes());
			el.addAttributes(new ImageAttributes());
			Editor.model.add(el);
			Editor.sview.repaint();
			super.setVisible(false);
		}
	}
	
	public JPanel panelHeight() {
		JPanel panelHeight = new JPanel();
		panelHeight.setBorder(BorderFactory.createTitledBorder(HEIGHT));
		panelHeight.setPreferredSize(DialogEllipse.DEFAULT_DIMENSION_PANEL);
		JLabel heightLabel = new JLabel(HEIGHT_LABEL);
		panelHeight.add(heightLabel);
		this.height = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.height.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelHeight.add(this.height);
		
		return panelHeight;
	}
	
	public JPanel panelWidth() {
		JPanel panelWidth = new JPanel();
		panelWidth.setPreferredSize(DEFAULT_DIMENSION_PANEL);
		this.width = new JTextField(Integer.toString(DEFAULT_VALUE));
		this.width.setPreferredSize(DEFAULT_DIMENSION_TEXT_FIELD);
		panelWidth.setBorder(BorderFactory.createTitledBorder(WIDTH));
		JLabel widthLabel = new JLabel(WIDTH_LABEL);
		panelWidth.add(widthLabel);
		panelWidth.add(this.width);
		
		return panelWidth;
	}
	
	public int getH() {
		return Integer.parseInt(this.height.getText());
	}
	
	public int getW() {
		return Integer.parseInt(this.width.getText());
	}

}
