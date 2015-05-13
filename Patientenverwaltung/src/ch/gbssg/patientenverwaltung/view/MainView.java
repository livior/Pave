package ch.gbssg.patientenverwaltung.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class MainView extends JFrame{
	JList patientsListView;
	
	public MainView(){
		super("Pave");
		initForm();
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
     */
    private void initForm(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBounds(200, 200, 500, 500);
        
        String listData[]={"Hans Meier", "Peter Meier"};
        patientsListView = new JList(listData);
        patientsListView.setSize(500, 50);
        this.add(patientsListView,BorderLayout.WEST);
        this.add(new ButtonPanel(),BorderLayout.SOUTH);
    }
}
