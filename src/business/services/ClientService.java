package business.services;

import business.entities.Client;
import data_access.ClientDataAccessTXT;

import java.util.List;
import java.util.Objects;

public class ClientService {

    private final ClientDataAccessTXT clientDataAccessTXT;

    public ClientService(ClientDataAccessTXT clientDataAccessTXT) {
        this.clientDataAccessTXT = clientDataAccessTXT;
    }

    public List<Client> getClients() {
        List<Client> clients = clientDataAccessTXT.loadAllClients();
        clientDataAccessTXT.saveAllClients(clients);
        return clients;
    }
    public void addNewClient(Client newClient) {
        List<Client> clients = clientDataAccessTXT.loadAllClients();
        clients.add(newClient);
        clientDataAccessTXT.saveAllClients(clients);
    }

    public void removeExistingClient(String clientId) {
        List<Client> clients = clientDataAccessTXT.loadAllClients();
        int index = getClientIndex(clients, clientId);
        if (index != -1) { // if found
            clients.remove(index);
            clientDataAccessTXT.saveAllClients(clients);
        }
    }

    private int getClientIndex(List<Client> clients, String clientId) {
        for (int currentIndex = 0; currentIndex < clients.size(); currentIndex++) {
            Client currentClient = clients.get(currentIndex);
            if (!Objects.equals(currentClient.getClientId(), clientId)) {
                continue;
            }
            return currentIndex;
        }
        return -1;
    }

}
