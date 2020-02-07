package Aufgaben;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FilesCounter {

	private Path path;

	FilesCounter(String path) {
		setPathName(path);
	}

	FilesCounter(Path path) {
		setPath(path);
	}

	public Path getPath() {
		return this.path;
	}

	public String getPathName() {
		return this.path.toString();
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public void setPathName(String path) {
		this.path = Path.of(path);
	}

	public int count(String ext) {
		long counter = 0;
		try {
			counter = Files.list(this.getPath())
					.filter(x -> x.toString().toLowerCase().endsWith("." + ext.toLowerCase())).count();
		} catch (IOException ioe) {
//			counter = -1;
		}

		return (int) counter;
	}

	public int countDeep(String ext) {
//		try {
//			return (int) Files
//					.find(this.getPath(), 100, (x, y) -> x.toString().toLowerCase().endsWith("." + ext.toLowerCase()))
//					.count();
//		} catch (IOException ioe) {
//
//			return -1;
//		}

		return (int) (this.count(ext) + this.countIntern(ext));
	}

	private int countIntern(String ext) {
		long counter = 0;

		try {
			Object[] path = Files.list(this.getPath()).filter(Files::isDirectory).toArray();

			for (Object i : path) {

				FilesCounter fc = new FilesCounter((Path) i);

				System.out.println("" + counter + " " + i.toString());
				counter += fc.count(ext) + fc.countIntern(ext);
			}

		} catch (IOException ioe) {
			System.out.println("" + counter + " " + this.getPath().toString());
//			counter = -1;
		}

		return (int) counter;
	}

	static String intoString(Object object) {
		return object.toString();
	}

	public static void main(String[] args) {

		FilesCounter fc = new FilesCounter("C:\\Windows");

		System.out.println(fc.count("txt"));
//		System.out.println(fc.countDeep("txt"));

		test_createDirectories();

	}

	static void test_createDirectories() {
		System.out.println("*** createDirectories");

		Path dir = Paths.get("a/b/c/d/e");

		try {

			Path result = Files.createDirectories(dir);
			System.out.println("Erzeugt: " + result);

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Aufräumen
		 */
		try {
			/*
			 * kleine Aufgabe: löschen Sie die zuvor erzeugten Verzeichnisse a/b/c/d/e mit
			 * einer Schleife
			 */

			while (dir != null) {
				Files.delete(dir);
				dir = dir.getParent();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
