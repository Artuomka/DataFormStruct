package blogic;

import java.lang.reflect.Field;

public class Constants
{
	private static Constants instance = null;

	private String[] personFieldsNames;
	
	private Constants()
	{
	Person p = new Person();
	Class c1 = p.getClass();
	Field[] fields = c1.getDeclaredFields();
	personFieldsNames = new String[fields.length];
	int index = 0;
	
	for (Field f: fields) {
		personFieldsNames[index++] = f.getName().toUpperCase();
	}
	
	
	}
	
	public static Constants getInstance() {
		if (instance ==null)
			instance = new Constants();
		return instance;
	}
	
	public String[] getFieldsNames() {
		return personFieldsNames;
	}
	
}
