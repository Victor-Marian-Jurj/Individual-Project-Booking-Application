package business.services;

import business.entities.Payment;
import java.util.Comparator;

public class PaymentComparator implements Comparator<Payment> {

    @Override
    public int compare(Payment firstPayment, Payment secondPayment) {
        if(firstPayment.getRoomPrice() < secondPayment.getRoomPrice()) {
            return -1;
        }
        if (firstPayment.getRoomPrice() == secondPayment.getRoomPrice()) {
            String ssn1 = String.valueOf(firstPayment.getNumberOfNights());
            String ssn2 = String.valueOf(secondPayment.getNumberOfNights());
            return  ssn1.compareTo(ssn2);
        }
        return 1;
    }
}
