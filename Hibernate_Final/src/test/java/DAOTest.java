import com.fpt.fsa.dao.ComputerDAO;
import com.fpt.fsa.dao.ManufacturerDAO;
import com.fpt.fsa.fa.training.entities.Computer;
import com.fpt.fsa.fa.training.entities.Manufacturer;
import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {
    private static ManufacturerDAO manufacturerDAO;
    private static ComputerDAO computerDAO;

    @BeforeAll
    public static void setup() {
        HibernateUntils.getSessionFactory();
        manufacturerDAO = new ManufacturerDAO();
        computerDAO = new ComputerDAO();
    }

    @BeforeEach
    public void beforeEachTest() {
        // Clear the database before each test
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Computer").executeUpdate();
            session.createQuery("DELETE FROM Manufacturer").executeUpdate();
            transaction.commit();
        }
    }

    @Test
    public void testCreateManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setShortName("ABC");
        manufacturer.setFullName("ABC Manufacturing");
        manufacturer.setContact("123456789");

        manufacturerDAO.create(manufacturer);
        Manufacturer found = manufacturerDAO.find(manufacturer.getManufactureId());

        assertNotNull(found);
        assertEquals("ABC", found.getShortName());
        assertEquals("ABC Manufacturing", found.getFullName());
        assertEquals("123456789", found.getContact());
    }

    @Test
    public void testSaveManufacturerWithComputers() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setShortName("XYZ");
        manufacturer.setFullName("XYZ Manufacturing");
        manufacturer.setContact("987654321");
        Date validDate = new Date(System.currentTimeMillis() + 1000L);

        Computer computer1 = new Computer();
        computer1.setComputerName("Laptop A");
        computer1.setRegistrationDate(validDate);
        computer1.setPrice(1000.0);
        computer1.setDescription("Highest performance");
        computer1.setModel("A123");
        computer1.setProduceStatus(1);
        computer1.setRemark("Production");

        Computer computer2 = new Computer();
        computer2.setComputerName("Laptop B");
        computer2.setRegistrationDate(validDate);
        computer2.setPrice(800.0);
        computer2.setDescription("Cheap");
        computer2.setModel("B123");
        computer2.setProduceStatus(1);
        computer2.setRemark("Production");

        Set<Computer> computers = new HashSet<>();
        computers.add(computer1);
        computers.add(computer2);

        manufacturer.setListComputers(computers);

        manufacturerDAO.create(manufacturer);

        computer1.setDoctor(manufacturer);
        computer2.setDoctor(manufacturer);

        computerDAO.create(computer1);
        computerDAO.create(computer2);

        Manufacturer found = manufacturerDAO.find(manufacturer.getManufactureId());
        assertNotNull(found);
        assertEquals(2, found.getListComputers().size());
    }


    @Test
    public void testBusinessRuleRegistrationDate() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setShortName("DEF");
        manufacturer.setFullName("DEF Manufacturing");
        manufacturer.setContact("123123123");

        Computer computer = new Computer();
        computer.setComputerName("Laptop C");
        computer.setRegistrationDate(new Date(System.currentTimeMillis() - 100000000L));
        computer.setPrice(500.0);
        computer.setDescription("Old");
        computer.setModel("C123");
        computer.setProduceStatus(1);
        computer.setRemark("Production");

        manufacturerDAO.create(manufacturer);
        computer.setDoctor(manufacturer);

        Exception exception = assertThrows(Exception.class, () -> computerDAO.create(computer));
        assertEquals("Registration date must be in the present or in the future", exception.getMessage());
    }

    @Test
    public void testBusinessRulePrice() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setShortName("GHI");
        manufacturer.setFullName("GHI Manufacturing");
        manufacturer.setContact("321321321");

        Computer computer = new Computer();
        computer.setComputerName("Laptop D");
        computer.setRegistrationDate(new Date(System.currentTimeMillis() + 100000000L));
        computer.setPrice(-1000.0);
        computer.setDescription("Save energy");
        computer.setModel("D123");
        computer.setProduceStatus(1);
        computer.setRemark("Production");

        manufacturerDAO.create(manufacturer);
        computer.setDoctor(manufacturer);

        Exception exception = assertThrows(Exception.class, () -> computerDAO.create(computer));
        assertEquals("Price must be greater than or equal to 0", exception.getMessage());
    }

    @Test
    public void testBusinessRuleProduceStatus() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setShortName("JKL");
        manufacturer.setFullName("JKL Manufacturing");
        manufacturer.setContact("987987987");

        Computer computer = new Computer();
        computer.setComputerName("Laptop E");
        computer.setRegistrationDate(new Date(System.currentTimeMillis() + 100000000L));
        computer.setPrice(1200.0);
        computer.setDescription("For GenZ");
        computer.setModel("E123");
        computer.setProduceStatus(2);
        computer.setRemark("Production");

        manufacturerDAO.create(manufacturer);
        computer.setDoctor(manufacturer);

        Exception exception = assertThrows(Exception.class, () -> computerDAO.create(computer));
        assertEquals("Produce status must be 0 or 1", exception.getMessage());
    }
}
