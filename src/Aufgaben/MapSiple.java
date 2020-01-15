package Aufgaben;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSiple {

	public static void main(String[] args) {

		Map<String, LocalDate> map = new HashMap<>();
		map.put("heute", LocalDate.now());
		map.put("gestern", LocalDate.now().minusDays(1));
		map.put("morgen", LocalDate.now().plusDays(1));

		
		entrySet(map);
	}

	static void entrySet(Map<String, LocalDate> map) {

		Set<String>keys=map.keySet();
		
		for(String i:keys)
			System.out.println(i+": "+map.get(i));
		
	}

}
