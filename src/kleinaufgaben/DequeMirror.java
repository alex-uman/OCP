package kleinaufgaben;

import java.util.ArrayDeque;

class Mirror {

	private ArrayDeque<Character> deque = new ArrayDeque<>();

	Mirror() {
		deque.add('|');
	}

	void add(char letter) {
		deque.addFirst(letter);
		deque.addLast(letter);
	}

	void remove() {
		deque.removeFirst();
		deque.removeLast();
	}

	boolean isEmpty() {
		return deque.size() < 2;
	}

	public ArrayDeque<Character> getDeque() {
		return deque;
	}

	public void setDeque(ArrayDeque<Character> deque) {
		this.deque = deque;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (char i : deque)
			sb.append(i);

		return sb.toString();
	}

}

public class DequeMirror {

	public static void main(String[] args) {

		Mirror m = new Mirror();

		for (char ch = 'a'; ch < 'g'; ch++) {
			m.add(ch);
			System.out.println(m);
		}

		while (!m.isEmpty()) {
			System.out.println(m);
			m.remove();
		}
	}
}
