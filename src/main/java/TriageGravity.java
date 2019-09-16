import java.util.LinkedList;

public class TriageGravity implements TriageInterface{

    private static final int GRAVITY_FOR_PRIORITY = 6;
	
	public void AddToQueue(LinkedList<String> queue, String name, int gravity) {
    	if (gravity < GRAVITY_FOR_PRIORITY ) {
    		queue.add(name);
    	} else {
    		queue.addFirst(name);
    	}
	}
}
