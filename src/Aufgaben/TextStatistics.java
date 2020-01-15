package Aufgaben;

import java.util.Collection;
import java.util.HashSet;

public class TextStatistics {

	private String string = "";

	TextStatistics() {
		super();
	}

	TextStatistics(String string) {
		this.setString(string);
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	Collection<Character> getUniqueChars() {

		Collection<Character> collection = new HashSet<>();

		if (this.getString() != null && !this.getString().isEmpty()) {

			int length = this.getString().length();

			for (int i = 0; i < length; i++)
				collection.add(this.getString().charAt(i));
		}
		return collection;
	}

	public static void main(String[] args) {

		TextStatistics stat = new TextStatistics();

		System.out.println(stat.getUniqueChars());

		stat = of("Heute ist Montag!");

		System.out.println(stat.getUniqueChars());

	}

	static TextStatistics of(String string) {
		return new TextStatistics(string);
	}

}
