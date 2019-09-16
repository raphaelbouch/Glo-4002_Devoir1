import java.util.LinkedList;

public class TriageFIFO implements TriageInterface{

	public void AddToQueue(LinkedList<String> queue, String name, int gravity) {
		queue.add(name);
	}

}
