package ocp.chapiter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Createstream {

	public static void main(String[] args) {

		Stream<String> empty = Stream.empty(); // count = 0
		Stream<Integer> singleElement = Stream.of(1); // count = 1
		Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
		
		var list = List.of("a", "b", "c");
		Stream<String> fromList = list.stream();
		
		var listParllel = List.of("a", "b", "c");
		Stream<String> fromListParallel = list.parallelStream();
		
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.count()); // 3
		
		List<String> liste = new ArrayList<String>();
		liste.add("monkey");
		liste.add("gorilla");
		liste.add("bonobo");
		Stream<String> stream = liste.stream();
		System.out.println(stream.count());
		
//		List<String> collect = stream.filter(e -> e.contains("go")).collect(Collectors.toList());
		
		Stream<String> streamWolf = Stream.of("w", "o", "l", "f", "w");
		List<String> listWolf = streamWolf.collect(Collectors.toList());
		System.out.println(listWolf);
		Stream<String> streamWolf2 = Stream.of("w", "o", "l", "f", "w");
		Set<String> setWolf = streamWolf2.collect(Collectors.toSet());
		System.out.println(setWolf);
		
	}
}
