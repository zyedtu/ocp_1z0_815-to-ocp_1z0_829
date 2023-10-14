package ocp.chapiter07;

class Mammal{
	String type = "mammal";
	
	Mammal(int x) {}
}

public class Bat extends Mammal{

	String type = "bat";
	
	Bat(){
		super(12);
	}
	public String getType() {
		return super.type + ":" + this.type;
	}
	
	public static void main(String[] args) {
		System.out.println(new Bat().getType());
	}
}

class AfricanElephant extends Bat { }
