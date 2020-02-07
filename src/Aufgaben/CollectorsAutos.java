package Aufgaben;

import java.util.*;
import java.util.stream.*;

public class CollectorsAutos {

	static class Auto {
		private String hersteller, modell;

		public Auto(String hersteller, String modell) {
			this.hersteller = hersteller;
			this.modell = modell;
		}

		public String getHersteller() {
			return hersteller;
		}

		public String getModell() {
			return modell;
		}

		public String toString() {
			return hersteller + "/" + modell;
		}
	}

	public static void main(String[] args) {

		List<Auto> autos = Arrays.asList(new Auto("VW", "Golf"), new Auto("VW", "Polo"), new Auto("Opel", "Corsa"),
				new Auto("Opel", "Astra"));

//		

		Collector<String, ?, Set<String>> downstream = Collectors.toSet();

		Collector<Auto, ?, Set<String>> collector = Collectors.mapping(Auto::getHersteller, downstream);

		Set<String> set = autos.stream().collect(collector);
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]

		System.out.println();

//		

		Map<String, List<Auto>> map2 = autos.stream().collect(Collectors.groupingBy(Auto::getHersteller));
		System.out.println(map2); // mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}

		System.out.println();

//		

		Map<String, List<String>> map3 = autos.stream().collect(
				Collectors.groupingBy(Auto::getHersteller, Collectors.mapping(Auto::getModell, Collectors.toList())));
		System.out.println(map3);
		// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}

		System.out.println();

	}

}
