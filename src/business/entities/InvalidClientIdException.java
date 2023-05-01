package business.entities;

public class InvalidClientIdException extends Exception {

    private final String clientId;

    public InvalidClientIdException(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }
}
