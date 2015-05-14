package ch.gbssg.pave.view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class MainView extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public MainView(){
		super("Pave");
		initForm();
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
     */
    private void initForm(){
    	this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);



    	//patientsListView.setBounds(0, 20,100,300);
//        patientsListView.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        this.add(new HeaderPanel(),BorderLayout.NORTH);
        
        //this.add(patientsListView,BorderLayout.WEST);
        this.add(new ListPanel(),BorderLayout.WEST);
        //add(patientsListView, BorderLayout.WEST);
        
        //this.add(new ButtonPanel());
        this.add(new ButtonPanel(),BorderLayout.SOUTH);
	    //add(scrollPane,BorderLayout.WEST);
        this.add(new FormPanel(),BorderLayout.CENTER);
    }
}
