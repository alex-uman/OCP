package Aufgaben;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class MTextStatistics {

	private String sentence;

	MTextStatistics() {
		super();
	}

	MTextStatistics(String sentence) {
		this.setSentence(sentence);
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	static MTextStatistics of(String sentence) {
		return new MTextStatistics(sentence);
	}

	TreeSet<Character> getUniqueChars() {

		TreeSet<Character> collection = new TreeSet<>();

		if (this.getSentence() != null && !this.getSentence().isEmpty()) {

			int length = this.getSentence().length();

			for (int i = 0; i < length; i++)
				collection.add(this.getSentence().charAt(i));
		}
		return collection;
	}

	Map<Character, Integer> getCharCounts() {

		Map<Character, Integer> letters = new TreeMap<>();

		String sentence = this.getSentence();
		int length = sentence.length();

		for (int i = 0; i < length; i++) {
			char letter = sentence.charAt(i);
			Integer count = letters.get(letter);
			letters.put(letter, count == null ? 1 : ++count);
		}

		return letters;
	}

	static void entrySet(Map<Character, Integer> map) {

		Set<Character> keys = map.keySet();

		for (char i : keys)
			System.out.println("'" + i + "' commt " + map.get(i) + " Mal vor");

	}

}

public class MapTextStatistics {

	public static void main(String[] args) {

		MTextStatistics stat = MTextStatistics.of("Heute ist Montag!");

		System.out.println(stat.getUniqueChars());

		System.out.println();

		MTextStatistics.entrySet(stat.getCharCounts());

	}

}
