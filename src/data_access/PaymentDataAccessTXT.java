package data_access;


import business.entities.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDataAccessTXT implements PaymentDataAccess{
    @Override
    public List<Payment> loadAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/payments.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Payment currentPayment = readPayment(bufferedReader);
                payments.add(currentPayment);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return payments;
    }

    @Override
    public void saveAllPayments(List<Payment> payments) {
        try (FileWriter fileWriter = new FileWriter("resources/payments.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Payment currentPayment : payments) {
                writePayment(printWriter, currentPayment);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Payment readPayment(BufferedReader bufferedReader) throws IOException {
        String paymentId = bufferedReader.readLine();
        String clientId = bufferedReader.readLine();
        String reservationId = bufferedReader.readLine();
        int roomPrice = Integer.parseInt(bufferedReader.readLine());
        int numberOfNights = Integer.parseInt(bufferedReader.readLine());
        int total = Integer.parseInt(bufferedReader.readLine());
        String paymentStatus = bufferedReader.readLine();

        return new Payment(paymentId, clientId, reservationId, roomPrice, numberOfNights, total, paymentStatus);
    }

    private void writePayment(PrintWriter printWriter, Payment payment) {
        printWriter.println("+++");
        printWriter.println(payment.getPaymentId());
        printWriter.println(payment.getClientId());
        printWriter.println(payment.getReservationId());
        printWriter.println(payment.getRoomPrice());
        printWriter.println(payment.getNumberOfNights());
        printWriter.println(payment.getTotal());
        printWriter.println(payment.getPaymentStatus());

    }
}
