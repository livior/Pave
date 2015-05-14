package ch.gbssg.pave.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Creates several buttons in a Flow Layout
 * @author Livio Rinaldi
 *
 */
public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel equalSizeGridPanel;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnPrint;
	
	public ButtonPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		btnNew		= new JButton("Neu...");
		btnDelete	= new JButton("Löschen");
		btnEdit		= new JButton("Bearbeiten...");
		btnPrint	= new JButton("Drucken...");
		
		equalSizeGridPanel = new JPanel(new GridLayout(1,3,3,3));
		equalSizeGridPanel.add(btnNew);
		equalSizeGridPanel.add(btnDelete);
		equalSizeGridPanel.add(btnEdit);
		equalSizeGridPanel.add(btnPrint);
		add(equalSizeGridPanel);
	}
}
