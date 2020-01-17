package Aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

class IntPositive {
	private static void checkAndThrow(boolean check, Supplier<Exception> s) throws Exception {

		if (!check) {
			throw s.get();
		}
	}

//	void setValue(int value) {
//		checkAndThrow(value > 0, IllegalArgumentException::new);
//	}
//
//	void writeValue(int value) {
//		checkAndThrow(value > 0, java.io.IOException::new);
//	}
}

public class GenerischeMethodenFunctional {

	public static void main(String... args) {

		System.out.println();
		System.out.println("-------Aubgabe A1-------");
		System.out.println();

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> isEven = i -> i % 2 == 0;
		System.out.println(count(list1, isEven)); // 2

		Predicate<Number> isNotNull = b -> b.intValue() % 2 != 0;
		List<Number> list2 = Arrays.asList(1, 1.2, 3, 3.4);
		System.out.println(count(list2, isNotNull)); // 4

		Predicate<String> isEmpty = String::isEmpty;
		List<String> list3 = Arrays.asList("a", "", "b", "", "c");
		System.out.println(count(list3, isEmpty)); // 2

		System.out.println();
		System.out.println("-------Aubgabe A2-------");
		System.out.println();

		System.out.println();
		System.out.println("-------Aubgabe A3-------");
		System.out.println();

	}

	static String count(List list, Predicate predicate) {
		Integer count = 0;

		for (Object i : list)
			if (predicate.test(i))
				count++;

		return count.toString();
	}

}
