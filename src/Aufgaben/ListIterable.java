package Aufgaben;

class MyList {

	final static int SIZE = 10;

	String[] strings = new String[SIZE];

	void add(String element) {

		if (element == null || element.isBlank())
			throw new IllegalArgumentException("An element may not be empty!");

		for (int i = 0; i < SIZE; i++)
			if (this.strings[i] == null) {
				this.strings[i] = element;
				return;
			}

		throw new IllegalArgumentException("An array is full!");
	}

	int size() {

		int i = 0;

		for (; i < SIZE; i++)
			if (this.strings[i].isEmpty())
				break;

		return i;
	}

	String get(int index) {

		if (index < 0 || index > SIZE)
			throw new IllegalArgumentException("Array index out of bound!");

		if (this.strings[index].isEmpty())
			throw new IllegalArgumentException("Array element at position " + index + " is empty!");

		return this.strings[index];
	}

	public String toString() {
		String string = "[ ";

		for(String i:this.strings) {
			if(i==null)
				break;
			string+="\""+i+"\" ";
		}
		
		string += "]";
		return string;

	}
}

public class ListIterable {

	public static void main(String[] args) {

		MyList list1 = new MyList();

		list1.add("a0");
		list1.add("a1");
		list1.add("a2");
		list1.add("a3");
		list1.add("a4");

		System.out.println(list1);

	}

}
