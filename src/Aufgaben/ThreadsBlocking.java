package Aufgaben;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadsBlocking {

	public static void main(String[] args) {

		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' };

//		Runnable perm1 = () -> {
//			Permutation.permutate1(letters, 3);
//		};
//
//		new Thread(perm1).start();

		ArrayBlockingQueue<Character> bq = null;

		Runnable perm2 = () -> {
			Permutation.permutate2(letters, 3, bq);
		};

		new Thread(perm2).start();

		System.out.println(bq.toString());
		
	}

}
