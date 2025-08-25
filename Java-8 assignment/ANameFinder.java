package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ANameFinder {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Alice", "Bob", "Ava", "Charlie", "Adam");

		List<String> aNames = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());

		System.out.println("Names starting with A:");
		aNames.forEach(System.out::println);
	}
}