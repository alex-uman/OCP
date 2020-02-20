package Aufgaben;

class Philosoph extends Thread {

	Philosoph(String name) {
		this.setName(name);
	}

	@Override
	public void run() {

		String name = Thread.currentThread().getName();

		while (true) {

			System.out.println(name + " denkt nach...");
			wait(2000);

			System.out.println(name + " hat Hunger");

			synchronized (Philosophen.gabelL) {
				System.out.println("\n" + name + " nimmt die linke Gabel");

				synchronized (Philosophen.gabelR) {
					System.out.println(name + " nimmt die rechte Gabel");

					System.out.println(name + " isst...");
					wait(3000);

					System.out.println(name + " legt die rechte Gabel ab");
				}
				System.out.println(name + " legt die linke Gabel ab\n");
			}
		}
	}

	static void wait(int ms) {
		try {
			int pause = ms;// + (int) (Math.random() * 500);
//			System.out.println(Thread.currentThread().getName() + " - warten " + pause + " ms");
			sleep(pause);

		} catch (Exception e) {
		}
	}
}

public class Philosophen {

	public static final Object gabelL = new Object();
	public static final Object gabelR = new Object();

	public static void main(String[] args) {

		Thread socrates = new Philosoph("Socrates");
		Thread decartes = new Philosoph("Decartes");
		Thread spinosa = new Philosoph("Spinosa");

		socrates.start();
		decartes.start();
		spinosa.start();

	}

}
