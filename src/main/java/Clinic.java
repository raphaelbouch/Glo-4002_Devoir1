import java.util.LinkedList;

public class Clinic {
	
	private static final int MINIMUM_GRAVITY_FOR_SERVICE = 2;
	private LinkedList<String> medecinQueue;
	private LinkedList<String> radiologyQueue;
	private TriageType medecinTriageType;
	private TriageType radiologyTriageType;

	public Clinic() {
		this(TriageType.FIFO, TriageType.FIFO);
	}
	
    public Clinic(TriageType medecinTriageType, TriageType radiologyTriageType) {
    	medecinQueue = new LinkedList<String>();
    	radiologyQueue = new LinkedList<String>();
    	this.medecinTriageType = medecinTriageType;
    	this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
    	if(gravity < MINIMUM_GRAVITY_FOR_SERVICE) {
    		return;
    	}
    	
    	
    	if (this.medecinTriageType == TriageType.GRAVITY) {
    		TriageQueue.TriageGRAVITY(medecinQueue,name,gravity);
    	}else if(this.medecinTriageType == TriageType.FIFO) {
    		TriageQueue.TriageFIFO(medecinQueue,name);
    	}
    	
        if (SymptomRequireRadiology(visibleSymptom)) {
        	if (this.radiologyTriageType == TriageType.GRAVITY) {
        		TriageQueue.TriageGRAVITY(radiologyQueue,name,gravity);
        	}else if(this.radiologyTriageType == TriageType.FIFO) {
        		TriageQueue.TriageFIFO(radiologyQueue,name);
        	}
        }
    	
    }
    
    public boolean SymptomRequireRadiology(VisibleSymptom visibleSymptom) {
    	boolean RequireRadiology = false;
    	
    	if (visibleSymptom == VisibleSymptom.BROKEN_BONE){
    		RequireRadiology = true;
    	}
    	if (visibleSymptom == VisibleSymptom.SPRAIN){
    		RequireRadiology = true;
    	}
    	
    	return RequireRadiology;
    }
    
    public boolean PatientIsInMedecinQueue(String name) {
    	if (medecinQueue.contains(name)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean PatientIsInRadiologyQueue(String name) {
    	if (radiologyQueue.contains(name)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String GetPatientMedecinByNumberInQueue(int number) {
    	if (medecinQueue.size() <= number) {
    		return null;
    	} else {
    		return medecinQueue.get(number);
    	}
    }
    
    public String GetPatientRadiologyByNumberInQueue(int number) {
    	if (radiologyQueue.size() <= number) {
    		return null;
    	} else {
    		return radiologyQueue.get(number);	
    	}
    }
}
