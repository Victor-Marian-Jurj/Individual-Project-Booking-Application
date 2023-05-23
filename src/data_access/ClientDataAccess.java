package data_access;

import business.entities.Client;

import java.util.List;

public interface ClientDataAccess {
    List<Client> loadAllClients();


    void saveAllClients(List<Client> clients);
}
