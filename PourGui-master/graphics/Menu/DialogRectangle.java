package graphics.Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import graphics.shapes.SRectangle;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.ImageAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.Editor;

public class DialogRectangle extends Dialog {

	private static final long serialVersionUID = 1L;
	
	private static final Dimension DEFAULT_DIMENSION_PANEL = new Dimension(250,60);
	private static final Dimension DEFAULT_DIMENSION_TEXT_FIELD = new Dimension(60,25);
	private static final int DEFAULT_VALUE=100;
	private static final String DEFAULT_TITLE = "Créer un nouveau rectangle";
	private static final String HEIGHT = "Height";
	private static final String WIDTH = "Width";
	private static final String HEIGHT_LABEL = "height : ";
	private static final String WIDTH_LABEL = "width : ";
	private static final String IMAGE_LABEL = "image : ";
	private static final String LIEN_LABEL = "lien : ";
	private static final String DEFAULT_LIEN = "";
	private static final String IMAGE ="Image";
	private static final String TRUE = "True";
	private static final String FALSE = "False";


	private JTextField height;
	private JTextField width;

	private JRadioButton imageTrue;

	private JRadioButton imageFalse;

	private JTextField imageLien;
	
	public DialogRectangle() {
		
		super.setTitle(DEFAULT_TITLE);
		
		JPanel panelPosition = super.panelPosition();	
		JPanel panelColor = super.panelColor();
		JPanel panelFilled = super.panelFilled();
		JPanel panelStrocked = super.panelStrocked();
		JPanel panelValidation = super.panelValidation();
		JPanel panelHeight = this.panelHeight();
		JPanel panelWidth = this.panelWidth();
		JPanel panelImage = this.panelImage();
		JPanel panelSettings = super.panelSettings(panelPosition, panelFilled, panelStrocked, panelColor);
		panelSettings.add(panelImage);
		panelSettings.add(panelHeight);
		panelSettings.add(panelWidth);
		

	    this.getContentPane().add(panelSettings, BorderLayout.CENTER);
	    this.getContentPane().add(panelValidation, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(super.getOk())) {
			SRectangle r = new SRectangle(new Point(getX(),getY()),this.getH(),this.getW());
			r.addAttributes(new ColorAttributes(super.getfTrue(),super.getsTrue(),false,super.getFilledColor(),super.getStrockedColor(),null,null,null));
			r.addAttributes(new SelectionAttributes());
			try {
				r.addAttributes(new ImageAttributes(new File(imageLien.getText()),imageTrue.isSelected(), this.getW()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Editor.model.add(r);
			Editor.sview.repaint();
			super.setVisible(false);
		}
	}
	
	public JPanel panelHeight() {
		JPanel panelHeight = new JPanel();
		panelHeight.setBorder(BorderFactory.createTitledBorder(HEIGHT));
		panelHeight.setPreferredSize(DialogRectangle.DEFAULT_DIMENSION_PANEL);
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
	
	public JPanel panelImage() {
		JPanel panelImage = new JPanel();
		panelImage.setBorder(BorderFactory.createTitledBorder(IMAGE));
		panelImage.setPreferredSize(new Dimension(350,80));
		JLabel imageLabel = new JLabel(IMAGE_LABEL);
		panelImage.add(imageLabel);
		this.imageTrue = new JRadioButton(TRUE);
		this.imageTrue.setSelected(true);
		this.imageFalse = new JRadioButton(FALSE);
		ButtonGroup imageButtons = new ButtonGroup();
		imageButtons.add(this.imageTrue);
		imageButtons.add(this.imageFalse);
		panelImage.add(this.imageTrue);
		panelImage.add(this.imageFalse);
		JLabel lienLabel=new JLabel(LIEN_LABEL);
		panelImage.add(lienLabel);
		this.imageLien = new JTextField(DEFAULT_LIEN);
		this.imageLien.setPreferredSize(new Dimension(120,25));
		panelImage.add(imageLien);
		return panelImage;
	}
	
	public int getH() {
		return Integer.parseInt(this.height.getText());
	}
	
	public int getW() {
		return Integer.parseInt(this.width.getText());
	}
}