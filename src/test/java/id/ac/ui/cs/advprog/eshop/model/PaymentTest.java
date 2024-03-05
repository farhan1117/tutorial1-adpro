package id.ac.ui.cs.advprog.eshop.model;

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
    void testCreatePayment(){
        Payment payment = new Payment("12345678", "voucherCode", "SUCCESS", paymentData);
        assertEquals("12345678", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidMethod(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new  Payment("12345678", "voucherCode", "MEOW", paymentData);
        });
    }

    @Test
    void testSetStatusToRejected(){
        Payment payment = new Payment("12345678", "voucherCode", "SUCCESS", paymentData);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetStatusToRejected(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new  Payment("12345678", "voucherCode", "MEOW", paymentData);
        });
    }

}
