package kleinaufgaben;

import java.io.File;

public class FileDirsCount {

	public static void main(String[] args) {

		/*
		 * - Suchen Sie ein einfaches Verzeichnis aus (z.B. "C:\\Program Files\\7-Zip")
		 * 
		 * - Durchsuchen Sie es rekursiv und ermitteln Sie die Anzahl alle
		 * Unterverzeichnisse
		 * 
		 * Tipp: Methode listFiles verwenden
		 * 
		 * - Die Lösung mit komplexereren Verzeichnissen testen.
		 */

		File dir = new File("C:\\Locate\\");

		System.out.println(countDirs(dir));

	}

	static int countDirs(File file) {

		int count = 0;

		File[] files = file.listFiles(File::isDirectory);

		if (files != null) {

			count += files.length;

			for (File i : files) {
				count += countDirs(i);
			}
		}

		return count;
	}
}