package kleinaufgaben;

import java.util.Random;

public class ThreadPriority {

	public static void main(String[] args) {

		Runnable summer = () -> {

			long sum = 0;
			Random r = new Random();

			for (int i = 0; i < 1_000_000; i++)
				sum += r.nextInt();

			System.out.println(Thread.currentThread() + ": " + sum);
		};

		Thread t1 = new Thread(summer);
		Thread t2 = new Thread(summer);

		t1.setName("t1");
		t2.setName("t2");
		
		t1.setPriority(1);
		t2.setPriority(10);

		t1.start();
		t2.start();

	}

}
