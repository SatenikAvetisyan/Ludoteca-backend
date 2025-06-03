package com.ccsw.tutorial.clients;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.clients.model.ClientsDto;
import com.ccsw.tutorial.clients.repository.ClientsRepository;
import com.ccsw.tutorial.clients.service.ClientsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

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

    public static final String CLIENT_NAME = "CLI1";

    @Test
    public void saveNotExistsClientsIdShouldInsert() {
        ClientsDto clentsDto = new ClientsDto();
        clentsDto.setName(CLIENT_NAME);

        ArgumentCaptor<Clients> clients = ArgumentCaptor.forClass(Clients.class);

        clientService.save(null, clentsDto);

        verify(clientsRepository).save(clients.capture());

        assertEquals(CLIENT_NAME, clients.getValue().getName());

    }

    public static final Long EXISTS_CLIENT_ID = 1L;

    @Test
    public void saveExistsClientsIdShouldUpdate() {
        ClientsDto clientsDto = new ClientsDto();
        clientsDto.setName(CLIENT_NAME);

        Clients clients = mock(Clients.class);
        when(clientsRepository.findById(EXISTS_CLIENT_ID)).thenReturn(Optional.of(clients));

        clientService.save(EXISTS_CLIENT_ID, clientsDto);

        verify(clientsRepository).save(clients);
    }
}