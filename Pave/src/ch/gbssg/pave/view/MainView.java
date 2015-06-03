package ch.gbssg.pave.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
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
     * initialize the JFrame and position all GUI elements
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
     */
    private void initForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		// get design from operating system
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750, 500);
        this.setMinimumSize(new Dimension(750,350));
        
        
        pnlHeader = new HeaderPanel();
        this.add(pnlHeader, BorderLayout.NORTH);
        
        pnlList = new ListPanel();
        this.add(pnlList, BorderLayout.WEST);
        
        pnlButtons = new ButtonPanel();
        this.add(pnlButtons, BorderLayout.SOUTH);
        
        pnlData = new DataPanel();
        this.add(pnlData, BorderLayout.CENTER);
        
		// calculate the middle of the screen and set the frame there
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }
    
    public void showError(String errorMessage){
    	String titleBar = "Fehler";
    	JOptionPane.showMessageDialog(null, errorMessage, titleBar, JOptionPane.ERROR_MESSAGE);
    }

    public void clearDataPanel(){
    	this.pnlData.clearDataPanel();
    }
    public void setPatient(PatientModel patient){
    	this.pnlData.setPatient(patient);
    }
	public void updateList(ArrayList<PatientModel> patients){
		this.pnlList.updateList(patients);
	}

	public void setBtnSearchActionListener(ActionListener a){
		pnlHeader.setBtnSearchActionListener(a);
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
    public void setBtnExportActionListener(ActionListener a){
    	pnlButtons.setBtnExportActionListener(a);
    }
    
    public void setListActionListener(ActionListener s){
    	pnlList.setListActionListener(s);
    }
    
    public void setBtnsActive(boolean active){
    	pnlButtons.setBtnsActive(active);
    }
    
    public List getList(){
    	return(pnlList.getList());
    }
    
    public String getSearchText(){
    	return(pnlHeader.getSearchText());
    }
}
