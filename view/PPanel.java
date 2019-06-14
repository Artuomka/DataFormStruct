package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import blogic.Constants;
import blogic.Person;
import blogic.PersonDM;
import dal.DaoMock;
import dal.IDAO;

public class PPanel extends JPanel
{

	//IDAO dao = new DaoMock();

	
	public static  JTable table;
	



	public PPanel() {
		setLayout(null);
		PersonDM dm = new PersonDM(this);
		table = new JTable(dm);
		JScrollPane sp = new JScrollPane(table);
		
		add(sp);
		sp.setBounds(20, 20, 400, 400);

//		JLabel l_id = new JLabel("ID");
//		JLabel l_fName = new JLabel("F_NAME");
//		JLabel l_SName = new JLabel("S_NAME");
//		JLabel l_Age = new JLabel("AGE");
//
//		l_id.setBounds(450, 20, 50, 50);
//		add(l_id);
//		l_fName.setBounds(570, 20, 50, 50);
//		add(l_fName);
//		l_SName.setBounds(690, 20, 50, 50);
//		add(l_SName);
//		l_Age.setBounds(810, 20, 50, 50);
//		add(l_Age);
		

		

		

		JButton btnCreate = new JButton ("CREATE");
		JButton btnRead = new JButton ("READ");
		JButton btnUpdate = new JButton ("UPDATE");
		JButton btnDelete = new JButton("DELETE");
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton MockButton = new JRadioButton("DAO Mock", true);
		group.add(MockButton);
		JRadioButton H2Button = new JRadioButton("DAO H2", false);
		group.add(H2Button);
		JRadioButton MySQLButton = new JRadioButton("DAO MySQL", false);
		group.add(MySQLButton);
		JRadioButton JSONButton = new JRadioButton("DAO JSON", false);
		group.add(JSONButton);
		JRadioButton XMLButton = new JRadioButton("DAO XML", false);
		group.add(XMLButton);
		JRadioButton YAMLButton = new JRadioButton ("DAO YAML", false);
		group.add(YAMLButton);
		JRadioButton CSVButton = new JRadioButton ("DAO CSV", false);
		group.add(CSVButton);
		
		String[] boxRows = {"DAO Mock", "DAO H2", "DAO MySQL", "DAO JSON", "DAO XML", "DAO YAML", "DAO CSV"};
		JComboBox baseList = new JComboBox(boxRows);
		baseList.setSelectedIndex(0);
		baseList.addActionListener(dm.aBox);
		baseList.setBounds(450, 260, 200, 50);
		add(baseList);
		
		
		btnCreate.setBounds(450, 150, 100, 30);
		btnRead.setBounds(570, 150, 100, 30);
		btnUpdate.setBounds(690, 150, 100, 30);
		btnDelete.setBounds(810, 150, 100, 30);
		
		MockButton.setBounds	(450, 200, 100, 50);
		H2Button.setBounds		(570, 200, 100, 50);
		MySQLButton.setBounds	(690, 200, 100, 50);
		JSONButton.setBounds	(810, 200, 100, 50);
		XMLButton.setBounds		(810, 250, 100, 50);
		YAMLButton.setBounds	(810, 300, 100, 50);
		CSVButton.setBounds		(810, 350, 100 ,50);
		
		add(btnCreate);
		add(btnRead);
		add(btnUpdate);
		add(btnDelete);
		
		
	
		
		add(MockButton);
		add(H2Button);
		add(MySQLButton);
		add(JSONButton);
		add(XMLButton);
		add(YAMLButton);
		add(CSVButton);
		
		MockButton.setActionCommand("mock");
		H2Button.setActionCommand("h2");
		MySQLButton.setActionCommand("MySQL");
		
		MockButton.addActionListener(dm.aChoose);
		H2Button.addActionListener(dm.aChoose);
		MySQLButton.addActionListener(dm.aChoose);
	
		
		
		
		btnCreate.setActionCommand ("create");
		btnRead.setActionCommand ("read");
		btnUpdate.setActionCommand ("update");
		btnDelete.setActionCommand ("delete");
	
		btnCreate.addActionListener(dm.aCreate);
		btnRead.addActionListener(dm.aRead);
		btnUpdate.addActionListener(dm.aUpdate);
		btnDelete.addActionListener(dm.aDelete);
	}
}
