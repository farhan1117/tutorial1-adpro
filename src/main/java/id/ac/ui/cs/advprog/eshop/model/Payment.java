package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;

        if (Arrays.asList("voucherCode", "cashOnDelivery").contains(method)) {
            if (method.equals("voucherCode")) {
                String voucherCode = paymentData.get("voucherCode");
                if (voucherCode != null && voucherCode.length() == 16 && voucherCode.startsWith("ESHOP")) {
                    int numericalCount = 0;
                    for (int i = 5; i < voucherCode.length(); i++) {
                        if (Character.isDigit(voucherCode.charAt(i))) {
                            numericalCount++;
                        }
                    }
                    if (numericalCount == 8) {
                        this.status = PaymentStatus.SUCCESS.getValue();
                    } else {
                        this.status = PaymentStatus.REJECTED.getValue();
                    }
                } else {
                    this.status = PaymentStatus.REJECTED.getValue();
                }
            } else { // cashOnDelivery method
                String address = paymentData.get("address");
                String deliveryFee = paymentData.get("deliveryFee");

                if (address == null || address.isEmpty() || deliveryFee == null || deliveryFee.isEmpty()) {
                    this.status = PaymentStatus.REJECTED.getValue();
                } else {
                    setStatus(status);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setStatus(String status){
        if (PaymentStatus.contains(status)){
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
