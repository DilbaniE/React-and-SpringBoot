package com.foodapp.foodapp.validation;

import com.foodapp.foodapp.exception.clientExcept.*;
import com.foodapp.foodapp.model.ClientEntity;

import java.util.Optional;

public class ClientValidation {
    public static void documentValidation(String documentClient){
        if (documentClient.length() < 8) {
            throw new ClientDocumentFormatException("The document has an incorrect format");
        }
    }

    public static void clientEmptyValidation(Optional<ClientEntity> client, String documentClient){
        if (client.isEmpty()) {
            throw new ClientNotFoundException("The User with document " + documentClient + " doesn't exist");
        }
    }

    public static void clientPresentValidation(Optional<ClientEntity> client, String documentClient){
        if (client.isPresent()) {
            throw new ClientDocumentExistException(String.format("The client with document %s already exist", documentClient));
        }
    }

    public static void clientTotalValidation(ClientEntity clientEntity){
        if(clientEntity.getDocument().length() < 6)
            throw new ClientDocumentFormatException("The document has an incorrect format");
        if(clientEntity.getEmail().length() < 6)
            throw new ClientAttributeFormatException(String.format("The email %s has an incorrect format", clientEntity.getEmail()));
        if(clientEntity.getPhone().length() < 6)
            throw new ClientAttributeFormatException(String.format("The phone %s has an incorrect format", clientEntity.getPhone()));
        if(clientEntity.getDeliverAddress().length() < 6)
            throw new ClientAttributeFormatException(String.format("The delivery address %s has an incorrect format", clientEntity.getDeliverAddress()));
    }

    public static void clientEqualValidation(ClientEntity oldClientEntity, ClientEntity newClientEntity){
        if (oldClientEntity.getDocument().equals(newClientEntity.getDocument()) &&
                oldClientEntity.getName().equals(newClientEntity.getName()) &&
                oldClientEntity.getEmail().equals(newClientEntity.getEmail()) &&
                oldClientEntity.getDeliverAddress().equals(newClientEntity.getDeliverAddress()) &&
                oldClientEntity.getPhone().equals(newClientEntity.getPhone())
        ) {
            throw new ClientEqualException("The request failed because the client is equal, it doesn't have different values");
        }
    }

}
