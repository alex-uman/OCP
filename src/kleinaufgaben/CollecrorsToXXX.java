package kleinaufgaben;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollecrorsToXXX {

	static class Wochentag implements Comparable<Wochentag> {

		private String name;
		private int nummer;

		Wochentag(String name, int nummer) {
			this.setName(name);
			this.setNummer(nummer);
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNummer() {
			return this.nummer;
		}

		public void setNummer(int nummer) {
			this.nummer = nummer;
		}

		public String toString() {
			return this.nummer + ". " + this.name;
		}

		public int compareTo(Wochentag d2) {
			return this.nummer - d2.getNummer();
		}
	}

	public static void main(String[] args) {

		Integer[] zahlen = { 1, 2, 3, 4, 5, 6, 7 };
		String[] namen = { "mo", "di", "mi", "do", "fr", "sa", "so" };

		Stream.iterate(0, i -> i + 1).limit(7).map(x -> new Wochentag(namen[x], zahlen[x]))
				.collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);

		System.out.println();

		Integer[] zahlen2 = { 1, 22, 333, 4444 };

		Arrays.stream(zahlen2).collect(Collectors.mapping(String::valueOf, Collectors.toCollection(TreeSet::new)))
				.forEach(System.out::println);

	}

}
