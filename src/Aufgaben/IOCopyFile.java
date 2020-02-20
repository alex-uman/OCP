package Aufgaben;

import java.io.*;
import java.nio.file.*;

public class IOCopyFile {

	public static void main(String[] args) {

		copyTextFile("     source    ", "copy                 ", true);

	}

	private static String normaliseTxtFilename(String string) {

		if (string == null || string.isBlank())
			return "";

		string = string.trim();

		if (!string.endsWith(".txt"))
			return string + ".txt";

		return string;
	}

	static void copyTextFile(String source, String target) {
		copyTextFile(source, target, false);
	}

	static void copyTextFile(String source, String target, boolean append) {

		source = normaliseTxtFilename(source);
		target = normaliseTxtFilename(target);

		if (source.isEmpty() || target.isEmpty()) {

			System.out.println("Wrong filenames!");
			return;
		}

		try

		{
			Path fromFile = Paths.get(source);
			Path toFile = Paths.get(target);

			if (!Files.exists(fromFile)) {

				System.out.println("Source file does not exists and will be created.");

				Files.createFile(fromFile);

				FileWriter writer = new FileWriter(source);
				writer.write("It's a new created file.");
				writer.close();
			}

			if (Files.exists(toFile))
				if (append) {
					if (Files.size(toFile) == 0) {

						System.out.println("Target file exists but it is empty and will be just overwritten.");
						Files.copy(fromFile, toFile, StandardCopyOption.REPLACE_EXISTING);

					} else {

						System.out.println("Target file exists and will be extended.");

						FileReader reader = new FileReader(source);
						FileWriter writer = new FileWriter(target, append);
						PrintWriter adder = new PrintWriter(writer);

						adder.print("\n");

						int i;

						while ((i = reader.read()) != -1)
							adder.print((char) i);

						writer.close();
						adder.close();
						reader.close();

					}
				} else {
					System.out.println("Target file exists and will be overwritten.");
					Files.copy(fromFile, toFile, StandardCopyOption.REPLACE_EXISTING);
				}
			else
				Files.copy(fromFile, toFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}