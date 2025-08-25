package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyMapper {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Alice", "John", "Bob", "Alice", "John", "Charlie", "Bob");

		Map<String, Long> nameCounts = names.stream()
				.collect(Collectors.groupingBy(name -> name, Collectors.counting()));

		nameCounts.forEach((name, count) -> System.out.println(name + ": " + count));
	}
}