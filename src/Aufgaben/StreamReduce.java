package Aufgaben;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Stream;

public class StreamReduce {

	public static void main(String[] args) {

		String[] items = { "aa", "bbb", "cccc", "ddddd" };

		System.out.println(Stream.of(items).map(x1 -> x1.length()).reduce(0, (y1, z1) -> y1 + z1));

		System.out.println();

//		BiFunction<Integer, String, Integer> f = (x1,x2) -> x1 + x2.length();
//		BinaryOperator<Integer> bo = (y1, z1) -> y1 + z1;

		System.out.println(Arrays.stream(items).reduce(0, (x1, x2) -> x1 + x2.length(), (y1, z1) -> y1 + z1));
	}

}
