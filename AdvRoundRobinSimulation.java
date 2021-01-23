// The class we have to submit for the second part of the lab.
public class AdvRoundRobinSimulator {
    // Constants
    
    // Allocate a new CircularlyLinkedList<Process> and return a reference to it after populating
    // it with the processes from the input instruction file "ProcessSequence1.txt"
    public static CircularlyLinkedList<Process> getProcessesFromFile(String filename) {
        
    }
    
    // Reads the inputs in the format AT <time> ADD <process-name> <duration> 
    //and schedules the processes in 10ms time slices
    public static void main(String[] args) {
        CircularlyLinkedList<Process> processList = getProcessesFromFile("ProcessSequence1.txt");
    }
}
