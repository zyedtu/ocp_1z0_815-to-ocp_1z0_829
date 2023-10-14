package ocp.chapiter10;

import java.util.Arrays;

public class MethodReferenceInstanceParticular {

	public static void main(String[] args) {
		String[] stringArray = { "Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		for(String str: stringArray){
			System.out.println(str);
		}

	}

}
