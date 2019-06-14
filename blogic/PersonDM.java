package blogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import dal.DaoH2;
import dal.DaoMock;
import dal.IDAO;
import view.PDialog;
import view.PPanel;


public class PersonDM extends AbstractTableModel
{
	private ArrayList <Person> pp;
	IDAO dao = new DaoMock();
//	IDAO dao; //= new DaoH2();
	private PPanel pan;
	
	
	public ActionRead aRead = new ActionRead();
	public ActionCreate aCreate = new ActionCreate();
	public ActionUpdate aUpdate = new ActionUpdate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionChoose aChoose = new ActionChoose();
	public ActionBox aBox = new ActionBox();
	
	public PersonDM(PPanel pan) {
		//pp = new ArrayList<>();
		pp = (new DaoMock()).read();
		//pp = (new DaoH2()).read();
	}
	
	public PPanel setPanel (PPanel pan){
		this.pan = pan;
		return pan;
		}
	
	
	
	@Override
	public String getColumnName(int index) {
		String[] columnNames = Constants.getInstance().getFieldsNames();
		return columnNames[index];
	}
	
	@Override
	public int getColumnCount() {
		
		return Constants.getInstance().getFieldsNames().length ;
	}

	@Override
	public int getRowCount() 
	{
		int count = pp.size();
		return count;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Object value = null;
		
		Person p = pp.get(row);
		Class c1 = p.getClass();
		Field[] ff = c1.getDeclaredFields();
		ff[column].setAccessible(true);
		
		 try {
			value = ff[column].get(p);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return value;

	}

	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = dao.read();
			fireTableDataChanged();			
		}
		
	}
	
	public class ActionCreate implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PDialog dlg = new PDialog();
			dlg.setBounds(370, 140, 640, 480);
			dlg.setModal(true);
			dlg.setVisible(true);
			if (PDialog.result == true)
			{
			dao.create(readPerson());
			pp = dao.read();
			fireTableDataChanged();
			}
			
		}
		
	}
	
	public class ActionUpdate implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int index = PPanel.table.getSelectedRow();
			if (index >=0) {
			PDialog dlg = new PDialog();
	
			Person p = pp.get(index);
			dlg.setValues(p.ID, p.FIRSTNAME, p.SECONDNAME, p.AGE);
			dlg.setBounds(370, 140, 640, 480);
			dlg.setModal(true);
			dlg.setVisible(true);
			if (PDialog.result == true) 
			{
			dao.update(readPerson());
			pp = dao.read();
			fireTableDataChanged();
			}
			}
			else JOptionPane.showMessageDialog(null, "Please select a row to update!");
		}
		
	}
	
	public class ActionDelete implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			PDialog dlg = new PDialog();
			dlg.setBounds(370, 140, 640, 480);
			dlg.setModal(true);
			dlg.setVisible(true);
			if (PDialog.result == true)
			{
			dao.delete(readPerson());
			pp = dao.read();
			fireTableDataChanged();
			}
		}
		
	}
	
	public Person readPerson() {
		int id = Integer.parseInt(PDialog.TextID.getText());
		String FName = PDialog.TextFName.getText();		
		String SName = PDialog.TextSName.getText();		
		int Age = Integer.parseInt(PDialog.TextAge.getText());
		Person p = new Person(id, FName, SName, Age);
		return(p); 
	}
	
	public class ActionChoose implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd)
			{
			case "mock": 
			dao = new DaoMock(); 
			pp = (new DaoMock()).read(); 
			fireTableDataChanged(); 
			break;
			
			case "h2": 
			dao = new DaoH2();	
			pp = (new DaoH2()).read(); fireTableDataChanged(); 
			break;
			
			case "MySQL": 
			dao = new DaoH2();	
			pp = (new DaoH2()).read(); fireTableDataChanged(); 
			break;
			}
			
		}
		
	}
	
	public class ActionBox implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox cb = (JComboBox) e.getSource();
			String choosed = (String) cb.getSelectedItem();
			switch (choosed)
			{
			case "DAO Mock": 
			dao = new DaoMock(); 
			pp = (new DaoMock()).read(); 
			fireTableDataChanged(); 
			break;
			
			case "DAO H2": 
			dao = new DaoH2();	
			pp = (new DaoH2()).read(); fireTableDataChanged(); 
			break;
			
			case "DAO MySQL": 
			dao = new DaoH2();	
			pp = (new DaoH2()).read(); fireTableDataChanged(); 
			break;
			}
			
		}
	}
}
