package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class DaoH2 implements IDAO
{
	 static ArrayList<Person> pp = new ArrayList<>();
	
	@Override
	public void create(Person p) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                                                                                                                                                                                                               
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.execute("INSERT INTO PERSON (ID, FIRSTNAME, SECONDNAME, AGE) VALUES(" +p.ID + ", '"+ p.FIRSTNAME +"', '"+ p.SECONDNAME +"', " + p.AGE +");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Person p) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                                                                                                                                                                                                               
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			st.execute("UPDATE person  SET fname = '" + p.FIRSTNAME +"', lname= '" +p.SECONDNAME +"', age="+p.AGE +" WHERE id = " + p.ID + "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Person p) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                                                                                                                                                                                                               
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			st.execute("DELETE FROM PERSON WHERE ID= "+ p.ID +";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public ArrayList<Person> read() {
		
		try {
			return (readFromH2());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Person> readFromH2() throws SQLException, ClassNotFoundException
	{
		ArrayList<Person> pp = new ArrayList<>();
		Class.forName("org.h2.Driver");                                                                                                                                                                                                                                               
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
		while (rs.next())
		{
			pp.add(new Person(rs.getInt("ID"), rs.getString(2), rs.getString("SECONDNAME"), rs.getInt(4)));
		}
		print (pp);
		return pp;
	}

	public static void print(ArrayList<Person> pp)
	{
		for (Person p: pp)
		{
			System.out.println(p);
		}
	}

}
