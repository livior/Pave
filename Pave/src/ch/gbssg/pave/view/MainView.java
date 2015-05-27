package ch.gbssg.pave.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ch.gbssg.pave.model.PatientModel;

public class MainView extends JFrame{
	private static final long serialVersionUID = 1L;
	private HeaderPanel pnlHeader;
	private ListPanel pnlList;
	private ButtonPanel pnlButtons;
	private DataPanel pnlData;
	
	public MainView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		super("Pave");
		initForm();
	}
	
	/**
     * Die JForm wird initialisiert und alle Steuerelemente
     * positioniert
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
     */
    private void initForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
 	
    	this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(450,350));




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
    
    public void setPatient(PatientModel patient){
    	this.pnlData.setPatient(patient);
    }
	public void updateList(ArrayList<PatientModel> patients){
		this.pnlList.updateList(patients);
	}

    public void setBtnNewActionListener(ActionListener a){
    	pnlButtons.setBtnNewActionListener(a);
    }
    
    public void setListActionListener(ActionListener a){
    	pnlList.setListActionListener(a);
    }
    
    public List getList(){
    	return(pnlList.getList());
    }
}
