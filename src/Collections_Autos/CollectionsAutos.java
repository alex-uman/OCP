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
	public boolean equals(Object auto) {

		if (auto == null || this.getClass() != auto.getClass())
			return false;

		Auto auto2 = (Auto) auto;

		return this.getModel().equals(auto2.getModel()) && this.getBaujahr() == auto2.getBaujahr();

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

		HashSet<VW> hashSetVW = new HashSet(linkedListVW);
		TreeSet<VW> treeSetVW = new TreeSet(linkedListVW);
		PriorityQueue<VW> priorityQueueVW = new PriorityQueue(linkedListVW);

		printList(linkedListVW);
		printList(hashSetVW);
		printList(treeSetVW);
		printList(priorityQueueVW);

		System.out.println();
		System.out.println("###### A6.");
		System.out.println();

		BMW bmw1 = new BMW("z4", 2000);
		BMW bmw2 = new BMW("z4", 1998);

		ArrayList<BMW> arrayListBMW = new ArrayList<>();
		arrayListBMW.add(bmw1);
		arrayListBMW.add(bmw2);

		LinkedList<Auto> proxyList = new LinkedList<>();
		for (Auto i : arrayListBMW)
			proxyList.add(i);

		HashSet<BMW> hashSetBMW = new HashSet(proxyList);
		hashSetBMW.add(new BMW("z4", 2000));

		TreeSet<BMW> treeSetBMW = new TreeSet(proxyList);
		treeSetBMW.add(new BMW("z4", 2000));

		PriorityQueue<Auto> arrayDequeBMW = new PriorityQueue(proxyList);
		arrayDequeBMW.add(new BMW("z4", 2000));

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

	static void printList(Collection<? extends Auto> list) {

		int index = 1;

		System.out.println();
		System.out.println(list.getClass().getSimpleName());
		System.out.println("----------------");
		System.out.println();

		for (Auto i : list) {
			System.out.printf("%2d %s%n", index++, i);
		}
		System.out.println();
	}
}
