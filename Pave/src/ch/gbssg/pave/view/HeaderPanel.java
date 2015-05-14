package ch.gbssg.pave.view;

import java.awt.FlowLayout;

import javax.swing.*;

public class HeaderPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
	
	public HeaderPanel(){
		ImageIcon image = new ImageIcon(".\\img\\search.png");
		JLabel label = new JLabel(image);
		label.setSize(100, 100);
		add(label);
	
		searchField=new JTextField("Suche...", 10);
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		add(searchField);
	}

}
