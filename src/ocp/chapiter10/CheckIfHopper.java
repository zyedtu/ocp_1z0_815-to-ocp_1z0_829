package ocp.chapiter10;

public class CheckIfHopper implements CheckTrait {
	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}
}
