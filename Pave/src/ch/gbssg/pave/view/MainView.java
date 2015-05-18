package ch.gbssg.pave.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView extends JFrame{
	private static final long serialVersionUID = 1L;
	private HeaderPanel pnlHeader;
	private ListPanel pnlList;
	private ButtonPanel pnlButtons;
	private DataPanel pnlData;
	
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
        
        
        
        pnlHeader = new HeaderPanel();
        this.add(pnlHeader, BorderLayout.NORTH);
        
        //this.add(patientsListView,BorderLayout.WEST);
        pnlList = new ListPanel();
        this.add(pnlList, BorderLayout.WEST);
        
        //add(patientsListView, BorderLayout.WEST);
        //this.add(new ButtonPanel());
        pnlButtons = new ButtonPanel();
        this.add(pnlButtons, BorderLayout.SOUTH);
        
	    //add(scrollPane,BorderLayout.WEST);
        pnlData = new DataPanel();
        this.add(pnlData, BorderLayout.CENTER);
    }
    
    public void setBtnNewActionListener(ActionListener a){
    	pnlButtons.setBtnNewActionListener(a);
    }
}
