package Aufgaben;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkAddFirst {

	static int count = 0;

	static long arrayTime = 0;
	static long linkedTime = 0;

	final static int ARRAY_SIZE = 1000;
	final static int TEST_QUANTITY = 100;

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<>();
		LinkedList<String> linkedList = new LinkedList<>();

		System.out.println();

		arrayTime = test(arrayList);

		System.out.println();

		linkedTime = test(linkedList);

		System.out.println();
		System.out
				.println("LinkedList ist hier rund " + (int) (arrayTime / linkedTime) + "-mal schneller als ArrayList");

		System.out.println();

		arrayList.clear();
		linkedList.clear();

		ArrayList<String> items = new ArrayList();

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		for (int i = 0; i < TEST_QUANTITY; i++) {

			items.clear();

			generateStringList(items, ARRAY_SIZE);

			arrayTime -= System.currentTimeMillis();
			testAddFirst(arrayList, items);
			arrayTime += System.currentTimeMillis();

			linkedTime -= System.currentTimeMillis();
			testAddFirst(linkedList, items);
			linkedTime += System.currentTimeMillis();

		}

		System.out.println("---ArrayList Time----");
		double arrayMiddleTime = (double) arrayTime / TEST_QUANTITY;
		System.out.println("Gesamtzeit für das " + TEST_QUANTITY + "-mal Hinzufügen von " + ARRAY_SIZE + " Elementen :"
				+ arrayTime);
		System.out.println("Mittelwert: " + arrayMiddleTime);

		System.out.println();

		System.out.println("---LinkedList Time---");
		double linkedMiddleTime = (double) linkedTime / TEST_QUANTITY;
		System.out.println("Gesamtzeit für das " + TEST_QUANTITY + "-mal Hinzufügen von " + ARRAY_SIZE + " Elementen :"
				+ linkedTime);
		System.out.println("Mittelwert: " + linkedMiddleTime);

	}

	static long test(List list) {

		long time = 0;

		count = 0;

		ArrayList<String> items = new ArrayList();

		for (int i = 0; i < TEST_QUANTITY; i++) {

			items.clear();
			generateStringList(items, ARRAY_SIZE);

			time -= System.currentTimeMillis();
			testAddFirst(list, items);
			time += System.currentTimeMillis();
		}

		System.out.println("---" + list.getClass().getSimpleName() + " Time---");
		double arrayMiddleTime = (double) time / TEST_QUANTITY;
		System.out.println(
				"Gesamtzeit für das " + TEST_QUANTITY + "-mal Hinzufügen von " + ARRAY_SIZE + " Elementen :" + time);
		System.out.println("Mittelwert: " + arrayMiddleTime);

		return time;

	}

	static void testAddFirst(List list, List<String> items) {
		for (String i : items)
			list.add(0, i);
	}

	static void generateStringList(List<String> list, int size) {
		for (int i = 0; i < size; i++)
			list.add("a" + count++);

//		System.out.println(list);
	}

}
