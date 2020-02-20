package kleinaufgaben;

class Printer extends Thread {

//	char letter;
//	int row, line;

	Printer(char letter, int row, int line) {
//		this.letter = letter;
//		this.row = row;
//		this.line = line;
		st(letter, row,line);
	}

//	public void start() {
	public void st(char letter, int row, int line) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < row; j++)
				System.out.print(letter);
			System.out.println();
		}
	}
}

public class ThreadSyncPrinter {

	public static void main(String[] args) {

		/*
		 * Voraussetzung: nur die Methoden der Klasse 'Printer' werden in dieser
		 * Anwendung Konsolenausgaben generieren.
		 */

		/*
		 * A1. Bitte die KLasse 'Printer' realisieren.
		 * 
		 * Folgender Printer wird 20 Zeilen ausgeben: (jede Zeile hat 10 Zeichen a)
		 * 
		 * aaaaaaaaaa ... aaaaaaaaaa
		 * 
		 */
		Printer p1 = new Printer('a', 10, 20);
//		p1.start();

	}

}
