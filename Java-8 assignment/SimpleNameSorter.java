package java8;

import java.util.Arrays;
import java.util.Comparator;

public class SimpleNameSorter {
	public static void main(String[] args) {
		String[] names = { "John", "Alice", "Bob", "Eve", "Charlie" };

		// Sort names using lambda expression
		Arrays.sort(names, (a, b) -> a.compareTo(b));

		// Print sorted names
		System.out.println("Sorted Names:");
		for (String name : names) {
			System.out.println(name);
		}
	}
}