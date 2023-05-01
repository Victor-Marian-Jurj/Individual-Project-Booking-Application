package data_access;

import business.entities.Client;
import business.entities.InvalidClientIdException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalQueries.localDate;

public class ClientDataAccess {

    public List<Client> loadAllClients() {
        List<Client> clients = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/clients.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
//                Client currentClient = readClient(bufferedReader);
//                clients.add(currentClient);
                try {
                    Client currentClient = readClient(bufferedReader);
                    clients.add(currentClient);
                } catch (InvalidClientIdException exception) {
                    //ignore
            }
                currentLine = bufferedReader.readLine();
        }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return clients;
    }

    public void saveAllClients(List<Client> clients) {
        try (FileWriter fileWriter = new FileWriter("resources/clients.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Client currentClient : clients) {
                writeClient(printWriter, currentClient);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Client readClient(BufferedReader bufferedReader) throws IOException, InvalidClientIdException {
        String clientId = bufferedReader.readLine();
        String firstName = bufferedReader.readLine();
        String lastName = bufferedReader.readLine();
        String phoneNumber = bufferedReader.readLine();
        String emailAdress = bufferedReader.readLine();
        LocalDate birthDay = LocalDate.parse(bufferedReader.readLine());

        return new Client(clientId, firstName, lastName, phoneNumber, emailAdress, birthDay);

//        LocalDate birthDay = readLocalDate(bufferedReader);

    }

//    private LocalDate readLocalDate(BufferedReader bufferedReader) throws IOException {
//        int year = Integer.parseInt(bufferedReader.readLine());
//        int month = Integer.parseInt(bufferedReader.readLine());
//        int dayOfMonth = Integer.parseInt(bufferedReader.readLine());
//        return LocalDate.of(year, month, dayOfMonth);
//    }


    private void writeClient(PrintWriter printWriter, Client client) {
        printWriter.println("+++");
        printWriter.println(client.getClientId());
        printWriter.println(client.getFirstName());
        printWriter.println(client.getLastName());
        printWriter.println(client.getPhoneNumber());
        printWriter.println(client.getEmailAdress());
        printWriter.println(client.getBirthDay());

//        printWriter.println(client.getBirthDay().getYear());
//        printWriter.println(client.getBirthDay().getMonthValue());
//        printWriter.println(client.getBirthDay().getDayOfMonth());

    }
}

