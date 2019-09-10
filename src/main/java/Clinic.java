import java.util.LinkedList;

public class Clinic {
	
	private static final int GRAVITY_FOR_PRIORITY = 6;
	private LinkedList<String> FileMedecin;
	private LinkedList<String> FileRadiologie;
	private TriageType triageType;
	
	public Clinic() {
		this(TriageType.FIFO);
	}
	
    public Clinic(TriageType triageType) {
    	FileMedecin = new LinkedList<String>();
    	FileRadiologie = new LinkedList<String>();
    	this.triageType = triageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
    	if (this.triageType == TriageType.GRAVITY) {
    		TriageGRAVITY(name,gravity);
    	}else if(this.triageType == TriageType.FIFO) {
    		TriageFIFO(name);
    	}
    	
        if (SymptomRequireRadiology(visibleSymptom)) {
        	FileRadiologie.add(name);
        }
    	
    }
    
    private void TriageFIFO(String name) {
    	FileMedecin.add(name);
    }
    
    private void TriageGRAVITY(String name, int gravity) {
    	if (gravity < GRAVITY_FOR_PRIORITY ) {
    		FileMedecin.add(name);
    	} else {
    		FileMedecin.addFirst(name);
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
    	if (FileMedecin.contains(name)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean PatientIsInRadiologyQueue(String name) {
    	if (FileRadiologie.contains(name)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String GetPatientMededcinByNumberInQueue(int number) {
    	if (FileMedecin.size() <= number) {
    		return null;
    	} else {
    		return FileMedecin.get(number);
    	}
    }
    
    public String GetPatientRadiologyByNumberInQueue(int number) {
    	if (FileRadiologie.size() <= number) {
    		return null;
    	} else {
    		return FileRadiologie.get(number);	
    	}
    }
}
