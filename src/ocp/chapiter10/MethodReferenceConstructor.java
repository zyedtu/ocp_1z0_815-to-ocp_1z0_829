package ocp.chapiter10;

@FunctionalInterface
interface MyInterface2 {
	Hello display(String say);
}

class Hello {
	public Hello(String say) {
		System.out.print(say);
	}
}

public class MethodReferenceConstructor {

	public static void main(String[] args) {
		MyInterface2 ref = Hello::new;  
        ref.display("Hello World!"); 
	}
}
