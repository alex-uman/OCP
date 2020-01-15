package Aufgaben;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

public class Task implements Comparable<Task> {

	enum Priority {
		LOW, NORMAL, HIGH
	}

	private String description;
	private GregorianCalendar time;
	private Priority priority;

	Task(String description, Priority priority) {
		setDescription(description);
		setPriority(priority);
	}

	Task(String description, Priority priority, GregorianCalendar time) {
		this(description, priority);
		setTime(time);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public GregorianCalendar getTime() {
		return time;
	}

	public void setTime(GregorianCalendar time) {
		this.time = time;
	}

	@Override
	public int compareTo(Task task) {
		int compare = 0;

		if (this.getTime() != null && task.getTime() != null)
			compare = this.getTime().compareTo(task.getTime());
		else
			return task.getPriority().ordinal() - this.getPriority().ordinal();

		if (compare == 0)
			compare = task.getPriority().ordinal() - this.getPriority().ordinal();

		return compare;
	}

	@Override
	public String toString() {
		return "\"" + this.getDescription() + "\",  Priority: " + this.getPriority()
				+ (this.getTime() != null
						? ",  Date/Time: "
								+ new SimpleDateFormat("dd.mm.yyyy' / 'hh:mm:ss").format(this.getTime().getTime())
						: "");
	}

	public static void main(String[] args) {

		PriorityQueue<Task> tasks = new PriorityQueue<Task>();
		tasks.add(new Task("Einkaufen1", Priority.NORMAL, new GregorianCalendar(2020, 02, 2, 10, 11, 01)));
		tasks.add(new Task("Einkaufen2", Priority.NORMAL, new GregorianCalendar(2020, 02, 2, 10, 11, 02)));
		tasks.add(new Task("Autowäsche", Priority.LOW, new GregorianCalendar(2020, 02, 2, 10, 11, 00)));
		tasks.add(new Task("Rechnung bezahlen", Priority.HIGH));

		System.out.println(tasks.poll());
		System.out.println(tasks.poll());
		System.out.println(tasks.poll());

	}

}
