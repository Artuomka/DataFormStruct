package dal;

import java.util.ArrayList;

import blogic.Person;

public interface IDAO 
{
   void create (Person p);
   void update (Person p);
   void delete (Person p);
   ArrayList<Person> read ();   
}
