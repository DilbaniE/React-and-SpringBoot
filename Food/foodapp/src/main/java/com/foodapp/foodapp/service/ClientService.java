package com.foodapp.foodapp.service;

import com.foodapp.foodapp.DTO.ClientDTO;
import com.foodapp.foodapp.mapper.ClientMapper;
import com.foodapp.foodapp.model.ClientEntity;
import com.foodapp.foodapp.repository.IClientRepository;
import com.foodapp.foodapp.validation.ClientValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientDTO createClient(ClientDTO clientDTO) {
        ClientValidation.clientTotalValidation(clientMapper.mapDtoToEntity(clientDTO));
        Optional<ClientEntity> find = this.clientRepository.findByDocument(clientDTO.getDocument());
        ClientValidation.clientPresentValidation(find, clientDTO.getDocument());

        ClientEntity clientEntity = clientMapper.mapDtoToEntity(clientDTO);
        return clientMapper.mapEntityToDto(clientRepository.save(clientEntity));
    }

    public ClientDTO findByDocument(String document) {
        ClientValidation.documentValidation(document);
        Optional<ClientEntity> result = this.clientRepository.findByDocument(document);
        ClientValidation.clientEmptyValidation(result, document);

        ClientEntity clientEntity = result.get();
        return clientMapper.mapEntityToDto(clientEntity);
    }

    public ClientDTO updateClient(String document, ClientDTO clientDTO) {
        Optional<ClientEntity> result = this.clientRepository.findByDocument(document);
        ClientValidation.clientEmptyValidation(result, document);
        ClientValidation.clientEqualValidation(result.get(), clientMapper.mapDtoToEntity(clientDTO));
        ClientValidation.clientTotalValidation(clientMapper.mapDtoToEntity(clientDTO));

        ClientEntity clientEntity = clientMapper.mapDtoToEntity(clientDTO);
        ClientEntity client = result.get();

        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setDeliverAddress(clientDTO.getDeliverAddress());
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
