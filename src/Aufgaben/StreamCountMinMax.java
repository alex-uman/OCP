package Aufgaben;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamCountMinMax {

	public static void main(String[] args) {

		// ###### A1.

		System.out.println();
		System.out.println("###### A1.");
		System.out.println();

		Locale[] locales = Locale.getAvailableLocales();

		System.out.println(Stream.of(locales).map(x1 -> x1.getDisplayCountry()).max(Comparator.naturalOrder()));

		// ###### A2.

		System.out.println();
		System.out.println("###### A2.");
		System.out.println();

		System.out.println(Stream.of(locales).filter(f2 -> f2.getLanguage() == "de").count());

		// ###### A3.

		System.out.println();
		System.out.println("###### A3.");
		System.out.println();

		// A
		List<Locale> filtered = new ArrayList<>();
		for (Locale locale : locales) {
			if (locale.getDisplayCountry().contains("t")) {
				filtered.add(locale);
			}
		}

		Comparator<Locale> cmp = (loc1, loc2) -> loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());

		filtered.sort(cmp);

		if (filtered.size() > 0) {
			Locale min = filtered.get(0);
			System.out.println(min.getDisplayCountry());
			System.out.println(min.getDisplayLanguage());
		}
		// B

		System.out.println();

		Optional<Locale> lc = Stream.of(locales).filter(f3 -> f3.getDisplayCountry().contains("t"))
				.min((x3, y3) -> x3.getDisplayLanguage().compareTo(y3.getDisplayLanguage()));
		System.out.println(lc.get().getDisplayCountry());
		System.out.println(lc.get().getDisplayLanguage());

	}
}
