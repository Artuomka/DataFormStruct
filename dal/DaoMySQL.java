package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class DaoMySQL implements IDAO
{
	 static ArrayList<Person> pp = new ArrayList<>();
	 
	@Override
	public void create(Person p) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement	st = null;
		try {
			st =con.createStatement();
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
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement	st = null;
		try {
			st =con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement	st = null;
		try {
			st =con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		// TODO Auto-generated method stub
		return null;
	}

}
