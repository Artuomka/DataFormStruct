package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import blogic.PersonDM;

public class PDialog extends JDialog
{
	//PPanel pan;
	public static 	JTextField TextID = null;
	public static	JTextField TextFName = null;
	public static	JTextField TextSName = null;
	public static	JTextField TextAge = null;
	public static boolean result = false;

	public PDialog() 
	{
		
	setTitle ("Person");
	setLayout(null);
	
	TextID = new JTextField();
	TextFName = new JTextField();
	TextSName = new JTextField();
	TextAge= new JTextField();
	
	
	TextID.setBounds(50, 50, 150, 40);
	TextFName.setBounds(50, 120, 150, 40);
	TextSName.setBounds(50, 190, 150, 40);
	TextAge.setBounds(50, 260, 150, 40);
	
	JLabel l_id = new JLabel("ID");
	JLabel l_fName = new JLabel("First_Name");
	JLabel l_SName = new JLabel("Second_Name");
	JLabel l_Age = new JLabel("Age");
	
	l_id.setBounds(70, 10, 150, 50);
	add(l_id);
	l_fName.setBounds(70, 80, 150, 50);
	add(l_fName);
	l_SName.setBounds(70, 150, 150, 50);
	add(l_SName);
	l_Age.setBounds(70, 220, 150, 50);
	add(l_Age);
	
	add(TextID);
	add(TextFName);
	add(TextSName);
	add(TextAge);		
		


		JButton ok = new JButton ("Ok");
		ok.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						
						result = true;
						setVisible(false);						
					}
			
				});
		
		
		JButton Cancel = new JButton ("Cancel");
		Cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {				
			result = false;	
			setVisible(false);
			}			
		});
		
		ok.setBounds(250, 50, 100, 50);
		Cancel.setBounds(250, 120, 100, 50);
		
		add(ok);
		add(Cancel);
		
	}

	public void setValues (int id, String fName, String sName, int age) 
	{
		TextID.setText(""+id);
		TextFName.setText(fName);
		TextSName.setText(sName);
		TextAge.setText(""+age);
	}
	
	public void resetState() {
		result = false;
		setVisible(false);
	}
	
	public boolean getState() {
		return result;
	}
	
	
}
