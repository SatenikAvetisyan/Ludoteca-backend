package com.ccsw.tutorial.clients.repository;

import com.ccsw.tutorial.clients.model.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Long> {

}
