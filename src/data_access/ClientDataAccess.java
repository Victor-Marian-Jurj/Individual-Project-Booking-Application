package data_access;

import business.entities.Client;

import java.util.List;

public abstract class ClientDataAccess {
    public abstract List<Client> loadAllClients();


    public abstract void saveAllClients(List<Client> clients);
}
