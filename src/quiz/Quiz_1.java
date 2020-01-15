package quiz;

import java.util.ArrayList;

//enum Theme {
//	KLASSEN(1), INTERFACES(2), LOOPS(3), LAMBDAS(4), PRIMITIVES(5);
//
//	int id;
//
//	Theme(int id) {
//		this.id = id;
//	}
//
//	public String toString() {
//
//		return name().charAt(0) + name().substring(1).toLowerCase();
//	}
//
//}

class Question {

	private String description, comment = "";
	private ArrayList<String> topics;
	private ArrayList<Answer> answer;

	Question(String description, ArrayList topics, ArrayList answer) {
		this.setDescription(description);
		this.setTopics(topics);
//		this.setAnswer(answer);
	}

	Question(String description, String comment, ArrayList topics, ArrayList answer) {
		this(description, topics, answer);

		this.setComment(comment);
	}

	public void setDescription(String description) {
		if (description == null || description.trim() == "")
			throw new IllegalArgumentException("Incorrect description!");
		this.description = description;
	}

	public void setComment(String comment) {
		if (comment != null)
			comment = "";
		this.comment = comment;
	}

	public void setTopics(ArrayList topics) {
		if (topics == null) // || topics.checktrim() == "")
			throw new IllegalArgumentException("Incorrect description!");
		this.description = description;
	}

	private String listToString(ArrayList list) {
		String string = "";
		for (Object i : list)
			string += i.toString();
		return string;
	}

	private String arrayToString(Object[] array) {
		String string = "";
		for (Object i : array)
			string += i.toString();
		return string;
	}

	public String AnswersToString() {
		return "";
	}

	public String toString() {
		return this.description;
	}
}

class Answer {
	private String description;
	private boolean correctness;

	Answer(String description, boolean correctness) {
		this.description = description;
		this.correctness = correctness;
	}

	Answer(String description) {
		this(description, false);
	}

	public String getDescrtiption() {
		return this.description;
	}

	public void setDescrtiption(String description) {
		this.description = description;
	}

	public boolean getCorrectness() {
		return this.correctness;
	}

	public void setTrue() {
		this.correctness = true;
	}

	public void setFalse() {
		this.correctness = false;
	}

	public String toString() {
		return this.description;
	}
}

public class Quiz_1 {

	public static void main(String[] args) {

	}

}
