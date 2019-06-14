package blogic;

public class Person 
{
	public int ID;
	public String FIRSTNAME;
	public String SECONDNAME;
	public int AGE;
	
	public Person() {
		
	}

	public Person (int ID, String FIRSTNAME, String SECONDNAME, int AGE)
	{
		this.ID = ID;
		this.FIRSTNAME = FIRSTNAME;
		this.SECONDNAME = SECONDNAME;
		this.AGE = AGE;
	}
	
	@Override
	public String toString() 
	{	
		String out = new String();
		out = out + Integer.toString(ID)+ ", " +	FIRSTNAME + ", " + SECONDNAME + ", " +
				Integer.toString(AGE);
		return out;
	}

}
