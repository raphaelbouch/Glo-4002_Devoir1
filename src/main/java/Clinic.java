import java.util.LinkedList;

public class Clinic {
	
	private LinkedList<String> FileMedecin;
	private LinkedList<String> FileRadiologie;
	
    public Clinic() {
    	FileMedecin = new LinkedList<String>();
    	FileRadiologie = new LinkedList<String>();
    	
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        FileMedecin.add(name);
        if (SymptomRequireRadiology(visibleSymptom)) {
        	FileRadiologie.add(name);
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
