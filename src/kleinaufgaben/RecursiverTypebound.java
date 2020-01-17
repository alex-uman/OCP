package kleinaufgaben;


public class RecursiverTypebound {

	public static void main(String[] args) {

		Double x1 = getMax2(12.9, 55.1);
		System.out.println(x1);

		char x2 = getMax3('b', 'c');
		System.out.println(x2);

		String x3 = getMax3("Zaba", "Zaab");
		System.out.println(x3);

		System.out.println(getMax3("1", "2"));

	}

	static Integer getMax1(Integer x, Integer y) {
		return x < y ? y : x;
	}

	static <N extends Number> N getMax2(N x, N y) {
		return (x.doubleValue() < y.doubleValue()) ? y : x;
	}

	static <C extends Comparable<C>> C getMax3(C x, C y) {
		return x.compareTo(y) < 0 ? y : x;
	}

}
