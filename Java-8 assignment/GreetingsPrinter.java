package java8;

@FunctionalInterface
interface MessagePrinter {
	void printMessage(String message);
}

public class GreetingsPrinter {
	public static void main(String[] args) {
		// Pass a lambda expression as a MessagePrinter
		greet("Hello, World!", (message) -> System.out.println(message));

		// Pass a method reference as a MessagePrinter
		greet("Hi, there!", System.out::println);
	}

	public static void greet(String message, MessagePrinter printer) {
		printer.printMessage(message);
	}
}