package ocp.chapiter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Math;

public class LSUD {

	public static void main(String[] args) {
//		var cats = new ArrayList<String>();
//		cats.add("Annie");
//		cats.add("Ripley");
//		var stream = cats.stream();
//		cats.add("KC");
//		System.out.println(stream.count());
//		Optional<String> optional= Optional.of("Laura");
//		Optional<Integer> result = optional.map(String::length);
//		System.out.println(result.get());
		
		 var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-","mouse-");
		 Spliterator<String> originalBagOfFood = stream.spliterator();
		 Spliterator<String> emmasBag = originalBagOfFood.trySplit();
		 emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-
		
		 Spliterator<String> jillsBag = originalBagOfFood.trySplit();
		 jillsBag.tryAdvance(System.out::print); // dog-20:
		 jillsBag.forEachRemaining(System.out::print); // fish-21:
		 originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-
		 
		 var originalBag = Stream.iterate(1, n -> ++n).spliterator();
		 
		 Spliterator<Integer> newBag = originalBag.trySplit();
		 newBag.tryAdvance(System.out::print); // 1
		 newBag.tryAdvance(System.out::print); // 2
		 newBag.tryAdvance(System.out::print); // 3
		 System.out.println("___");
		 var ohMy = Stream.of("lions", "tigers", "bears");
		 String result = ohMy.collect(Collectors.joining(", "));
		 System.out.println(result); // lions, tigers, bears

	}

	private static void threeDigit(Optional<Integer> optional) {
		if (optional.isPresent()) { // outer if
			var num = optional.get();
			var string = "" + num;
			if (string.length() == 3) // inner if
				System.out.println(string);
		}
	}

	private static void threeDigit2(Optional<Integer> optional) {
		optional.map(n -> "" + n) // part 1
				.filter(s -> s.length() == 3) // part 2
				.ifPresent(System.out::println); // part 3
	}

}




                                                                
