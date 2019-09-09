import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClinicTest {
	
	private static final String FIRST_PATIENT_NAME = "John";
	private static final int UNSPECIFIED_GRAVITY = 0;
	private static final String SECOND_PATIENT_NAME = "Luke";
	public Clinic clinic;
	
	@Before
	public void setup() {
		clinic = new Clinic();
	}

	@Test
	public void WhenPatientComeWithMigraine_ThenHeIsFirstInMedecinQueue_AndNotInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.MIGRAINE);
		
		assertTrue(clinic.GetPatientMededcinByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
		assertFalse(clinic.PatientIsInRadiologyQueue(FIRST_PATIENT_NAME));
		
	}
	
	@Test
	public void IfThereIsAPatientInMedecinQueue_WhenPatientComeWithFlu_ThenHeIsSecondInMedecinQueue_AndNotInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.MIGRAINE);
		clinic.triagePatient(SECOND_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.FLU);
		
		assertTrue(clinic.GetPatientMededcinByNumberInQueue(1).equals(SECOND_PATIENT_NAME));
		assertFalse(clinic.PatientIsInRadiologyQueue(SECOND_PATIENT_NAME));
	}
	
	@Test
	public void WhenPatientComeWithSprain_ThenHeIsFirstInMedecinQueue_AndHeIsFirstInRadiologyQueue() {
		clinic.triagePatient(FIRST_PATIENT_NAME, UNSPECIFIED_GRAVITY, VisibleSymptom.SPRAIN);
		
		assertTrue(clinic.GetPatientMededcinByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
		assertTrue(clinic.GetPatientRadiologyByNumberInQueue(0).equals(FIRST_PATIENT_NAME));
	}

}
