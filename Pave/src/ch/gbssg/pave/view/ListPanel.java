package ch.gbssg.pave.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ch.gbssg.pave.model.PatientModel;

public class ListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel listPanel;
	List patientsListView;
	ArrayList<Map> mapArrayList;

	JScrollPane scrollPane;
	
	public ListPanel(){
        setLayout(new BorderLayout());
        patientsListView = new List();
    	scrollPane = new JScrollPane(patientsListView);
    	setSize(500,500);
    	patientsListView.select(0);
		add(scrollPane);
	}
	public ListPanel(ArrayList<PatientModel> patients){
        setLayout(new BorderLayout());
        patientsListView = new List();
        
    	scrollPane = new JScrollPane(patientsListView);
    	setSize(500,500);
    	updateList(patients);
    	patientsListView.select(0);
		add(scrollPane);
	}
	public void setListActionListener(ActionListener a){
		this.patientsListView.addActionListener(a);
	}
	
	public List getList(){
		return(patientsListView);
	}

	public void updateList(ArrayList<PatientModel> patients){
        int index;
		for(index=0;index<patients.size();index++){
			patientsListView.add(patients.get(index).getFirstName() + " " + patients.get(index).getSurname());
		}
	}
}
