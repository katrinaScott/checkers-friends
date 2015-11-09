package src.UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class TablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	
	public TablePanel() {
		
		setBackground(Color.DARK_GRAY);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
	} // end constructor

} // end class TablePanel
