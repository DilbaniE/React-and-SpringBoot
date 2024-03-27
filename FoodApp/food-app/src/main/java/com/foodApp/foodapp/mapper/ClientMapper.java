package com.foodApp.foodapp.mapper;

import com.foodApp.foodapp.DTO.ClientDTO;
import com.foodApp.foodapp.model.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientEntity mapDtoToEntity(ClientDTO clientDTO){
        return ClientEntity.builder()
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .document(clientDTO.getDocument())
                .phone(clientDTO.getPhone())
                .deliverAddress(clientDTO.getDeliverAddress())
                .isActive(clientDTO.getIsActive())
                .build();
    }

    public ClientDTO mapEntityToDto(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(clientEntity.getName());
        clientDTO.setEmail(clientEntity.getEmail());
        clientDTO.setDocument(clientEntity.getDocument());
        clientDTO.setPhone(clientEntity.getPhone());
        clientDTO.setDeliverAddress(clientEntity.getDeliverAddress());
        clientDTO.setIsActive(clientEntity.getIsActive());
        return clientDTO;
    }
}
