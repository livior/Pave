package ch.gbssg.pave.view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Creates several buttons in a Flow Layout
 * @author Livio Rinaldi
 *
 */
public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel equalSizeGridPanel;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnGenerateBill;
	private JButton btnEdit;
	private JButton btnPrint;

	public ButtonPanel(){
		JPanel flowLeft;
		JPanel flowRight;
		ImageIcon image = new ImageIcon(".\\img\\add_patient.png");
		ImageIcon image2 = new ImageIcon(".\\img\\delete_patient.png");
		
		setLayout(new GridLayout(1,2));
		flowLeft  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		flowRight = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
		
		btnNew		= new JButton();
		btnDelete	= new JButton();
		btnGenerateBill = new JButton("Rechnung generieren...");
		btnEdit		= new JButton("Bearbeiten...");
		btnPrint	= new JButton("Drucken...");

		btnNew.setIcon(image);
		btnNew.setBorderPainted(false);
		btnNew.setFocusPainted(false);
		btnNew.setContentAreaFilled(false);		// to remote the spacing between the image and button's borders
		
		btnDelete.setIcon(image2);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setContentAreaFilled(false);		// to remote the spacing between the image and button's borders

		flowLeft.add(btnNew);
		flowLeft.add(btnDelete);

		flowRight.add(btnGenerateBill);
		flowRight.add(btnEdit);		
		flowRight.add(btnPrint);		
		add(flowLeft);
		add(flowRight);
	}
	
	public void setBtnNewActionListener(ActionListener a){
		this.btnNew.addActionListener(a);
	}
	public void setBtnDeleteActionListener(ActionListener a){
		this.btnDelete.addActionListener(a);
	}
	public void setBtnGenerateBillActionListener(ActionListener a){
		this.btnGenerateBill.addActionListener(a);
	}
	public void setBtnPrintActionListener(ActionListener a){
		this.btnPrint.addActionListener(a);
	}
	public void setBtnEditActionListener(ActionListener a){
		this.btnEdit.addActionListener(a);
	}
}
