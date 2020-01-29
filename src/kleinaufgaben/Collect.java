package kleinaufgaben;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Collect {

	static class Kreis implements Comparable<Kreis> {
		int radius;

		public Kreis(int radius) {
			this.radius = radius;
		}

		@Override
		public String toString() {
			return "Kreis R=" + radius;
		}

		@Override
		public int compareTo(Kreis k2) {
			return this.getRadius()-k2.getRadius();
		}

		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}
	}

	public static void main(String[] args) {

		a1();

		System.out.println();

		a2();

	}

	static void a1() {
		/*
		 * Bitte mit collect die Strings der Datenquelle in einem StringBuilder sammeln
		 */

		StringBuilder result = Stream.of("a", "bb", "ccc").collect(StringBuilder::new, StringBuilder::append,
				StringBuilder::append);

		System.out.println("result: " + result); // abbccc

	}

	static void a2() {
		System.out.println("*** A2");

		Integer[] radien = { 2, 4, 1, 5 };

		/*
		 * Mit einer (!) Pipeline: - Integer aus dem Array 'radien' in Kreise verwandeln
		 * - mit der Methode collect die Kreise in einem TreeSet sammeln
		 */

//		TreeSet<Kreis> k;
//		k.

		TreeSet<Kreis> result = Arrays.stream(radien).map(Kreis::new).collect(TreeSet<Kreis>::new, TreeSet::add,
				TreeSet::addAll);
		System.out.println("result: " + result);
	}

}
