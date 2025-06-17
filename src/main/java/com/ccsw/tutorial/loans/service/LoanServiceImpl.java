package com.ccsw.tutorial.loans.service;

import com.ccsw.tutorial.clients.service.ClientService;
import com.ccsw.tutorial.game.service.GameService;
import com.ccsw.tutorial.loans.model.Loan;
import com.ccsw.tutorial.loans.model.LoanDto;
import com.ccsw.tutorial.loans.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private GameService gameService;

    @Override
    public List<Loan> find(String title, String name, LocalDate date) {
        return List.of();
    }

    @Override
    public void save(Long id, LoanDto dto) {

    }

    @Override
    public void delete(Long id) {

    }
}
