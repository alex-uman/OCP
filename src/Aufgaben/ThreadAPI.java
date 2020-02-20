package Aufgaben;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class ThreadLoop extends Thread {

	public void run() {

		while (true) {
			ThreadAPI.sleep(950);
			System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
		}
	}
}

class RunnableLoop implements Runnable {

	public void run() {

		while (true) {

			ThreadAPI.sleep(950);
			System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
		}
	}
}

class ThreadID extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getId());
	}
}

public class ThreadAPI {

	public static void main(String[] args) {

//		A1();
//		A2();
//		A3();
		A4();
//		A5();

	}

	static void A1() {
		new ThreadLoop().start();
	}

	static void A2() {
		Runnable r2 = new RunnableLoop();
		r2.run();
	}

	static void A3() {

		int size = 37;

		Thread[] threadArray = new Thread[size];

		for (int i = 0; i < size; i++)
			threadArray[i] = new ThreadID();

		int n = 1;
		for (Thread i : threadArray) {

			System.out.print(n++ + ", ");
			i.start();

			sleep(1);
		}
	}

	static void A4() {

		for (char i = 'A'; i <= 'Z'; i++) {

//			char letter = (char) ((int) 'A' + i);
			char letter = i;

			Runnable r4 = () -> {
				System.out.println(letter);
			};

			Thread t4 = new Thread(r4);
			t4.start();

			sleep(1);
		}
	}

	static void A5() {

		Runnable r5 = () -> {
			bigJob();
		};

		Thread t51 = new Thread(r5);
		Thread t52 = new Thread(r5);

		t51.setName("Tom");
		t52.setName("Jerry");

		t51.setPriority(1);
		t52.setPriority(10);

		t51.start();
		t52.start();
	}

	static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
		}
	}

	public static void bigJob() {
		Thread th = Thread.currentThread();
		System.out.println("Starte " + th.getName() + ". Priorität: " + th.getPriority());

		long start = System.currentTimeMillis();

		int exists = 0;
		for (int i = 0; i < 100_000; i++) {
			Path path = Paths.get("./" + i);
			if (Files.exists(path)) {
				exists++;
			}
		}

		long ende = System.currentTimeMillis();

		System.out.println("Thread: " + th.getName() + ", Zeit: " + (ende - start) / 1000. + " Sek. / " + exists);
	}

}
