import com.fpt.fsa.dao.DoctorDAO;
import com.fpt.fsa.entity.Appointment;
import com.fpt.fsa.entity.Doctor;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoctorDAOTest {
    private DoctorDAO doctorDAO;

    @BeforeAll
    public void setup() {
        doctorDAO = new DoctorDAO();
    }

    @Test
    public void testCreateDoctorWithAppointments() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Doe");

        List<Appointment> appointments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Appointment appointment = new Appointment();
            appointment.setDate(new Date());
            appointment.setTime(new Date());
            appointment.setDuration(30);
            appointment.setReason("Checkup");
            appointments.add(appointment);
        }

        doctorDAO.createDoctorWithAppointments(doctor, appointments);

        Doctor retrievedDoctor = doctorDAO.find(doctor.getDocNumber());
        Assertions.assertNotNull(retrievedDoctor);
        Assertions.assertEquals("John", retrievedDoctor.getFirstName());
        Assertions.assertEquals("Doe", retrievedDoctor.getLastName());
    }
}
