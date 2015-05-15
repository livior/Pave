package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListPanel extends JPanel{
	private JPanel listPanel;
	//JList patientsListView;
	List patientsListView;

	JScrollPane scrollPane;
	
	public ListPanel(){
        GridBagLayout gbl = new GridBagLayout(); 
		String listData[]={"Hans Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier"};

		setLayout(gbl);
//        setLayout(new BorderLayout());
        //patientsListView = new JList(listData);
		patientsListView = new List();
		for(int i=0;i<100;i++)
        	patientsListView.add("Hans Meier");
    	scrollPane = new JScrollPane(patientsListView);
        //patientsListView.setSize(500, 500);
		setSize(500,500);
		GridBagConstraints gbc;

		gbc = makegbc(0, 0, 10, 3);
		gbc.weightx = 500;
		gbc.weighty = 500;
		gbc.fill = GridBagConstraints.BOTH	;
		//gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(scrollPane, gbc);
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
