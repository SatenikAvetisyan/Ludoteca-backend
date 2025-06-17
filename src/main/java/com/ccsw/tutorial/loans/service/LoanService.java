package com.ccsw.tutorial.loans.service;

import com.ccsw.tutorial.loans.model.Loan;
import com.ccsw.tutorial.loans.model.LoanDto;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {

    /**
     * Recupera los préstamos filtrando por título del juego, nombre del cliente y/o fecha intermedia
     *
     * @param title título del juego
     * @param name nombre del cliente
     * @param date fecha para filtrar si cae entre inicio y fin del préstamo
     * @return Lista de préstamos que cumplen los filtros
     */

    List<Loan> find(String title, String name, LocalDate date);

    /**
     * Guarda o modifica un préstamo según si el ID está informado o no
     *
     * @param id identificador del préstamo
     * @param dto datos del préstamo a guardar
     */

    void save(Long id, LoanDto dto);

    /**
     * Elimina un préstamo por su ID
     *
     * @param id identificador del préstamo
     */
    void delete(Long id);
}
