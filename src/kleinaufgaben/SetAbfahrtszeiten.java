package kleinaufgaben;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SetAbfahrtszeiten {

	public static void main(String[] args) {

		List<String> abfahrtszeiten = getAbfartszeiten(6.12, 23.00, 20);

		System.out.println(abfahrtszeiten);

		TreeSet tree = new TreeSet(abfahrtszeiten);

		System.out.println(tree.higher("12:03"));
		System.out.println(tree.lower("12:03"));
		System.out.println(tree.ceiling("17:12"));
		System.out.println(tree.higher("17:12"));
		System.out.println(tree.subSet("12:01", "13:00"));
		System.out.println(tree.subSet("11:52", false, "13:12", true));
		System.out.println(tree.first());
		System.out.println(tree.last());
		

	}

	static List<String> getAbfartszeiten(int von, int bis) {

		List<String> list = new ArrayList<>();

		for (int i = von; i < bis; i++)
			list.add(String.format("%02d", i));

		return list;
	}

	static List<String> getAbfartszeiten(double von, double bis, int interval) {

		List<String> list = new ArrayList<>();

		while (von >= 24)
			von -= 24;
		while (bis >= 24)
			bis -= 24;

		int intVon = (int) von;
		int intBis = (int) bis;

		LocalTime vonT = LocalTime.of(intVon, (int) ((von - intVon) * 100));
		LocalTime bisT = LocalTime.of(intBis, (int) ((bis - intBis) * 100));

		while (vonT.compareTo(bisT) < 0) {
			list.add(vonT.toString());
//			System.out.println(vonT);
			vonT = vonT.plusMinutes(interval);
		}

		return list;

	}
}