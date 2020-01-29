package Aufgaben;

import java.util.*;
import java.util.stream.Stream;

class Person {

	private String vorname, nachname;

	Person() {
		this.setVorname("");
		this.setNachname("");
	}

	Person(String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String toString() {
		return this.getVorname() + " " + this.getNachname();
	}

	public static Person combineMax(Person p1, Person p2) {
		return new Person(getMax(p1.getVorname(), p2.getVorname()), getMax(p1.getNachname(), p2.getNachname()));
	}

	public static String getMax(String s1, String s2) {

		if (s1.compareTo(s2) > 0)
			return s1;

		return s2;
	}

}

public class ReducePersonen {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Tom", "Katze"), new Person("Jerry", "Maus"),
				new Person("Alexander", "Poe"));

		System.out.println("A1: " + persons.stream().reduce(Person::combineMax).get());

		System.out.println();

		System.out.println("A2: " + persons.stream().reduce(new Person(), (x, y) -> Person.combineMax(x, y)));

		System.out.println();

		System.out.println("A3: " + persons.stream().reduce(new Person(), Person::combineMax, Person::combineMax));

	}
}
