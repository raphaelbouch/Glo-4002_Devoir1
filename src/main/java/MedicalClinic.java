import java.util.LinkedList;

public class MedicalClinic {
	protected static final int MINIMUM_GRAVITY_FOR_SERVICE = 2;
	protected LinkedList<String> medecinQueue;
	protected TriageInterface medecinTriage;

	public MedicalClinic() {
		this(new TriageFIFO());
	}
	
    public MedicalClinic(TriageInterface medecinTriageType) {
    	medecinQueue = new LinkedList<String>();
    	
    	this.medecinTriage = medecinTriageType;

    }

    public void triagePatient(String name, int gravity) {
    	if(gravity < MINIMUM_GRAVITY_FOR_SERVICE) {
    		return;
    	}
    	
    	this.medecinTriage.AddToQueue(medecinQueue, name, gravity);
    }
    
    public boolean PatientIsInMedecinQueue(String name) {
    	return medecinQueue.contains(name);
    }
    
    public String GetPatientMedecinByNumberInQueue(int number) {
    	try {
    		return medecinQueue.get(number);
    	}catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
}
