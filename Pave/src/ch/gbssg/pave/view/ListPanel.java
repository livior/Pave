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
	List patientsListView;

	JScrollPane scrollPane;
	
	public ListPanel(){
 		String listData[]={"Hans Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier", "Peter Meier"};

        setLayout(new BorderLayout());
        patientsListView = new List();
        
        for(int i=0;i<100;i++)
        	patientsListView.add("Hans Meier");
    	scrollPane = new JScrollPane(patientsListView);
    	setSize(500,500);
    	patientsListView.select(0);
		add(scrollPane);
	}
}
