package kleinaufgaben;

import java.util.function.*;
import java.util.stream.Stream;

public class Pipeline2Arrays {

	public static void main(String[] args) {

		String[] a1 = { "mo", "di" };
		String[] a2 = { "mi", "do", "fr" };
		Consumer c = null;

		Stream.of(a1.length, a2).forEach(System.out::println);

	}

}
