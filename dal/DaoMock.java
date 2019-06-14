package dal;

import java.util.ArrayList;

import blogic.Person;

public class DaoMock implements IDAO {

	
	ArrayList<Person> pp;
	
	public DaoMock() {
		pp = new ArrayList<>();
		pp.add(new Person(1, "Vasia", "Pupkin", 32));
		pp.add(new Person(2, "Rulon", "Oboev", 44));
		pp.add(new Person(3, "Record", "Nadoev", 54));
		pp.add(new Person(4, "Ushat", "Pomoev", 14));
		pp.add(new Person(5, "Ugon", "Kamazov", 26));	
	}
	@Override
	public void create(Person p) {
		pp.add(p);
		
	}

	@Override
	public void update(Person p){
		{
			{
				int id;
				for (Person o : pp) {
					id = o.ID;

					if (p.ID == o.ID) 
					{
						return;
					}
				}}
		}
	}

	@Override
	public void delete(Person p) {
		{
			int id;
			for (Person o : pp) {
				id = o.ID;
				if (p.ID == o.ID) 
				{
					pp.remove(o);
					return;
				}
			}}		
	}

	@Override
	public ArrayList<Person> read() {
		
		return pp;
	}

}
