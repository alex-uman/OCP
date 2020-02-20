package kleinaufgaben;

import java.util.*;
import java.util.concurrent.*;

public class Concurrency100 {

	public static void main(String[] args) throws Exception {

		ExecutorService srv = Executors.newCachedThreadPool();

		List<Future<Integer>> futs = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			Callable<Integer> cll = () -> (int) (Math.random() * 5) + 1;
			Future<Integer> fut = srv.submit(cll);
			futs.add(fut);
		}

		srv.shutdown();

		int sum = 0;

		for (Future<Integer> f : futs)
			sum += f.get();

		System.out.println(sum);

	}
}
