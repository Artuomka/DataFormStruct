package view;

import javax.swing.JFrame;

import blogic.PersonDM;



public class PFrame extends JFrame
{
	public PFrame() {
	setTitle("Data Base");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	setBounds(200, 75, 1000, 600);
	
	PPanel pan = new PPanel();


	add(pan);

	setVisible(true);
	}
}
