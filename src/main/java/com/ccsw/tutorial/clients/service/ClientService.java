package com.ccsw.tutorial.clients.service;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.clients.model.ClientsDto;

import java.util.List;

public interface ClientService {

    /**
     * Recupera un {@link  Clients } a través de su ID
     *
     * @param id PK de la entidad
     * @return {@link Clients}
     */
    Clients get(Long id);

    /**
     * Método para recuperar todos los {@link Clients}
     *
     * @return {@link List} de {@link Clients}
     */
    List<Clients> findAll();

    /**
     * Método para crear o actualizar un {@link Clients}
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
    void delete(Long id) throws Exception;
}
