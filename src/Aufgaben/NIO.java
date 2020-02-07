package Aufgaben;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {

	public static void main(String[] args) {
//		testEquals();
//		test_getNameCount_getName();
//		test_getRoot_getParent_getFileName();
//		test_subpath();
//		test_relativize();
//		test_resolve();
//
		test_weitere();
	}

	static void test_weitere() {
		System.out.println("*** nicht so Prüfungsrelevante Beispiele");

		Path path = Paths.get("a/b/./c/../d");

		System.out.println("path: " + path); // a\b\.\c\..\d
		System.out.println("path.getNameCount(): " + path.getNameCount()); // 6
		System.out.println("path.getName(4): " + path.getName(4)); // ..

		System.out.println("path.normalize(): " + path.normalize()); // a\b\d
		System.out.println(path.toAbsolutePath());

		System.out.println("aktuelles Arbeitsverzeichnis: " + Paths.get(".").toAbsolutePath().normalize());
	}

	static void test_resolve() {
		System.out.println("*** resolve");

		System.out.println();
		System.out.println("p1 ist absolut, p2 ist relativ");

		Path p1 = Paths.get("C:\\Windows");
		Path p2 = Paths.get("Java/bin");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		Path p3 = p1.resolve(p2); // resolve(Path)
//		Path p3 = p1.resolve("Java/bin"); // resolve(String), diese Variante gibt es auch 

		System.out.println("p1.resolve(p2): " + p3); // C:\Windows\Java\bin

		System.out.println();
		System.out.println("p1 und p2 sind absolut");

		p1 = Paths.get("C:\\Windows");
		p2 = Paths.get("C:\\Java\\bin");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		p3 = p1.resolve(p2);
		System.out.println("p1.resolve(p2): " + p3); // C:\Java\bin

		System.out.println();
		System.out.println("p1 ist relativ, p2 ist absolut");

		p1 = Paths.get("Windows");
		p2 = Paths.get("C:\\Java\\bin");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		p3 = p1.resolve(p2);
		System.out.println("p1.resolve(p2): " + p3); // C:\Java\bin
	}

	static void test_relativize() {

		System.out.println("*** relativize");

		System.out.println();
		System.out.println("* beide Pfade sind relativ");

		Path p1 = Paths.get("a/b/c/d");
		Path p2 = Paths.get("a/b/x/y");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		// Weg aus dem Verzeichnis y zum Verzeichnis d:
		// 1. zu x wechseln: ..
		// 2. zu b wechseln ..
		// 3. in c gehen c
		// 4. in d gehen d
		//
		// Zusammengefasst: ../../c/d

		Path p3 = p2.relativize(p1);
		System.out.println("p2.relativize(p1): " + p3); // ..\..\c\d

		System.out.println();
		System.out.println("* beide Pfade sind absolut");

//		p1 = Paths.get("/a/b");
//		p2 = Paths.get("/a/x");

		p1 = Paths.get("C:\\a\\b");
		p2 = Paths.get("C:\\a\\x");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		p3 = p2.relativize(p1);
		System.out.println("p2.relativize(p1): " + p3); // ..\b

		System.out.println();
		System.out.println("* beide Pfade sind absolut, unterschiedliche log. Laufwerke");

		p1 = Paths.get("C:\\a\\b");
		p2 = Paths.get("D:\\a\\x");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

//		 p3 = p2.relativize(p1); // java.lang.IllegalArgumentException: 'other' has
		// different root

		// auch in der Prüfung:
		System.out.println();
		System.out.println("* ein Pfad ist absolut, anderer relativ");

		p1 = Paths.get("C:\\a\\b");
		p2 = Paths.get("a\\x");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		// p2.relativize(p1); // java.lang.IllegalArgumentException: 'other' is
		// different type of Path
		// p1.relativize(p2); // java.lang.IllegalArgumentException: 'other' is
		// different type of Path
	}

	static void test_subpath() {
		System.out.println("*** subpath");

		// 0 1 2 3
		Path path = Paths.get("a/b/c/d");
		System.out.println("path: " + path);

		int beginIndex = 1;
		int endIndex = 3;
		Path subPath = path.subpath(beginIndex, endIndex);
		System.out.println("subpath(1, 3): " + subPath); // b\c

//		 System.out.println(path.subpath(0, 5)); // <- Exception
	}

	static void test_getRoot_getParent_getFileName() {
		System.out.println("*** getRoot(), getParent(), getFileName()");

		System.out.println("* mit relativen Pfadangaben: ");
		Path path = Paths.get("a/b");
		System.out.println("path: " + path);

		Path root = path.getRoot();
		System.out.println("getRoot(): " + root); // null

		Path parent = path.getParent();
		System.out.println("getParent(): " + parent); // a

		Path fileName = path.getFileName(); // The file name is the farthest element from the root in the directory
											// hierarchy.
		System.out.println("getFileName(): " + fileName); // b

		System.out.println("* mit absoluten Pfadangaben: ");
		path = Paths.get("C:\\a\\b");
		System.out.println("path: " + path);

		root = path.getRoot();
		System.out.println("getRoot(): " + root); // C:\

		parent = path.getParent();
		System.out.println("getParent(): " + parent); // C:\a

		fileName = path.getFileName(); // The file name is the farthest element from the root in the directory
										// hierarchy.
		System.out.println("getFileName(): " + fileName); // b
	}

	static void test_getNameCount_getName() {
		System.out.println("*** getNameCount, getName");

		System.out.println("* mit einem relativen Pfad");
		Path path = Paths.get("a/b", "c/d");

		System.out.println("path: " + path);

		int count = path.getNameCount();
		System.out.println("getNameCount(): " + count);

		for (int i = 0; i < count; i++) {
			Path namePath = path.getName(i);
			System.out.println("i: " + i + ", getName(i): " + namePath); // 0 -> a, 1 -> b ...
		}

		System.out.println("* mit einem absoluten Pfad");
		path = Paths.get("C:\\a\\b", "c\\d");

		System.out.println("path: " + path);

		count = path.getNameCount();
		System.out.println("getNameCount(): " + count);

		// Achtung! Wurzel (logischer Laufwerksname) ist nicht dabei
		for (int i = 0; i < count; i++) {
			Path namePath = path.getName(i);
			System.out.println("i: " + i + ", getName(i): " + namePath); // 0 -> a, 1 -> b ...
		}
	}

	static void testEquals() {

		System.out.println("*** equals");

		Path p1 = Paths.get("a");
		Path p2 = Paths.get("a");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1 == p2: " + (p1 == p2)); // false
		System.out.println("p1.equals(p2): " + (p1.equals(p2))); // true

		System.out.println("** ");

		p1 = Paths.get("a\\b\\c");
		p2 = Paths.get("a\\..\\a\\b\\c"); // Weg (Umweg) zu demselben Element wie im p1

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1 == p2: " + (p1 == p2)); // false
		System.out.println("p1.equals(p2): " + (p1.equals(p2))); // false

		System.out.println("** ");

		p1 = Paths.get("a/b/c");
		p2 = Paths.get("a/b", "c"); // Weg zu demselben Element wie im p1

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1 == p2: " + (p1 == p2)); // false
		System.out.println("p1.equals(p2): " + (p1.equals(p2))); // true

		System.out.println("** ");

		p1 = Paths.get("a/b/c");
		p2 = Paths.get("a", "b/c"); // Weg zu demselben Element wie im p1

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1 == p2: " + (p1 == p2)); // false
		System.out.println("p1.equals(p2): " + (p1.equals(p2))); // true

	}
}
