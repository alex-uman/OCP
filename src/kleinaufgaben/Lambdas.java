package kleinaufgaben;

import java.util.function.Function;;

public class Lambdas {

	public static void main(String[] args) {

		Function<Integer, String> f1 = param -> "Value = "  + param;
		System.out.println(f1.apply(11));
	}

}
