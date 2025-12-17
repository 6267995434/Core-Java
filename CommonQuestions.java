package streamApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * When you see a String question, ask yourself:

1️⃣ Do I need characters or words?
2️⃣ Convert String → Stream -> use Arrays.split / s.char()
3️⃣ Use:

filter() → condition
map() → transform
collect() → final result

4️⃣ If order matters → LinkedHashMap
5️⃣ If counting → Collectors.counting()
 */
public class CommonQuestions {

	public static void main(String[] args) {

		String s = "I am Java developer I am";
		String q2 = "aesdgdfas";
		String str = "programming";
		String str1 = "swiss";
		System.out.println("q2: " + q2);
		// String to Stream

		// String to Stream Character - marked by characters
		Stream<Character> s1 = s.chars().mapToObj(c -> (char) c);
		// String to Stream String - marked by words
		Stream<String> s2 = Arrays.stream(s.split(" "));

		// Given a String find the word with highest length
		String longest = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
		System.out.println(longest);

		// Removves duplicate from String and return in same order
		System.out.println();
		q2.chars().distinct().mapToObj(x -> (char) x).forEach(System.out::print);
		System.out.println();
		Arrays.stream(q2.split("")).distinct().forEach(System.out::print);
		System.out.println();

		// find the word with 2nd/Nth longest word
		Optional<String> ans = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed())
				.skip(1).findFirst();
		System.out.println(" find the word with 2nd/Nth longest word " + ans.get());

		// find the Map of word and length which has longest length
		Map<String, Integer> ans3 = Arrays.stream(s.split(" ")).distinct()
				.collect(Collectors.toMap(c -> c, c -> c.length())); // forEach(System.out::print);
		System.out.println("ans3: " + ans3);

		// Find the counting of Strings
		Map<String, Long> ans4 = Arrays.stream(s.split(" "))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(ans4);

		// Find duplicate characters
		Set<String> ans5 = Arrays.stream(str.split("")).filter(x -> x.length() > 1).collect(Collectors.toSet());
		Set<String> ans6 = Arrays.stream(str.split(""))
				.filter(x -> Collections.frequency(Arrays.asList(str.split("")), x) > 1).collect(Collectors.toSet());
		System.out.println("Str is : " + str + "ans is :" + ans5);
		Set<String> ans7 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
		System.out.println("Str is : " + str + "ans is :" + ans6);
		System.out.println("Str is : " + str + "ans is :" + ans7);
		Set<String> ans8 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
		System.out.println(ans8);

//		First non-repeated character ⭐ (VERY IMPORTANT)
		String result = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() < 2).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println("First non-repeated characte: " + result);

		// Reverse a string
		String rev = Arrays.asList(str.split("")).stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
					Collections.reverse(lst);
					return String.join("", lst);
				}));
		String rev1 = Arrays.asList(rev).stream().collect(Collectors.joining());
		System.out.println(str);
		System.out.println(rev);
		System.out.println(rev1);

	}
}
