public class Process {
	private String name;
	private int duration;
	
	public Process(String n, int d) {
		name = n;
		duration = d > 0 ? d : 0;
	}
	
	public int execute(int slice) {
		duration -= slice;
		if (duration <= 0) {
			duration = 0;
		}
		return duration;
	}
	
	public String toString() {
		return "{" + name + ": " + duration + "}";
	}
}