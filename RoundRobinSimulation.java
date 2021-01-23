public class RoundRobinSimulation {

	private final static int NUM_PROCESSES_INIT = 10;
	private final static int MAX_PROCESS_DURATION = 250;
	private final static int TIME_SLICE = 10;
	private final static double ADD_PROCESS_THRESHOLD = 0.03;
	private final static boolean VERBOSE_MODE = true;

	public static void main(String[] args) {
		CircularlyLinkedList<Process> processList = new CircularlyLinkedList<Process>();
		int processNum = 1;
		int simulationTime = 0;
		int sliceCount = 0;

		for (int i = 0; i < NUM_PROCESSES_INIT; i++) {
			processList.addLast(new Process("P" + processNum++, (int) (Math.random() * MAX_PROCESS_DURATION) + 1));
		}

		while (!processList.isEmpty()) {
			if (VERBOSE_MODE) System.out.printf("@%05d %s\n", simulationTime, processList);
			
			Process p = processList.getFirst();
			int time = p.execute(TIME_SLICE);
			
			if (time == 0) {
				processList.removeFirst();
			} else {
				processList.rotate();
			}

			if (Math.random() < ADD_PROCESS_THRESHOLD) {
				if (VERBOSE_MODE) System.out.println("\n*** Added new Process P" + processNum + " ***\n");
				processList.addLast(new Process("P" + processNum++, (int) (Math.random() * MAX_PROCESS_DURATION) + 1));
			}

			simulationTime += TIME_SLICE;
			sliceCount++;
		}
		
		System.out.printf("\nSimulation ended at %05d. %d Processes were completed in %d time slices.\n", simulationTime, processNum-1, sliceCount);
	}
}
