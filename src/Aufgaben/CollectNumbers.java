package Aufgaben;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class CollectNumbers {

	public static void main(String[] args) {

		String[] arr = { "1,2,3,4,5", "7,6,5,4,3", "123,456", };

		List<Integer> list;

		// A
		list = new ArrayList<>();
		for (String s : arr) {
			String[] stringNumbers = s.split(",");

			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				list.add(num);
			}
		}
		// B

		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]

		System.out.println();

		System.out.println(Arrays.stream(arr).map(x -> x.split(",")).flatMap(Arrays::stream).map(Integer::valueOf)
				.collect(ArrayList::new, List::add, List::addAll));

		System.out.println();

		System.out.println(Arrays.stream(arr).map(x -> x.split(",")).flatMap(Arrays::stream).map(Integer::valueOf)
				.filter(y -> y % 2 == 0).collect(ArrayList::new, List::add, List::addAll));

	}

}
