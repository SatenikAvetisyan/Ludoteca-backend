package com.ccsw.tutorial.loans.controller;

import com.ccsw.tutorial.game.model.GameDto;
import com.ccsw.tutorial.loans.model.Loan;
import com.ccsw.tutorial.loans.model.LoanDto;
import com.ccsw.tutorial.loans.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Loan", description = "API of Loan")
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @Autowired
    private ModelMapper mapper;

    /**
     * Método para recuperar una lista de {@link Loan}
     *
     * @param title título del juego
     * @param client de Client
     * @param date de Loan
     * @return {@link List} de {@link GameDto}
     */

    @Operation(summary = "Find", description = "Method that returns a filter list of Loans")
    @GetMapping("")
    public List<LoanDto> find(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "client", required = false) String client, @RequestParam(value = "date", required = false) LocalDate date) {
        List<Loan> loans = loanService.find(title, client, date);
        return loans.stream().map(e -> mapper.map(e, LoanDto.class)).collect(Collectors.toList());
    }

    /**
     * Método para crear y actualizar un {@link Loan}
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save or Update", description = "Method that saves or updates a Loan")
    @PutMapping(path = { "", "/{id}" })
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto dto) {
        loanService.save(id, dto);
    }

}
