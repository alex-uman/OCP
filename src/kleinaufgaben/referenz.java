package kleinaufgaben;

import java.util.function.*;

public class referenz {

	static class Values {

		Values() {
		}

		Values(Values v) {
		}

		static String get(Values v, Integer i) {
			return "!";
		}
	}

	public static void main(String[] args) {

		BiFunction<String, String, String> f0 = new BiFunction<String, String, String>() {
			public String apply(String s1, String s2) {
				return s1.concat(s2);
			}
		};

		BiFunction<String, String, String> f1 = (s1, s2) -> s1.concat(s2);
		BiFunction<String, String, String> f2 = String::concat;

		Supplier<Values> s1 = Values::new;
		Consumer<Values> c1 = Values::new;

		Consumer<Values> c2 = new Consumer<Values>() {
			public void accept(Values values) {
				new Values(values);
			}
		};

//		BiFunction<Values, Integer, String> bf1 = String::get;

	}

}
