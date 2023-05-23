package data_access;

import business.entities.Payment;

import java.util.List;

public interface PaymentDataAccess {
    public List<Payment> loadAllPayments();

    public void saveAllPayments (List<Payment> payments);
}
