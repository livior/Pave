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
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(700,350));
        
        
        pnlHeader = new HeaderPanel();
        this.add(pnlHeader, BorderLayout.NORTH);
        
        pnlList = new ListPanel();
        this.add(pnlList, BorderLayout.WEST);
        
        pnlButtons = new ButtonPanel();
        this.add(pnlButtons, BorderLayout.SOUTH);
        
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
    public void setBtnDeleteActionListener(ActionListener a){
    	pnlButtons.setBtnDeleteActionListener(a);
    }
    public void setBtnGenerateBillActionListener(ActionListener a){
    	pnlButtons.setBtnGenerateBillActionListener(a);
    }
    public void setBtnEditActionListener(ActionListener a){
    	pnlButtons.setBtnEditActionListener(a);
    }
    
    public void setListActionListener(ActionListener a){
    	pnlList.setListActionListener(a);
    }
    
    public List getList(){
    	return(pnlList.getList());
    }
}
