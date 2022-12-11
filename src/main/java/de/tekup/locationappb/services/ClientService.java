package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;


    public void deleteClient(int clientId){
        Client client = getClient(clientId);

        clientRepository.delete(client);
    }

    public Client updateClient(Client client){
        Client client1 = getClient(client.getId()); // jebet mel bdd client en parameteer
        client1.setCin(client.getCin());
        client1.setFirstName(client.getFirstName());
        client1.setLastName(client.getLastName());
        client1.setEmail(client.getEmail());
        client1.setPhoneNumber(client.getPhoneNumber());

        return clientRepository.save(client1);
    }


    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(int id){
        return clientRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Client ID not Found"));
    }



}
