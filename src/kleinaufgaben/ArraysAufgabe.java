package kleinaufgaben;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;

class ArrayUtils {

	static int[] createRandomIntArray(int len, int min, int max) {

		int[] array = new int[len];

		for (int i = 0; i < len; i++)

			array[i] = (int) (Math.random() * (max - min + 1)) + 1;

		return array;

	}

	static void saveToFile(int[] array, String fileName) {

		try (PrintWriter writer = new PrintWriter(fileName)) {

//			Path file = Paths.get(fileName);
//			if (Files.exists(file))
//				Files.delete(file);
//			Files.createFile(file);

			for (int i : array)
				writer.println(i);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int[] loadFromFile(String fileName) {

//		try (FileReader reader = new FileReader(fileName); BufferedReader buffer = new BufferedReader(reader)) {
//
//			ArrayList<Integer> list = new ArrayList<Integer>();
//
//			String line;
//			while ((line = buffer.readLine()) != null)
//				list.add(Integer.parseInt(line));
//
//			int[] array = new int[list.size()];
//
//			for (int i = 0; i < array.length; i++)
//				array[i] = list.get(i);
//
//			return array;

		try {

			return Files.lines(Paths.get(fileName)).mapToInt(Integer::parseInt).toArray();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}

public class ArraysAufgabe {

	public static void main(String[] args) {

		int len = 10;
		int min = 1, max = 15;
		String file = "array.txt";

		int[] arr1 = ArrayUtils.createRandomIntArray(len, min, max);

		System.out.println(Arrays.toString(arr1));

		ArrayUtils.saveToFile(arr1, file);

		int[] arr2 = ArrayUtils.loadFromFile(file);

		System.out.println(Arrays.toString(arr2));

	}

}
