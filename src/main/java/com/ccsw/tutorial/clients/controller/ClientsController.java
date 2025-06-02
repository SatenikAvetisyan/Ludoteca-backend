package com.ccsw.tutorial.clients.controller;

import com.ccsw.tutorial.clients.model.ClientsDto;
import com.ccsw.tutorial.clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clients", description = "API of Category")
@RequestMapping(value = "/clients")
@RestController
@CrossOrigin(origins = "*")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    /**
     * Método para recuperar todos los clientes
     *
     * @return {@link List} de {@link ClientsDto}
     */
    @Operation(summary = "Find", description = "Method that return a list of Clients")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ClientsDto> findAll() {
        return this.clientService.findAll();
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

        this.clientService.save(id, dto);
    }

    /**
     * Método para borrar una categoria
     *
     * @param id PK de la entidad
     */
    @Operation(summary = "Delete", description = "Method that deletes a client")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        this.clientService.delete(id);
    }
}
