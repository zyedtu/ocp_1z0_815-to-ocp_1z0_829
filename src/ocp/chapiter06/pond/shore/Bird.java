package ocp.chapiter06.pond.shore;

public class Bird {
	protected String text = "floating"; // protected access

	protected void floatInWater() { // protected access
		System.out.println(text);
	}
}
