package ocp.chapiter08;

public interface IsWarmBlooded {
	boolean hasScales();
	public default double getTemperature() {
		return 10.0;
	}
}
