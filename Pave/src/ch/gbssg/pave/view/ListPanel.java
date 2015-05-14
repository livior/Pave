package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListPanel extends JPanel{
	private JPanel listPanel;
	JList patientsListView;
	JScrollPane scrollPane;
	
	public ListPanel(){
        String listData[]={"Hans Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier"};

//		setLayout(new GridBagLayout());
        setLayout(new BorderLayout());
        patientsListView = new JList(listData);
    	scrollPane = new JScrollPane(patientsListView);
        //patientsListView.setSize(500, 500);
	//	setSize(500,500);
/*		GridBagConstraints gbc;

		gbc = makegbc(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;*/
		add(scrollPane);
	}
	private GridBagConstraints makegbc(int x, int y, int width, int height){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}
}
