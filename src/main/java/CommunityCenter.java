import java.util.LinkedList;

public class CommunityCenter extends MedicalClinic{
	
    public CommunityCenter() {
    	this(new TriageFIFO());
    }

    public CommunityCenter(TriageInterface medecinTriageType) {
    	this.medecinQueue = new LinkedList<String>();
    	this.medecinTriage = medecinTriageType;
    }
}