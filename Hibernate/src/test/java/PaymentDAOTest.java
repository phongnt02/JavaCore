import com.fpt.fsa.dao.BillDAO;
import com.fpt.fsa.dao.PaymentDAO;
import com.fpt.fsa.entity.Bill;
import com.fpt.fsa.entity.Payment;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaymentDAOTest {
    private PaymentDAO paymentDAO;
    private BillDAO billDAO;
    private Bill testBill;

    @BeforeAll
    public void setup() {
        paymentDAO = new PaymentDAO();
        billDAO = new BillDAO();

        testBill = new Bill();
        testBill.setDate(new Date());
        testBill.setStatus("Pending");
        billDAO.create(testBill);
    }

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setMethod("Cash");
        payment.setBill(testBill);
        paymentDAO.create(payment);

        Payment retrievedPayment = paymentDAO.find(payment.getReceiptnum());
        Assertions.assertNotNull(retrievedPayment);
        Assertions.assertEquals(100.0, retrievedPayment.getAmount());
        Assertions.assertEquals("Cash", retrievedPayment.getMethod());
    }

    @Test
    public void testFindByBill() {
        List<Payment> payments = paymentDAO.findByBill(testBill.getBillNumber());
        Assertions.assertNotNull(payments);
    }
}
