package ocp.chapiter10;

@FunctionalInterface
interface MyInterface {
	void display();
}

public class MethodReferenceInstance {

	public void myMethod() {
		System.out.println("Instance Method");
	}

	public static void main(String[] args) {
		MethodReferenceInstance obj = new MethodReferenceInstance();   
		// Method reference using the object of the class
		MyInterface ref = obj::myMethod;  
		// Calling the method of functional interface  
		ref.display();
	}

}
