package com.ccsw.tutorial.clients.controller;

import com.ccsw.tutorial.clients.model.ClientsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
