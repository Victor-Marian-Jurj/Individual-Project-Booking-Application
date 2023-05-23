package business.services;

import business.entities.Payment;
import data_access.PaymentDataAccess;


import java.util.List;
import java.util.Objects;

public class PaymentService {
    private final PaymentDataAccess paymentDataAccess;

    public PaymentService(PaymentDataAccess paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }

    public List<Payment> getPayments() {
        List<Payment> payments = paymentDataAccess.loadAllPayments();
        payments.sort(new PaymentComparator());
        return payments;
    }

    public void addNewPayment(Payment newPayment) {
        List<Payment> payments = paymentDataAccess.loadAllPayments();
        payments.add(newPayment);
        paymentDataAccess.saveAllPayments(payments);
    }

    public void removeExistingPayment(String paymentId) {
        List<Payment> payments = paymentDataAccess.loadAllPayments();
        int index = getPaymentIndex(payments, paymentId);
        if (index != -1) { // if found
            payments.remove(index);
            paymentDataAccess.saveAllPayments(payments);
        }
    }

    private int getPaymentIndex(List<Payment> payments, String paymentId) {
        for (int currentIndex = 0; currentIndex < payments.size(); currentIndex++) {
            Payment currentHotel = payments.get(currentIndex);
            if (!Objects.equals(currentHotel.getPaymentId(), paymentId)) {
                continue;
            }
            return currentIndex;
        }
        return -1;
    }
}
