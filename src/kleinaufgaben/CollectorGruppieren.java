package kleinaufgaben;

import java.util.*;
import java.util.stream.*;

public class CollectorGruppieren {

	public static void main(String[] args) {

		Integer[] array = { 12, -22, 0, 77, 0, -5, -5, 33, 6 };

		Map<String, List<Integer>> map1 = Stream.of(array)
				.collect(Collectors.groupingBy(x -> x < 0 ? "<0" : x == 0 ? "0" : ">0"));

		Map<String, TreeSet<Integer>> map2 = Stream.of(array).collect(
				Collectors.groupingBy(x -> x < 0 ? "<0" : x == 0 ? "0" : ">0", Collectors.toCollection(TreeSet::new)));

		Map<String, TreeSet<Integer>> map3 = Stream.of(array).collect(Collectors.groupingBy(
				x -> x < 0 ? "<0" : x == 0 ? "0" : ">0", TreeMap::new, Collectors.toCollection(TreeSet::new)));

	}
}
