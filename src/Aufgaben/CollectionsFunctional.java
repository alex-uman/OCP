package Aufgaben;

import java.util.*;
import java.util.stream.*;

public class CollectionsFunctional {

	public static void main(String[] args) {

		List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		Iterable<Integer> iter = new ArrayList<>(array);
		iter.forEach(System.out::println);
		System.out.println(iter);

		System.out.println();

//		

		Collection<Integer> coll = new ArrayList<>(array);

		coll.removeIf(x -> x % 2 != 0);
		System.out.println(coll);

		System.out.println();

//		

		List<Integer> list3 = new ArrayList<>(array);

		list3.replaceAll(x -> x % 2 != 0 ? 0 : x);
		System.out.println(list3);

		System.out.println();

//				

		List<Integer> list4 = new ArrayList<>(array);

		list4.sort((x, y) -> y.compareTo(x));
		System.out.println(list4);

		list4.sort(CollectionsFunctional::reverce);
		System.out.println(list4);

		Comparator<Integer> cr = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return y.compareTo(x);
			}
		};

		list4.sort(cr);
		System.out.println(list4);

		list4.sort(cr::compare);
		System.out.println(list4);

		System.out.println();

//				
		Integer sum = 0;

//		list4.forEach((x) -> (x == null) ? (sum = sum) : (sum = sum + x));

		IntStream.of(1, 2, 3).asDoubleStream();

		DoubleStream.of(1, 2, 3).mapToInt(x -> (int) Math.round(x));

	}

	static int reverce(Integer x, Integer y) {
		return y.compareTo(x);
	}

}
