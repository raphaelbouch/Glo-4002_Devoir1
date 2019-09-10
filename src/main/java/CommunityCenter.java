import java.util.LinkedList;

public class CommunityCenter {
	
	private static final int MINIMUM_GRAVITY_FOR_SERVICE = 2;
	private LinkedList<String> nurseQueue;
	private TriageType nurseTriageType;
	
    public CommunityCenter() {
    	this(TriageType.FIFO);
    }

    public CommunityCenter(TriageType nurseTriageType) {
    	this.nurseQueue = new LinkedList<String>();
    	this.nurseTriageType = nurseTriageType;
    }
    
    public void triagePatient(String name, int gravity) {
    	if(gravity < MINIMUM_GRAVITY_FOR_SERVICE) {
    		return;
    	}
    	
        if(this.nurseTriageType == TriageType.FIFO) {
        	TriageQueue.TriageFIFO(nurseQueue, name);
        }else if(this.nurseTriageType == TriageType.GRAVITY) {
        	TriageQueue.TriageGRAVITY(nurseQueue, name, gravity);
        }
        
    }
    
    public boolean PatientIsInNurseQueue(String name) {
    	if (nurseQueue.contains(name)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String GetPatientNurseByNumberInQueue(int number) {
    	if (nurseQueue.size() <= number) {
    		return null;
    	} else {
    		return nurseQueue.get(number);
    	}
    }
    
}