package kleinaufgaben;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class OS implements Comparable<OS> {
	private int version;
	private String name;

	OS(String name, int version) {
		setName(name);
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return name + " " + version;
	}

	@Override
	public int compareTo(OS o) {
		int i = this.getName().compareTo(o.getName());

		if (i == 0)
			i = this.getVersion() - o.getVersion();

		return i;
	}

}

public class Aufgabe1 {

	public static void main(String[] args) {

		OS os1 = new OS("Mac", 9);
		System.out.println(os1);

		OS[] array = { new OS("Linux", 3), new OS("Windows", 95), os1, new OS("Linux", 1) };

		Arrays.sort(array);

		Random random = new Random();

		Comparator<OS> cmp;
//		cmp = (osX, osY) -> random.nextInt(3) - 1;
		cmp = (osX, osY) -> osY.getVersion() - osX.getVersion();

		Arrays.sort(array, cmp);

		print(array);

	}

	private static void print(OS[] array) {
		System.out.println("*** OS-Array: ");
		int i = 1;
		for (OS os : array)
			System.out.printf("| %d%-1s | %-8s  | %2d |%n", i++, ".", os.getName(), os.getVersion());
	}

}
