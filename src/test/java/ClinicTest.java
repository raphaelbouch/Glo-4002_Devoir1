import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClinicTest {
	
	private static final String FIRST_PATIENT_NAME = "John";
	private static final int UNSPECIFIED_GRAVITY = 3;
	private static final String SECOND_PATIENT_NAME = "Luke";
	private static final int GRAVITY_GREATER_THAN_FIVE = 7;
	private static final int GRAVITY_BELOW_MINIMUM = 1;
	public Clinic clinic;
	
	@Before
	public void setup() {
		clinic = new Clinic();
	}

	@Test
	public void WhenOpening_MedecinQueueIsEmpty() {
		assertNull(clinic.GetPatientMedecinByNumberInQueue(0));
	}
	
	@Test
	public void WhenOpening_RadiologyQueueIsEmpty() {
		assertNull(clinic.GetPatientRadiologyByNumberInQueue(0));
	}
	
	@Test
	public void WhenPatientComeWithMigraine_ThenHeIsFirstInMedecinQueue_AndNotInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.MIGRAINE);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
		assertFalse(clinic.PatientIsInRadiologyQueue(FIRST_PATIENT_NAME));
		
	}
	
	@Test
	public void IfThereIsAPatientInMedecinQueue_WhenPatientComeWithFlu_ThenHeIsSecondInMedecinQueue_AndNotInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.MIGRAINE);
		clinic.triagePatient(SECOND_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.FLU);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
		assertFalse(clinic.PatientIsInRadiologyQueue(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void WhenPatientComeWithSprain_ThenHeIsFirstInMedecinQueue_AndHeIsFirstInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.SPRAIN);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
		assertTrue(clinic.GetPatientRadiologyByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
	}
	
	@Test
	public void IfThereIsPatientInMedecinAndRadiologyQueue_WhenPatientComeWithBrokenBone_ThenIsSecondInMedecinAndRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.SPRAIN);
		clinic.triagePatient(SECOND_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.BROKEN_BONE);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
		assertTrue(clinic.GetPatientRadiologyByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void IfMedecinQueueIsGravity_AndThereIsAPatientInMedecinQueue_WhenPatientWithFluGravitySevenCome_ThenPatientIsFirstInMedecinQueue() {
		clinic = new Clinic(TriageType.GRAVITY,TriageType.FIFO);
		
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.MIGRAINE);
		clinic.triagePatient(SECOND_PATIENT_NAME, GRAVITY_GREATER_THAN_FIVE, VisibleSymptom.FLU);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(0).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void IfMedecinQueueIsGravity_WhileThereIsPatientInMedecinQueueAndRadiologyQueue_WhenPatientWithBrokenBoneGravitySeven_ThenHeIsSecondInRadiology() {
		clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
		
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.SPRAIN);
		clinic.triagePatient(SECOND_PATIENT_NAME, GRAVITY_GREATER_THAN_FIVE, VisibleSymptom.BROKEN_BONE);
		
		assertTrue(clinic.GetPatientRadiologyByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void IfBothQueueIsGravity_WhileThereIsPatientInBothQueue_WhenPatientWithSprainWithGravitySeven_ThenHeIsFirstInBothQueue() {
		clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);
		
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.SPRAIN);
		clinic.triagePatient(SECOND_PATIENT_NAME, GRAVITY_GREATER_THAN_FIVE, VisibleSymptom.BROKEN_BONE);
		
		assertTrue(clinic.GetPatientMedecinByNumberInQueue(0).equals(SECOND_PATIENT_NAME));
		assertTrue(clinic.GetPatientRadiologyByNumberInQueue(0).equals(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void WhenPatientComeWithColdGravityBelowMinimum_ThenPatientIsNotInMedecinQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, GRAVITY_BELOW_MINIMUM, VisibleSymptom.COLD);
		assertFalse(clinic.PatientIsInMedecinQueue(FIRST_PATIENT_NAME));
	}
	
	@Test
	public void WhenPatientComeWithSprainGravityBelowMinimum_ThenPatientIsNotInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, GRAVITY_BELOW_MINIMUM, VisibleSymptom.SPRAIN);
		assertFalse(clinic.PatientIsInRadiologyQueue(FIRST_PATIENT_NAME));
	}
}
