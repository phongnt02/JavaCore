import com.fpt.fsa.dao.BillDAO;
import com.fpt.fsa.entity.Bill;
import org.junit.jupiter.api.*;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BillDAOTest {
    private BillDAO billDAO;

    @BeforeAll
    public void setup() {
        billDAO = new BillDAO();
    }

    @Test
    public void testCreateBill() {
        Bill bill = new Bill();
        bill.setDate(new Date());
        bill.setStatus("Pending");
        billDAO.create(bill);

        Bill retrievedBill = billDAO.find(bill.getBillNumber());
        Assertions.assertNotNull(retrievedBill);
        Assertions.assertEquals("Pending", retrievedBill.getStatus());
    }

    @Test
    public void testGetPagedBills() {
        List<Bill> bills = billDAO.getPagedBills(0, 10);
        Assertions.assertNotNull(bills);
        Assertions.assertTrue(bills.size() <= 10);
    }

    @Test
    public void testFindByBillDate() {
        Date billDate = new Date();
        List<Bill> bills = billDAO.findByBillDate(billDate);
        Assertions.assertNotNull(bills);
    }
}
