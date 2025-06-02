package com.ccsw.tutorial.clients.controller;

import com.ccsw.tutorial.clients.model.ClientsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Clients", description = "API of Category")
@RequestMapping(value = "/clients")
@RestController
@CrossOrigin(origins = "*")
public class ClientsController {
    private long SEQUENCE = 1;
    private Map<Long, ClientsDto> clientes = new HashMap<Long, ClientsDto>();

    /**
     * Método para recuperar todos los clientes
     *
     * @return {@link List} de {@link ClientsDto}
     */
    @Operation(summary = "Find", description = "Method that return a list of Clients")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ClientsDto> findAll() {
        return new ArrayList<ClientsDto>(this.clientes.values());
    }

    /**
     * Método para craer o actualizar una categoria
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save or Update", description = "Method thats saves or update a client")
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientsDto dto) {

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
}
