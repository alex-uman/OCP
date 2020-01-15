package Aufgaben;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class IntegersConsumer {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		putIntegers(i -> sb.append(i).append(" "));
		System.out.println(sb); // Zeile A

		List<Integer> list = new ArrayList<>();
		putIntegers(i -> list.add(i));
		System.out.println(list); // Zeile B

		putIntegers(System.out::print); // Zeile C

	}

	static void putIntegers(Consumer<Integer> integers) {
		for (int i = 1; i < 5; i++)
			integers.accept(i);
	}
}
