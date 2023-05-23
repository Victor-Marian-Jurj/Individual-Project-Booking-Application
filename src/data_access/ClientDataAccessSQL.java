package data_access;

import business.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDataAccessSQL implements ClientDataAccess{

    public List<Client> loadAllClients() {
        System.out.println("loadAllClients - dummy SQL implementation");
        //JDBC implementation
      return new ArrayList<>();
    }

    public void saveAllClients(List<Client> clients) {
        System.out.println("saveAllClients - dummy SQL implementation");
        //JDBC implementation

    }
}
