import java.util.LinkedList;

public class TriageQueue {

    private static final int GRAVITY_FOR_PRIORITY = 6;

	public static void TriageFIFO(LinkedList<String> queue ,String name) {
    	queue.add(name);
    }
    
    public static void TriageGRAVITY(LinkedList<String> queue, String name, int gravity) {
    	if (gravity < GRAVITY_FOR_PRIORITY ) {
    		queue.add(name);
    	} else {
    		queue.addFirst(name);
    	}
    }
	
	
}
