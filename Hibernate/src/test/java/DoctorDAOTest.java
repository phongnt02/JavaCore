import com.fpt.fsa.dao.DoctorDAO;
import com.fpt.fsa.entity.Doctor;

import java.util.List;

public class DoctorDAOTest {

    public static void main(String[] args) {
        // Test CRUD operations for DoctorDAO
        DoctorDAO doctorDAO = new DoctorDAO();

        // Create a new Doctor
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Smith");
        // Set other attributes
        // ...

        doctorDAO.create(doctor);
        System.out.println("Doctor created with ID: " + doctor.getDocNumber());

        // Read Doctor by ID
        Doctor retrievedDoctor = doctorDAO.find(doctor.getDocNumber());
        System.out.println("Retrieved Doctor: " + retrievedDoctor);

        // Update Doctor
        retrievedDoctor.setFirstName("Jane");
        doctorDAO.update(retrievedDoctor);
        System.out.println("Doctor updated: " + retrievedDoctor);

        // Delete Doctor
        doctorDAO.delete(retrievedDoctor.getDocNumber());
        System.out.println("Doctor deleted successfully.");

        // Test findAll method
        List<Doctor> doctors = doctorDAO.findAll();
        System.out.println("All Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }
}
