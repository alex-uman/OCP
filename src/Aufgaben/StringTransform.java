package Aufgaben;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class StringTransform {

	ArrayList<UnaryOperator<String>> list = new ArrayList();

	public StringTransform addTransformation(UnaryOperator<String> string) {

		list.add(string);

		return this;

	}

	public String process(String string) {
		for (UnaryOperator<String> i : list)
			string = i.apply(string);
		return string;
	}

	public static void main(String[] args) {

		// Transformationen vordefinieren:
		StringTransform t1 = new StringTransform().addTransformation(s -> s.toUpperCase())
				.addTransformation(s -> s + "!");

		// Transformationen durchführen:
		String s = t1.process("Hallo");
		System.out.println(s); // HALLO!

		s = t1.process("Java ist toll");
		System.out.println(s); // JAVA IST TOLL!

	}

}
