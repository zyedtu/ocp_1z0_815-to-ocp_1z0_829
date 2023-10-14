package ocp.chapiter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PuttingTogether {

	public static void main(String[] args) {
		var list = List.of("Toby", "Anna", "Leroy", "Alex");
		List<String> filtered = new ArrayList<>();
		for (String name: list)
		if (name.length() == 4) filtered.add(name);
		Collections.sort(filtered);
		var iter = filtered.iterator();
		if (iter.hasNext()) System.out.println(iter.next());
		if (iter.hasNext()) System.out.println(iter.next());
		System.out.println("===================================");
		var listPuttingTogether = List.of("Toby", "Anna", "Leroy", "Alex");
		list.stream().filter(n -> n.length() == 4).sorted()
		.limit(2).forEach(System.out::println);
		
		Stream<String> s = Stream.of("1", "2", "3", "4");
		  
        // using Collectors toList() function
        List<String> myList = s.collect(Collectors.toList());
  
        // printing the elements
        System.out.println(myList);

	}

}
