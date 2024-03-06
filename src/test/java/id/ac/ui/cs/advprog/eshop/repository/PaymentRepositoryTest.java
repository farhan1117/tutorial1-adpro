package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Order> orders;
    List<Map<String, String>> paymentDataList;

    @BeforeEach
    void setUp(){
        paymentRepository = new PaymentRepository();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                products, 1708570000L, "Safira Sudrajat");
        orders.add(order2);
        Order order3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbf1e",
                products, 1708570000L, "Bambang Sudrajat");
        orders.add(order3);

        Map<String, String> voucherData = new HashMap<>();
        Map<String, String> cashOnDeliveryData = new HashMap<>();
        voucherData.put("voucherCode", "ESHOP1234ABC5678");
        cashOnDeliveryData.put("address", "Fasilkom");
        cashOnDeliveryData.put("deliveryFee", "10000");
        this.paymentDataList = new ArrayList<>();
        this.paymentDataList.add(voucherData);
        this.paymentDataList.add(cashOnDeliveryData);
    }
    @Test
    void testAddPayment() {
        Order order1 = orders.get(1);
        Order order2 = orders.get(2);

        this.paymentRepository.addPayment(order1, "voucherCode", this.paymentDataList.get(0));
        this.paymentRepository.addPayment(order2, "cashOnDelivery", this.paymentDataList.get(1));

        assertNotNull(paymentRepository);
        assertEquals("voucherCode", paymentRepository.getMethod());
    }


    @Test
    void testGetPaymentIfIdFound() {
        Order order = orders.get(1);

        Payment payment = paymentRepository.addPayment(order, "voucherCode", this.paymentDataList.get(0));
        Payment result = paymentRepository.getPayment(payment.getId());

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getMethod(), result.getMethod());
        assertEquals(payment.getPaymentData(), result.getPaymentData());
    }

    @Test
    void testGetPaymentIfIdNotFound() {
        Order order = orders.get(1);

        Payment payment = paymentRepository.addPayment(order, "voucherCode", this.paymentDataList.get(1));
        Payment result = paymentRepository.getPayment("zczc");

        assertNull(result);
    }

    @Test
    void testGetAllPayments() {
        Map<String, String> voucherCode = new HashMap<>();
        voucherCode.put("voucherCode", "ESHOP1234ABC5678");
        Map<String, String> cashOnDelivery = new HashMap<>();
        cashOnDelivery.put("address", "depok");
        cashOnDelivery.put("deliveryFee", "12000");
        Order order1 = orders.get(0);
        Order order2 = orders.get(1);

        paymentRepository.addPayment(order1, "voucherCode", voucherCode);
        paymentRepository.addPayment(order2, "cashOnDelivery", cashOnDelivery);

        List<Payment> allPayments = paymentRepository.getAllPayments();
        assertEquals(2, allPayments.size());
    }

    @Test
    void testGetAllPaymentsIfEmpty() {
        List<Payment> allPayments = paymentRepository.getAllPayments();
        assertEquals(0, allPayments.size());
    }

}
