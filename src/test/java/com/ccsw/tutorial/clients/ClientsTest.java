package com.ccsw.tutorial.clients;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.clients.repository.ClientsRepository;
import com.ccsw.tutorial.clients.service.ClientsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientsTest {

    @Mock
    private ClientsRepository clientsRepository;

    @InjectMocks
    private ClientsServiceImpl clientService;

    @Test
    public void findAllShouldReturnAllClients() {

        List<Clients> list = new ArrayList<>();
        list.add(mock(Clients.class));

        when(clientsRepository.findAll()).thenReturn(list);

        List<Clients> clientes = clientService.findAll();

        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }
}