package Aufgaben;

import java.util.function.BiFunction;

class Besitzer {
	private String name;

	Besitzer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}

class Auto {
	private Integer id = null;
	private Besitzer besitzer = null;

	Auto(Integer id, Besitzer besitzer) {
		this.setID(id);
		this.setBesitzer(besitzer);
	}

	public static Auto build(Integer id, Besitzer besitzer) {
		return new Auto(id, besitzer);
	}

	public Integer getID() {
		return this.id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public Besitzer getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Besitzer besitzer) {
		this.besitzer = besitzer;
	}

	@Override
	public String toString() {
		return "Auto Nummer: " + this.getID() + (this.getBesitzer() != null ? ", Besitzer: " + this.getBesitzer() : "");
	}

	static public Besitzer applyF3(Auto a3, Integer id3) {
		if (a3.getID() == id3)
			return a3.getBesitzer();
		return BiFunctionMethodReference.UNBESETZT;
	}
}

public class BiFunctionMethodReference {

	static final Besitzer UNBESETZT = new Besitzer("unbesetzt!");

	static class ABuilder {

		Auto autoBuilder(Integer id, Besitzer besitzer) {
			return new Auto(id, besitzer);
		}
	}

	public static void main(String[] args) {

		Besitzer b = new Besitzer("Max Baumann");
		Integer id = 1;
		Auto a = new Auto(id, b);

		System.out.println();
		System.out.println(a);
		System.out.println();

		System.out.println();
		System.out.println("  A1");
		System.out.println("------");
		System.out.println();

		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<>() {

			@Override
			public Besitzer apply(Auto a1, Integer id1) {
				if (a1.getID() == id1)
					return a1.getBesitzer();
				return UNBESETZT;
			}
		};

		System.out.println("Auto Nummer " + id + " - " + f1.apply(a, id));
		id = 2;
		System.out.println("Auto Nummer " + id + " - " + f1.apply(a, id));

		System.out.println();
		System.out.println("  A2");
		System.out.println("------");
		System.out.println();

		BiFunction<Auto, Integer, Besitzer> f2 = (a2, id2) -> {
			if (a2.getID() == id2)
				return a2.getBesitzer();
			return UNBESETZT;
		};

		id = 1;
		System.out.println("Auto Nummer " + id + " - " + f2.apply(a, id));
		id = 2;
		System.out.println("Auto Nummer " + id + " - " + f2.apply(a, id));

		System.out.println();
		System.out.println("  A3");
		System.out.println("------");
		System.out.println();

		BiFunction<Auto, Integer, Besitzer> f3 = Auto::applyF3;

		id = 1;
		System.out.println("Auto Nummer " + id + " - " + f3.apply(a, id));
		id = 2;
		System.out.println("Auto Nummer " + id + " - " + f3.apply(a, id));

		System.out.println();
		System.out.println("  A4");
		System.out.println("------");
		System.out.println();

		BiFunction<Integer, Besitzer, Auto> f4 = Auto::new;

		id = 1;
		System.out.println(f4.apply(id, b));
		id = 2;
		System.out.println(f4.apply(id, b));

		System.out.println();
		System.out.println("  A5");
		System.out.println("------");
		System.out.println();

		BiFunction<Integer, Besitzer, Auto> f5 = new ABuilder()::autoBuilder;

		id = 1;
		System.out.println(f5.apply(id, b));
		id = 2;
		System.out.println(f5.apply(id, b));
	}

}
