package Controllers;

import models.ClientRepo;

public class ClientController {

    public boolean addClient(ClientRepo client) {
        return client.insertClient();
    }

    public boolean deleteClient(String clientId) {
        return ClientRepo.deleteClient(clientId);
    }
}
