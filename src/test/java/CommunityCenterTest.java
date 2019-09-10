import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommunityCenterTest {

	private static final String FIRST_PATIENT_NAME = "John";
	private static final int UNSPECIFIED_GRAVITY = 3;
	private static final String SECOND_PATIENT_NAME = "Luke";
	private static final int GRAVITY_GREATER_THAN_FIVE = 7;
	private static final int GRAVITY_BELOW_MINIMUM = 1;
	public CommunityCenter communityCenter;
	
	@Before
	public void setup() {
		communityCenter = new CommunityCenter();
	}

	@Test
	public void WhenOpening_NurseQueueIsEmpty() {
		assertNull(communityCenter.GetPatientNurseByNumberInQueue(0));
	}

	@Test
	public void IfThereIsNoPatient_WhenPatientCome_ThenHeIsFirstInNurseQueue() {
		communityCenter.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY);
		
		assertTrue(communityCenter.GetPatientNurseByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
	}
	
	@Test
	public void IfThereIsAPatientInNurseQueue_WhenNewPatientCome_ThenHeIsSecondInMedecinQueue() {
		communityCenter.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY);
		communityCenter.triagePatient(SECOND_PATIENT_NAME, UNSPECIFIED_GRAVITY);
		
		assertTrue(communityCenter.GetPatientNurseByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void IfNurseQueueIsGravity_AndThereIsAPatientInNurseQueue_WhenPatientWithGravitySevenCome_ThenPatientIsFirstInNurseQueue() {
		communityCenter = new CommunityCenter(TriageType.GRAVITY);
		
		communityCenter.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY);
		communityCenter.triagePatient(SECOND_PATIENT_NAME, GRAVITY_GREATER_THAN_FIVE);
		
		assertTrue(communityCenter.GetPatientNurseByNumberInQueue(0).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void WhenPatientComeWithGravityBelowMinimum_ThenPatientIsNotInQueue() {
		communityCenter.triagePatient(FIRST_PATIENT_NAME, GRAVITY_BELOW_MINIMUM);
		assertFalse(communityCenter.PatientIsInNurseQueue(FIRST_PATIENT_NAME));
	}

}
