package Aufgaben;

import java.util.Arrays;

public class ForkJoinArray {

	public static void main(String[] args) {

		int[] array = generateIntArray(100, -50, 50);

		Arrays.stream(array).forEach(x -> System.out.print(x + ", "));

	}

	static int[] generateIntArray(int length, int min, int max) {

		length = Math.abs(length);

		int[] array = new int[length > 0 ? length : 0];

		for (int i = 0; i < length; i++)

			array[i] = (int) (Math.random() * (max - min + 1)) + min;

		return array;

	}
}
