package com.ccsw.tutorial.clients.controller;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.clients.model.ClientsDto;
import com.ccsw.tutorial.clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Clients", description = "API of Category")
@RequestMapping(value = "/clients")
@RestController
@CrossOrigin(origins = "*")
public class ClientsController {

    @Autowired
    ClientService clientService;

    @Autowired
    ModelMapper mapper;

    /**
     * Método para recuperar todos los clientes
     *
     * @return {@link List} de {@link Clients}
     */
    @Operation(summary = "Find", description = "Method that return a list of Clients")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ClientsDto> findAll() {
        List<Clients> clientes = this.clientService.findAll();
        return clientes.stream().map(e -> mapper.map(e, ClientsDto.class)).collect((Collectors.toList()));
    }

    /**
     * Método para craer o actualizar un {@link Clients}
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save or Update", description = "Method thats saves or update a client")
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientsDto dto) {

        this.clientService.save(id, dto);
    }

    /**
     * Método para borrar una categoria
     *
     * @param id PK de la entidad
     */
    @Operation(summary = "Delete", description = "Method that deletes a client")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.clientService.delete(id);
    }
}
