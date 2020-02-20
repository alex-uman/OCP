package Aufgaben;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsExecutorWords {

	public static void main(String[] args) throws Exception {

		List<String> words = readFromFile("corncob_lowercase");

		System.out.println();
		System.out.println("Insgesamt Wörter: " + words.size());

		a4(words);
		a5(words);

	}

	static Runnable a2(List<String> words) throws Exception {

		Runnable tCounter = () -> {

			int count = 0;

			for (String i : words)
				if (i.indexOf('t') != -1)
					count++;

			System.out.println();
			System.out.println("Wörter mit 't': " + count);
		};

		return tCounter;
	}

	static Callable<Integer> a3(List<String> words) throws Exception {

		Callable<Integer> ooCounter = () -> {

			int count = 0;

			for (String i : words)
				if (i.contains("oo"))
					count++;

			System.out.println();
			System.out.println("Wörter mit 'oo': " + count);

			return count;
		};

		return ooCounter;
	}

	static void a4(List<String> words) throws Exception {

		ExecutorService srv = Executors.newCachedThreadPool();

		srv.execute(a2(words));

		Future<Integer> fut = srv.submit(a3(words));

		srv.shutdown();

	}

	static void a5(List<String> words) throws Exception {

		Runnable for5Counter = () -> {
			long count = words.stream().filter(x -> x.length() == 5).count();
			System.out.println();
			System.out.println("Wörter mit der Länge 5: " + count);
		};

		ExecutorService srv = Executors.newCachedThreadPool();

		srv.execute(new Thread(for5Counter));

		srv.shutdown();
	}

	static List<String> readFromFile(String fileName) throws Exception {

		List<String> words = new ArrayList<String>();

		fileName = normaliseTxtFilename(fileName);

		if (fileName.isEmpty()) {
			System.out.println("Wrong filename!");
			return null;
		}

		Path file = Paths.get(fileName);

		if (!Files.exists(file)) {
			System.out.println("Wrong filename!");
			return null;
		}

		FileReader reader = new FileReader(fileName);

		int i;
		String line = "";

		while ((i = reader.read()) != -1) {
			if (i != '\n')
				line += (char) i;
			else if (line != "") {
				words.add(line);
				line = "";
			}
		}

		reader.close();

		return words;
	}

	private static String normaliseTxtFilename(String string) {

		if (string == null || string.isBlank())
			return "";

		string = string.trim();

		if (!string.endsWith(".txt"))
			return string + ".txt";

		return string;
	}

}
