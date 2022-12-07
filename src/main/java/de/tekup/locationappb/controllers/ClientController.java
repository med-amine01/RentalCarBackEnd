package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.repositories.CarRepository;
import de.tekup.locationappb.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ClientController {

    private ClientService clientService;
    private final CarRepository carRepository;

    @DeleteMapping("/deleteclient/{id}")
    public boolean deleteClient(@PathVariable int id){
        Client client = clientService.getClient(id);
        if(client != null){
            clientService.deleteClient(client.getId());
            return true;
        }
        return false;
    }

    @PatchMapping("/updateclient")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @PostMapping("/addclient")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("/allclients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}
