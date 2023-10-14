package ocp.chapiter06;

public class TooManyConversions {

	public static void play(Long l) { }
	public static void play(Long... l) { }
	
	public static void main(String[] args) {
//		play(4); // DOES NOT COMPILE
		play(4L); // calls the Long version
	}
}
