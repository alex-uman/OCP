package kleinaufgaben;

public class Permutationen {

	public static void main(String[] args) {

		System.out.println(faculty(4,9));

	}

	static long faculty(int start, int end) {

		long faculty = start;

		for (int i = start + 1; i <= end; i++)
			faculty *= i;

		return faculty;
	}

}
