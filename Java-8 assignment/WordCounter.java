package java8;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Alexander", "Bob", "Abigail", "Charlie", "Davidson");

		long count = names.stream().filter(name -> name.length() > 5).count();

		System.out.println("Number of names longer than 5 characters: " + count);
	}
}