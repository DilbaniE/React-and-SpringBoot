package com.foodApp.foodapp.controller;

import com.foodApp.foodapp.DTO.ClientDTO;
import com.foodApp.foodapp.endPoints.IClientEndPoint;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.foodApp.foodapp.service.ClientService;


@OpenAPIDefinition(
        info = @Info(
                title = "Food Delicios",
                version = "1.0",
                description = "Application the restaurant"
        )
)

@RestController
@RequestMapping(IClientEndPoint.CLIENT_BASE_URL)
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Operation(summary = "Create a client", description = "Add a new client to the system")
    @ApiResponse(responseCode = "201", description = "Client created")
    @PostMapping(IClientEndPoint.CLIENT_CREATE_URL)
    public ResponseEntity<ClientDTO> createClient(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Client to be added", required = true, content = @Content(schema = @Schema(implementation = ClientDTO.class)))  @RequestBody ClientDTO clientDto){
        System.out.println(19392932);

        ClientDTO clientResponse = clientService.createClient(clientDto);
        System.out.println(192);

        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a client", description = "Retrieve a client with document")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class)))
    @GetMapping(IClientEndPoint.CLIENT_GET_URL)
    public ResponseEntity<ClientDTO> getUser(@PathVariable("document") String document){
        return new ResponseEntity<>(clientService.findByDocument(document), HttpStatus.OK);
    }

    @Operation(summary = "Update a client", description = "Update information of a client")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class)))
    @PutMapping(IClientEndPoint.CLIENT_UPDATE_URL)
    public ResponseEntity<ClientDTO> update(@PathVariable("document") String document, @RequestBody ClientDTO clientDTO){
        ClientDTO updatedClientEntity = clientService.updateClient(document, clientDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Deactivate a client", description = "Deactivate the availability of a client")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class)))
    @PatchMapping(IClientEndPoint.CLIENT_DESACTIVATE_URL)
    public ResponseEntity<ClientDTO> desctivate(@PathVariable("document") String document){
        ClientDTO desactivatedclient = clientService.desactivateClient(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
