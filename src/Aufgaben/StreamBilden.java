package Aufgaben;

import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class StreamBilden {

	public static void main(String[] args) {

		// ###### A1.

		System.out.println();
		System.out.println("###### A1.");
		System.out.println();

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(55, 77);

		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for (List<Integer> e : list3) {
			System.out.println("size = " + e.size() + ". elements = " + e);
		}
		// B

		System.out.println();
		Consumer<List<Integer>> c1 = c_1 -> System.out.println("size = " + c_1.size() + ". elements = " + c_1);
		Stream.of(list1, list2).forEach(c1);

		// ###### A2.

		System.out.println();
		System.out.println("###### A2.");
		System.out.println();

		for (int i = 1; i < 4; i++) {
			System.out.println(nextInt());
		}

		System.out.println();

		Stream.<Integer>generate(StreamBilden::nextInt).limit(3).forEach(System.out::println);

		// ###### A3.

		System.out.println();
		System.out.println("###### A3.");
		System.out.println();

		for (int i = 3; i >= 1; i--) {
			System.out.println(i);
		}

		System.out.println();

		Stream.iterate(3, i -> i--).limit(3).forEach(System.out::println);

		// ###### A4.

		System.out.println();
		System.out.println("###### A4.");
		System.out.println();

		String[] a1 = { "a", "b" };
		String[] a2 = { "c", "d" };

		// A
		String[][] a3 = { a1, a2 };
		for (String[] arr : a3) {
			for (String s : arr) {
				System.out.println(s);
			}
		}
		// B

		System.out.println();

		Stream.concat(Arrays.stream(a1), Arrays.stream(a2)).forEach(System.out::println);

		// ###### A5.

		System.out.println();
		System.out.println("###### A5.");
		System.out.println();

		// A
		Collection<Path> coll = new ArrayList<>();
		coll.add(Paths.get("/a"));
		coll.add(Paths.get("/a/b"));
		coll.add(Paths.get("/a/b/c"));
		coll.add(Paths.get("/a/b/c/d"));
		for (Path p : coll) {
			System.out.println(p);
		}
		// B
		
		System.out.println();
		
//		Stream.of(coll.toArray()).forEach(System.out::println);
		
		Stream.iterate("/a",(i)->((i+1))).limit(4).forEach(System.out::println);
		

	}

	static Integer nextInt() {
		return new Random().nextInt();
	}

}
