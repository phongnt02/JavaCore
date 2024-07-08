import com.fpt.fsa.dao.PatientDAO;
import com.fpt.fsa.entity.Patient;
import org.junit.jupiter.api.*;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientDAOTest {
    private PatientDAO patientDAO;

    @BeforeAll
    public void setup() {
        patientDAO = new PatientDAO();
    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstname("Test");
        patient.setLastname("Patient");
        patientDAO.create(patient);

        Patient retrievedPatient = patientDAO.find(patient.getPatId());
        Assertions.assertNotNull(retrievedPatient);
        Assertions.assertEquals("Test", retrievedPatient.getFirstname());
        Assertions.assertEquals("Patient", retrievedPatient.getLastname());
    }

    @Test
    public void testGetPagedPatients() {
        List<Patient> patients = patientDAO.getPatientsPaging(0, 10);
        Assertions.assertNotNull(patients);
        Assertions.assertTrue(patients.size() <= 10);
    }
}
