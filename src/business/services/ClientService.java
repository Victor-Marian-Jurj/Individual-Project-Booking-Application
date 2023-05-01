package business.services;

import business.entities.Client;
import data_access.ClientDataAccess;

import java.util.List;
import java.util.Objects;

public class ClientService {

    private final ClientDataAccess clientDataAccess;

    public ClientService(ClientDataAccess clientDataAccess) {
        this.clientDataAccess = clientDataAccess;
    }

    public List<Client> getClients() {
        List<Client> clients = clientDataAccess.loadAllClients();
        clientDataAccess.saveAllClients(clients);
        return clients;
    }
    public void addNewClient(Client newClient) {
        List<Client> clients = clientDataAccess.loadAllClients();
        clients.add(newClient);
        clientDataAccess.saveAllClients(clients);
    }

    public void removeExistingClient(String clientId) {
        List<Client> clients = clientDataAccess.loadAllClients();
        int index = getClientIndex(clients, clientId);
        if (index != -1) { // if found
            clients.remove(index);
            clientDataAccess.saveAllClients(clients);
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
