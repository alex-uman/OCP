package Aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Tier2 {
	private String name;

	public Tier2(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tier " + name;
	}

	@Override
	public int hashCode() {
//		return this.getName().hashCode();
		return 0;
	}

	@Override
	public boolean equals(Object t2) {
		return this.getName().equals(((Tier2) t2).getName());
	}
}

public class StreamIntermediateOperations {

	public static void main(String[] args) {

		// ###### A1.

		System.out.println();
		System.out.println("###### A1.");
		System.out.println();

		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);

		// A
		for (Integer x : list) {
			if (x == 15 || x == 19) {
				System.out.println("Treffer: " + x);
			}
		}
		// B

		System.out.println();

		list.stream().filter(p -> p == 15 || p == 19).map(c -> "Treffer: " + c).forEach(System.out::println);

		// ###### A2.

		System.out.println();
		System.out.println("###### A2.");
		System.out.println();

		Integer[] array = { 1, 4, 7, 3, -8 };

		// A
		for (Integer x : array) {
			System.out.println(x % 2 == 0 ? "gerade" : "ungerade");
		}
		// B

		System.out.println();

		Stream.of(array).map(x2 -> x2 % 2 == 0 ? "gerade" : "ungerade").forEach(System.out::println);

		// ###### A3.

		System.out.println();
		System.out.println("###### A3.");
		System.out.println();

		List<String> list2 = Arrays.asList("Tom", "Jerry", "Rex");

		// A
		for (String name : list2) {
			Tier2 t = new Tier2(name);
			System.out.println(t);
		}
		// B

		System.out.println();

//		Stream.of(list2.toArray(String[]::new)).map(x3 -> new Tier2(x3)).forEach(System.out::println);
		list2.stream().map(x3 -> new Tier2(x3)).forEach(System.out::println);

		// ###### A4.

		System.out.println();
		System.out.println("###### A4.");
		System.out.println();

		Stream.generate(() -> new Random().nextInt(41) - 20).limit(30).filter(x4 -> x4 > -1).map(x41 -> (double) x41)
				.forEach(System.out::println);

		// ###### A5.

		System.out.println();
		System.out.println("###### A5.");
		System.out.println();

		Tier2[] array5 = { new Tier2("Rex"), new Tier2("Tom"), new Tier2("Jerry"), new Tier2("Tom"),
				new Tier2("Jerry"), };

		Stream.of(array5).distinct().forEach(System.out::println);

		// ###### A6.

		System.out.println();
		System.out.println("###### A6.");
		System.out.println();

		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");

		List<String> newList = new ArrayList<String>();
		newList.addAll(mailsErsthelfer);
		newList.addAll(mailsIT);
		newList.addAll(mailsQM);

		Stream.of(newList.toArray(String[]::new)).distinct()
				.forEach(x6 -> System.out.println(x6.substring(0, x6.indexOf('@'))));

	}

}
