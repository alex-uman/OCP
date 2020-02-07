package Aufgaben;

import java.util.*;
import java.util.stream.*;

public class CollectorsPersonen {

	static class Person implements Comparable<Person> {

		private String name;
		private String beruf;

		public Person(String name, String beruf) {
			this.name = name;
			this.beruf = beruf;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBeruf() {
			return this.beruf;
		}

		public void setBeruf(String beruf) {
			this.beruf = beruf;
		}

		public String toString() {
			return this.name + " - " + this.getBeruf();
		}

		public int compareTo(Person person) {
			return (this.getName().concat(this.getBeruf())).compareTo(person.getName().concat(person.getBeruf()));
		}
	}

	public static void main(String[] args) {

		Person[] personen = { new Person("Tom", "Bauarbeiter(in)"), new Person("Jerry", "Lehrer(in)"),
				new Person("Peter", "Metzger(in)"), new Person("Paul", "Bauarbeiter(in)"),
				new Person("Mary", "Lehrer(in)"), };

//		

		TreeSet<Person> set = Arrays.stream(personen).collect(Collectors.toCollection(TreeSet::new));

		set.forEach(System.out::println);

		System.out.println();

//		

		Map<String, Person> map = Arrays.stream(personen).sorted().collect(Collectors.toMap(Person::getName, x -> x));

		map.forEach((x, y) -> System.out.printf("%-5s -> %s%n", x, y));

		System.out.println();

//		

		Collection<String> collection = Arrays.stream(personen)
				.collect(Collectors.mapping(Person::getBeruf, Collectors.toSet()));

		collection.forEach(System.out::println);

		System.out.println();

//		

		Map<String, List<Person>> group = Stream.of(personen).collect(Collectors.groupingBy(Person::getBeruf));

		System.out.println(group);

		System.out.println();

//		

		Map<Boolean, List<Person>> partition = Stream.of(personen)
				.collect(Collectors.partitioningBy(x -> !x.getBeruf().equals("Bauarbeiter(in)")));

		System.out.println(partition);

	}

}
