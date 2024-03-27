package com.foodApp.foodapp.service;

import com.foodApp.foodapp.DTO.ClientDTO;
import com.foodApp.foodapp.mapper.ClientMapper;
import com.foodApp.foodapp.model.ClientEntity;
import com.foodApp.foodapp.validation.ClientValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodApp.foodapp.repository.IClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private  ClientMapper clientMapper;

    public ClientDTO findByDocument(String document){
        ClientValidation.documentValidation(document);
        Optional<ClientEntity> result = this.clientRepository.findByDocument(document);
        ClientValidation.clientEmptyValidation(result, document);

        ClientEntity clientEntity = result.get();
        return clientMapper.mapEntityToDto(clientEntity);


    }

/*
    public List<ClientEntity> getClients(String orderBy, String direction) {

        if ("NAME".equals(orderBy)) {
            if ("ASC".equals(direction)) {
                return clientRepository.findAllByOrderByNameAsc();
            } else {
                return clientRepository.findAllByOrderByNameDesc();
            }
        }
        else if ("ADDRESS".equals(orderBy)) {
            if ("ASC".equals(direction)) {
                return clientRepository.findAllByOrderByDeliveryAddressAsc();
            } else {
                return clientRepository.findAllByOrderByDeliveryAddressDesc();
            }
        }
        else {
            if ("ASC".equals(direction)) {
                return clientRepository.findAllByOrderByDocumentAsc();
            } else {
                return clientRepository.findAllByOrderByDocumentDesc();
            }
        }
    }*/

    public ClientDTO createClient(ClientDTO clientDTO) {
        System.out.println(1);

        ClientEntity clientEntity = clientMapper.mapDtoToEntity(clientDTO);
        System.out.println(12392390);
        System.out.println(clientEntity);
        ClientValidation.clientTotalValidation(clientEntity);
        System.out.println(123);

        Optional<ClientEntity> find = this.clientRepository.findByDocument(clientDTO.getDocument());
        ClientValidation.clientPresentValidation(find, clientDTO.getDocument());
        System.out.println(1422242);

        return clientMapper.mapEntityToDto(clientRepository.save(clientEntity));

    }

    public ClientDTO updateClient(String document, ClientDTO clientDto) {
        //objeto de client option
        System.out.println(12323);

        Optional<ClientEntity> result = this.clientRepository.findByDocument(document);
        ClientValidation.clientEmptyValidation(result, document);
        System.out.println(4343434);
        ClientValidation.clientEqualValidation(result.get(), clientMapper.mapDtoToEntity(clientDto));
        ClientValidation.clientTotalValidation(clientMapper.mapDtoToEntity(clientDto));
        System.out.println(1.1);

        ClientEntity clientEntity = clientMapper.mapDtoToEntity(clientDto);
        ClientEntity client = result.get();

        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        System.out.println(7);
        client.setDeliverAddress(clientDto.getDeliverAddress());
        System.out.println(1.2);
        clientRepository.save(client);
        return clientMapper.mapEntityToDto(client);

    }

    public ClientDTO desactivateClient(String document) {
        ClientValidation.documentValidation(document);
        Optional<ClientEntity> result = this.clientRepository.findByDocument(document);
        ClientValidation.clientEmptyValidation(result, document);

        ClientEntity clientEntity = result.get();
        clientEntity.setIsActive(!clientEntity.getIsActive());
        return clientMapper.mapEntityToDto(clientRepository.save(clientEntity));
    }


}
