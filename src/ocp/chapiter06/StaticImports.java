package ocp.chapiter06;

//import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList; // static import
import static java.util.List.of; // static import
public class StaticImports {
	public static void main(String[] args) {
		List<String> list1 = asList("one", "two");
		List<String> list2 = of("one", "two");
	}
}
