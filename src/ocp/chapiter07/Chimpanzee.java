package ocp.chapiter07;

class Primate1{
	public Primate1() {
		System.out.print("Primate-");
	}
}

class Ape extends Primate1{
	public Ape(int fur) {
		System.out.print("Ape1-");
	}
	public Ape() {
		System.out.print("Ape2-");
	}
}
public class Chimpanzee extends Ape{
	public Chimpanzee() {
		super(2);
		System.out.print("Chimpanzee-");
	}
	public static void main(String[] args) {
		new Chimpanzee();
	}
}
