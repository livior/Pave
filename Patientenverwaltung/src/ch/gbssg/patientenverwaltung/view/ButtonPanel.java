package ch.gbssg.patientenverwaltung.view;

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
	private JPanel equalSizeGridPanel;
	
	public ButtonPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		equalSizeGridPanel = new JPanel(new GridLayout(1,3,3,3));
		equalSizeGridPanel.add(new JButton("Neu..."));
		equalSizeGridPanel.add(new JButton("Löschen"));
		equalSizeGridPanel.add(new JButton("Bearbeiten..."));
		equalSizeGridPanel.add(new JButton("Bearbeiten..."));
		add(equalSizeGridPanel);
	}
}
