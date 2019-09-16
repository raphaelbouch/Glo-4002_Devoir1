import java.util.LinkedList;

public class Clinic extends MedicalClinic{
	private LinkedList<String> radiologyQueue;
	private TriageInterface radiologyTriage;

	public Clinic() {
		this(new TriageFIFO(), new TriageFIFO());
	}
	
    public Clinic(TriageInterface medecinTriageType, TriageInterface radiologyTriageType) {
    	medecinQueue = new LinkedList<String>();
    	radiologyQueue = new LinkedList<String>();
    	
    	this.medecinTriage = medecinTriageType;
    	this.radiologyTriage = radiologyTriageType;

    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
    	if(gravity < MINIMUM_GRAVITY_FOR_SERVICE) {
    		return;
    	}
    	
    	this.medecinTriage.AddToQueue(medecinQueue, name, gravity);
    	
        if (visibleSymptom.requireRadiology) {
        	this.radiologyTriage.AddToQueue(radiologyQueue, name, gravity);
        }
        
    }
    
    public boolean PatientIsInRadiologyQueue(String name) {
    	return radiologyQueue.contains(name);
    }
    
    public String GetPatientRadiologyByNumberInQueue(int number) {
    	try {
    		return radiologyQueue.get(number);
    	}catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
}
