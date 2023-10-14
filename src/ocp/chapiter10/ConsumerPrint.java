package ocp.chapiter10;

import java.util.function.Consumer;

public class ConsumerPrint {

	public static void main(String[] args) {
		Consumer<String> consumer = x -> System.out.println(x);
		Consumer<String> consumer2 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		print(consumer, "Hello World");
		print(consumer2, "Hello World");
	}
	
	private static void print(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}
}
