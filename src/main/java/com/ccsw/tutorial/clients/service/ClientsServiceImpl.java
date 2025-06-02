package com.ccsw.tutorial.clients.service;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.clients.model.ClientsDto;
import com.ccsw.tutorial.repository.ClientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientsServiceImpl implements ClientService {

    @Autowired
    ClientsRepository clientsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Clients> findAll() {
        return (List<Clients>) this.clientsRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, ClientsDto dto) {
        Clients client;

        if (id == null) {
            client = new Clients();
        } else {
            client = this.clientsRepository.findById(id).orElse(null);
        }
        client.setName(dto.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) throws Exception {
        if (this.clientsRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not exists");
        }
        this.clientsRepository.deleteById(id);
    }
}