package com.kube.rodo.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kube.rodo.domain.Client;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


@RestController
public class ClientRestController {
    private List<Client> clients = new ArrayList(Arrays.asList(new Client("rodo", "1234", "Rodolfo"), new Client("ari", "1234", "Ariel"), new Client("giaco", "1234", "Giacomodonatto")));

    public ClientRestController() {
    }

    @GetMapping({"/clients"})
    public List<Client> getClients() {
        return clients;
    }

    @GetMapping({"/clients/{userName}"})
    public Client getClients(@PathVariable String userName) {
        return clients.stream().filter((client) -> client.getUsername().equalsIgnoreCase(userName)).findFirst().orElseThrow();
    }

    @PostMapping({"/clients"})
    public Client createClient(@RequestBody Client client) {
        clients.add(client);
        return client;
    }

    @PutMapping({"/clients"})
    public Client putClient(@RequestBody Client client) {
        Client clientFound = clients.stream().filter((cli) -> cli.getUsername().equalsIgnoreCase(client.getUsername())).findFirst().orElseThrow();
        clientFound.setPassword(client.getPassword());
        clientFound.setName(client.getName());
        return clientFound;
    }

    @DeleteMapping({"/clients/{username}"})
    public void deleteClient(@PathVariable String username) {
        Client clientFound = clients.stream().filter((cli) -> cli.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();
        clients.remove(clientFound);
    }
}
