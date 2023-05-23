package data_access;

import business.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDataAccessSQL implements PaymentDataAccess {
    public List<Payment> loadAllPayments(){
        System.out.println("loadAllPayments - dummy SQL implementation");
        //JDBC implementation
        return new ArrayList<>();
    }

    public void saveAllPayments(List<Payment> payments){
        System.out.println("saveAllPayments - dummy SQL implementation");
        //JDBC implementation
    }
}
