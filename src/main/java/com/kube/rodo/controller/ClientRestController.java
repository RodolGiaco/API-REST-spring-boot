package com.kube.rodo.controller;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kube.rodo.domain.Client;
import com.kube.rodo.exceptions.BadRequestException;
import com.kube.rodo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


@RestController
@RequestMapping("/clients")
public class ClientRestController {
    private List<Client> clients = new ArrayList(Arrays.asList(
            new Client("rodo", "1234", "Rodolfo"),
            new Client("ari", "1234", "Ariel"),
            new Client("giaco", "1234", "Giacomodonatto")));

    public ClientRestController() {
    }

    @GetMapping
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getClients(@PathVariable String userName) {

        if(userName.length() != 3){
            throw new BadRequestException("El parametro de usuario debe contener 3 caracteres");
        }
        return clients.stream().
                filter(client -> client.getUsername().equalsIgnoreCase(userName)).
                findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente " + userName + " no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        clients.add(client);
        // Obteniendo URL de servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(client.getUsername())
                .toUri();
        return ResponseEntity.created(location).body(client);
    }

    @PutMapping
    public ResponseEntity<?>  putClient(@RequestBody Client client) {
        Client clientFound = clients.stream().filter((cli) -> cli.getUsername().equalsIgnoreCase(client.getUsername())).findFirst().orElseThrow();
        clientFound.setPassword(client.getPassword());
        clientFound.setName(client.getName());
        return ResponseEntity.ok(clientFound);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteClient(@PathVariable String username) {
        Client clientFound = clients.stream().filter((cli) -> cli.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();
        clients.remove(clientFound);
        return ResponseEntity.noContent().build();
    }
}
