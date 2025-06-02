package com.ccsw.tutorial.clients.service;

import com.ccsw.tutorial.clients.model.ClientsDto;

import java.util.List;

public interface ClientService {

    /**
     * Método para recuperar todos los clientes
     *
     * @return {@link List} de {@link ClientsDto}
     */
    List<ClientsDto> findAll();

    /**
     * Método para crear o actualizar un cliente
     *
     * @param id PK de la entidad
     * @param id PK de la entidad
     */
    void save(Long id, ClientsDto dto);

    /**
     * Método para borrar un cliente
     *
     * @param id PK de la entidad
     */
    void delete(Long id);
}
