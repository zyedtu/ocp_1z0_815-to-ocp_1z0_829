package ocp.chapiter07;

class Primate {
	public boolean hasHair() {
		return true;
	}
}
interface HasTail {
	public boolean isTailStriped();
}
public class Lemur extends Primate implements HasTail {
	public boolean isTailStriped() {
		return false;
	}
	
	public void printLemur() {
		System.out.println("Is Lemur {}");
	}

	public int age = 10;

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		lemur.printLemur(); 
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());
		Primate primate = lemur;
		System.out.println(primate.hasHair());
		
//		Lemur lemur2 = primate; //	DOES NOT COMPILE
		
		Lemur lemur3 = (Lemur) primate;	//	Explicit Cast
		System.out.println(lemur3.age);
		
		Object lemurObj = lemur;
		
	}
}
