package kleinaufgaben;

import java.util.function.*;

public class FunctionalLambdas {

	public static void main(String[] args) {

		Function<String,Consumer<String>> v5 = s -> x -> x.concat(s);

	}

}
