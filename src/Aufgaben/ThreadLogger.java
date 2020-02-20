package Aufgaben;

class MyLogger {

	private StringBuilder sb = new StringBuilder();

	public void addMessage(String caller, String message) {

		sb.append(new String(caller)).append(" - ").append(new String(message)).append("\n");
	}

	public String getLog() {
		return new String(sb.toString());
	}
}

public class ThreadLogger {

	public static void main(String[] args) {

		MyLogger logger = new MyLogger();

		logger.addMessage("m1", "message 1");
		logger.addMessage("m2", "message 2");

		System.out.println(logger.getLog());
	}
}
