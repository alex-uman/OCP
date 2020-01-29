package kleinaufgaben;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

public class ReduceMitTypumwandlung {

	public static void main(String[] args) {

		Rechteck[] rechtecke = { new Rechteck(3, 5), new Rechteck(2, 3), new Rechteck(10, 15), new Rechteck(4, 6),
				new Rechteck(2, 8) };


		Integer sqv=0;
		
//		Stream.of(rechtecke).map(r1 -> r1.getSquare()).forEach(x1->{sqv+=x1;});

		System.out.println(Arrays.stream(rechtecke).map(r3 -> r3.getSquare()).reduce(1,(sq1,sq2)->sq1+sq2));

	}

}
