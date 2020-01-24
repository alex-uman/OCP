package Aufgaben;

import java.util.Comparator;
import java.util.stream.Stream;

class Rechteck implements Comparable<Rechteck> {

	private int breite, hoehe;

	Rechteck(int breite, int hoehe) {
		this.setBreite(breite);
		this.setHoehe(hoehe);
	}

	public int getBreite() {
		return this.breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHoehe() {
		return this.hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getSquare() {
		return this.getBreite() * this.getHoehe();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + this.getBreite() + " x " + this.getHoehe();
	}

	@Override
	public int compareTo(Rechteck rechteck) {
		return this.getSquare() - rechteck.getSquare();
	}

}

public class StreamsRechtek {

	public static void main(String[] args) {

		Rechteck[] rechtecke = { new Rechteck(3, 5), new Rechteck(2, 3), new Rechteck(10, 15), new Rechteck(4, 6),
				new Rechteck(2, 8) };

		Stream.of(rechtecke).sorted().forEach(System.out::println);

		System.out.println();

		Comparator<Rechteck> c = (r1, r2) -> r2.getSquare()-r1.getSquare();
		Stream.of(rechtecke).sorted(c).forEach(System.out::println);

		System.out.println();

		Stream.of(rechtecke).map(n -> n.getClass().getSimpleName() + " " + n.getSquare()).forEach(System.out::println);

		System.out.println();

		Integer[] figuren = { 1, 2, 3 };
		Stream.of(figuren).map(n -> new Rechteck(n, 2)).forEach(System.out::println);

	}

}
