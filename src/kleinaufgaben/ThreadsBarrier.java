package kleinaufgaben;

import java.util.*;
import java.util.concurrent.*;

class RaceCar implements Runnable {
	private String name;
	private List<RaceCar> finish;
	private CyclicBarrier barrier;

	public RaceCar(String name, List<RaceCar> finish, CyclicBarrier barrier) {
		this.name = name;
		this.finish = finish;
		this.barrier = barrier;
	}

	public void run() {
//		System.out.println(name + " started.");

		synchronized (finish) {
			finish.add(this);
			ThreadsBarrier.place++;
			System.out.println(name + " finished as " + ThreadsBarrier.place);
		}

		try {
			barrier.await();

		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return name;
	}
}

public class ThreadsBarrier {

	static int count = 0;

	static int place = 0;

	public static void main(String[] args) {

		a1();

		sleep(20);
		System.out.println();

		a2();

	}

	static void a1() {

		Runnable action = () -> System.out.println(Thread.currentThread().getId() + " count = " + count);

		CyclicBarrier barrier = new CyclicBarrier(2, action);

		Runnable inc = () -> {

			for (int i = 0; i < 1000000; i++)
				count++;

			try {
				barrier.await();

			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}

			System.out.println("Thread " + Thread.currentThread().getId() + " finished");
		};

		new Thread(inc).start();
		new Thread(inc).start();
	}

	static void a2() {

		List<RaceCar> winners = Collections.synchronizedList(new ArrayList());

		CyclicBarrier barrier = new CyclicBarrier(4);

//		List<RaceCar> cars = Arrays.asList(new RaceCar("Car 1", winners, barrier),
//				new RaceCar("Car 2", winners, barrier), new RaceCar("Car 3", winners, barrier),
//				new RaceCar("Car 4", winners, barrier));

		
		new Thread(new RaceCar("Car 1", winners, barrier)).start();
		new Thread(new RaceCar("Car 2", winners, barrier)).start();
		new Thread(new RaceCar("Car 3", winners, barrier)).start();
		new Thread(new RaceCar("Car 4", winners, barrier)).start();
		

		sleep(200);
		System.out.println();

		winners.forEach(System.out::println);
	}

	static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
		}
	}

}
