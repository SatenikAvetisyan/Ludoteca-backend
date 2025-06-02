package com.ccsw.tutorial.clients.service;

import com.ccsw.tutorial.clients.model.ClientsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientsServiceImpl implements ClientService {

    private long SEQUENCE = 1;
    private Map<Long, ClientsDto> clientes = new HashMap<Long, ClientsDto>();

    /**
     * {@inheritDoc}
     */
    public List<ClientsDto> findAll() {
        return new ArrayList<ClientsDto>(this.clientes.values());
    }

    /**
     * {@inheritDoc}
     */
    public void save(Long id, ClientsDto dto) {
        ClientsDto client;

        if (id == null) {
            client = new ClientsDto();
            client.setId(this.SEQUENCE++);
            this.clientes.put(client.getId(), client);
        } else {
            client = this.clientes.get(id);
        }
        client.setName(dto.getName());
    }

    /**
     * {@inheritDoc}
     */
    public void delete(Long id) {
        this.clientes.remove(id);
    }
}