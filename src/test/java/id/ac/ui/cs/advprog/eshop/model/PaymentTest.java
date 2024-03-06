package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private List<Product> products;
    private Map<String, String> paymentData = new HashMap<>();


    @BeforeEach
    void setUp(){
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testAddPayment(){
        Payment payment = new Payment("12345678", "voucherCode", paymentData);
        assertEquals("12345678", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals(paymentData.get("voucherCode"), payment.getPaymentData().get("voucherCode"));
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testAddPaymentInvalidMethod(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new  Payment("12345678", "debitCode", paymentData);
        });
    }

    @Test
    void testAddPaymentInvalidVoucherCode(){
        paymentData.put("voucherCode", "1234abc567");
        Payment payment = new Payment("1234abc5678", "voucherCode", paymentData);
        assertNotEquals(PaymentStatus.SUCCESS.getValue(), payment);
    }

    @Test
    void testSetStatusToRejected(){
        Payment payment = new Payment("12345678", "voucherCode", paymentData);
        payment.setStatus("REJECTED");
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("12345678", "voucherCode", paymentData);
            payment.setStatus("MEOW");
        });
    }

}
