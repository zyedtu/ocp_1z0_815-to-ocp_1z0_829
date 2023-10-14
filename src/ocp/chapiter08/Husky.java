package ocp.chapiter08;

public abstract class Husky {
	abstract void play();
}

interface Poodle {
	void play();
}

interface I1 {
	void i1();
}

interface I2 {
	void i2();
}

interface I3 extends I1,I2{
	void i3();
}

class Webby extends Husky {
	void play() {}
}

class Georgette implements Poodle {
	public void play() {}
}

interface Ter {
	private void e() {

	}
}