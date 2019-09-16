import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommunityCenterTest {

	private static final String FIRST_PATIENT_NAME = "John";
	private static final int UNSPECIFIED_GRAVITY = 3;
	public CommunityCenter communityCenter;
	
	@Before
	public void setup() {
		communityCenter = new CommunityCenter();
	}

	@Test
	public void WhenAddingPatientWithoutKnownSymptom_ThenPatientIsAddedInQueue() {
		communityCenter.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY);
		assertTrue(communityCenter.PatientIsInMedecinQueue(FIRST_PATIENT_NAME));
	}

}
