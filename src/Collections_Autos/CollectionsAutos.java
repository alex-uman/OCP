package Collections_Autos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

abstract class Auto implements Comparable<Auto> {
	private String model;
	private Integer baujahr;

	Auto(String model, Integer baujahr) {
		this.setModel(model);
		this.setBaujahr(baujahr);
	}

	@Override
	public int hashCode() {

		Integer hash = 0;
		char[] auto = (this.getClass().getSimpleName() + this.getModel()).toCharArray();

		for (char i : auto)
			hash += i;

		hash = Integer.parseInt(hash.toString() + this.getBaujahr().toString());

		return hash;
	}

	@Override
	public int compareTo(Auto auto) {

		int compare = this.getModel().compareTo(auto.getModel());

		if (compare == 0)
			compare = this.getBaujahr() - auto.getBaujahr();

		return compare;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ". Modell: " + this.getModel() + ", Baujahr " + this.getBaujahr();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(Integer baujahr) {
		this.baujahr = baujahr;
	}
}

class VW extends Auto {
	VW(String model, Integer baujahr) {
		super(model, baujahr);
	}
}

class BMW extends Auto {
	BMW(String model, Integer baujahr) {
		super(model, baujahr);
	}
}

public class CollectionsAutos {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("###### A1., A2.");
		System.out.println();

		VW vw = new VW("Golf", 1990);
		BMW bmw = new BMW("z4", 2000);

		System.out.println(vw);
		System.out.println(bmw);
		System.out.println();

		System.out.println();
		System.out.println("###### A3., A4., A5.");
		System.out.println();

		VW vw1 = new VW("Golf I", 1986);
		VW vw2 = new VW("Golf II", 1999);
		VW vw3 = new VW("Golf II", 1994);

		LinkedList<Auto> linkedListVW = new LinkedList<>();
		linkedListVW.add(vw1);
		linkedListVW.add(vw2);
		linkedListVW.add(vw3);
		HashSet<Auto> hashSetVW = new HashSet<>();
		hashSetVW.add(vw1);
		hashSetVW.add(vw2);
		hashSetVW.add(vw3);
		TreeSet<Auto> treeSetVW = new TreeSet<>();
		treeSetVW.add(vw1);
		treeSetVW.add(vw2);
		treeSetVW.add(vw3);
		PriorityQueue<Auto> priorityQueueVW = new PriorityQueue<>();
		priorityQueueVW.add(vw1);
		priorityQueueVW.add(vw2);
		priorityQueueVW.add(vw3);

		printList(linkedListVW);
		printList(hashSetVW);
		printList(treeSetVW);
		printList(priorityQueueVW);

		System.out.println();
		System.out.println("###### A6.");
		System.out.println();

		BMW bmw1 = new BMW("z4", 2000);
		BMW bmw2 = new BMW("z4", 1998);

		ArrayList<Auto> arrayListBMW = new ArrayList<>();
		arrayListBMW.add(bmw1);
		arrayListBMW.add(bmw2);
		HashSet<Auto> hashSetBMW = new HashSet<>();
		hashSetBMW.add(bmw1);
		hashSetBMW.add(bmw2);
		TreeSet<Auto> treeSetBMW = new TreeSet<>();
		treeSetBMW.add(bmw1);
		treeSetBMW.add(bmw2);
		PriorityQueue<Auto> arrayDequeBMW = new PriorityQueue<>();
		arrayDequeBMW.add(bmw1);
		arrayDequeBMW.add(bmw2);

		printList(arrayListBMW);
		printList(hashSetBMW);
		printList(treeSetBMW);
		printList(arrayDequeBMW);

		System.out.println();
		System.out.println("###### A7.");
		System.out.println();

		System.out.println(hashSetBMW.contains(bmw1));

		System.out.println();
		System.out.println("###### A8.");
		System.out.println();

		bmw1.setBaujahr(2001);
		System.out.println(hashSetBMW.contains(bmw1));

		System.out.println();
		System.out.println("###### A9., A10.");
		System.out.println();

		VW vwPolo = new VW("Polo", 2200);

		linkedListVW.add(vwPolo);

		System.out.println(Collections.binarySearch(linkedListVW, vwPolo));

		System.out.println();
		System.out.println("###### A11.");
		System.out.println();

		Collections.sort(linkedListVW);

		printList(linkedListVW);

		System.out.println();
		System.out.println("###### A12.");
		System.out.println();

		Collections.sort(linkedListVW, Collections.reverseOrder());

		printList(linkedListVW);

		System.out.println();
		System.out.println("###### A13.");
		System.out.println();

		System.out.println(Collections.binarySearch(linkedListVW, vwPolo));

		linkedListVW.sort(null);

		System.out.println(Collections.binarySearch(linkedListVW, vwPolo));

		System.out.println();
		System.out.println("###### A14.");
		System.out.println();

		System.out.println(Collections.binarySearch(linkedListVW, new VW("Polo", 3300)));

	}

	static void printList(Collection<Auto> list) {

		for (Auto i : list)
			System.out.println(i);
		System.out.println();
	}
}
