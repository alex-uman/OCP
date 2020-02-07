package kleinaufgaben;

import java.util.*;

public class Merge {

	public static void main(String[] args) {

		String text = "Heute ist Freitag";

		Map<Character, Integer> countMap = new HashMap<>();

		char[] chars = text.toCharArray();

		for (Character i : chars)
			countMap.merge(i, 1, (x, y) -> x + 1);

		System.out.println(countMap);

		System.out.println();

//		

//		Map<Character, Integer> map2 = Stream.of(text.chars()).mapToObj( x -> (char)x )
		
	}

}
