package business.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Client {
    private String clientId;
    private String firstName;
    private String lastName;

    private String phoneNumber;

    private String emailAdress;

    private LocalDate birthDay;

    public Client(String clientId, String firstName, String lastName, String phoneNumber, String emailAdress, LocalDate birthDay) throws InvalidClientIdException {
        validateClientId(clientId);
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.birthDay = birthDay;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(emailAdress, client.emailAdress) && Objects.equals(birthDay, client.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, phoneNumber, emailAdress, birthDay);
    }

    @Override
    public String toString() {
        return "Client {" +
                "clientId='" + clientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    private void validateClientId(String clientId) throws InvalidClientIdException {
        if(!isValidClientId(clientId)) {
            throw new InvalidClientIdException((clientId));
        }
    }

    private boolean isValidClientId(String clientId) {
        return clientId.length() == 5;
    }
}
