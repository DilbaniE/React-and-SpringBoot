package com.foodapp.foodapp.controller;

import com.foodapp.foodapp.DTO.ClientDTO;
import com.foodapp.foodapp.endPoinst.IClientEndPoint;
import com.foodapp.foodapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IClientEndPoint.CLIENT_BASE_URL)
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(IClientEndPoint.CLIENT_CREATE_URL)
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        ClientDTO clientResponse = clientService.createClient(clientDTO);
        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }

    @GetMapping(IClientEndPoint.CLIENT_GET_URL)
    public ResponseEntity<ClientDTO> getUser(@PathVariable("document") String document){
        return new ResponseEntity<>(clientService.findByDocument(document), HttpStatus.OK);
    }

    @PutMapping(IClientEndPoint.CLIENT_UPDATE_URL)
    public ResponseEntity<ClientDTO> update(@PathVariable("document") String document, @RequestBody ClientDTO clientDTO){
        ClientDTO updatedClientEntity = clientService.updateClient(document , clientDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(IClientEndPoint.CLIENT_DESACTIVATE_URL)
    public ResponseEntity<ClientDTO> desactivate(@PathVariable("document") String document){
        ClientDTO desactivatedclient = clientService.desactivateClient(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
