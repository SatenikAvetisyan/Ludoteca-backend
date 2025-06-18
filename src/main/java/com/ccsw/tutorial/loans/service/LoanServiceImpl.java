package com.ccsw.tutorial.loans.service;

import com.ccsw.tutorial.clients.service.ClientService;
import com.ccsw.tutorial.common.criteria.SearchCriteria;
import com.ccsw.tutorial.game.service.GameService;
import com.ccsw.tutorial.loans.model.Loan;
import com.ccsw.tutorial.loans.model.LoanDto;
import com.ccsw.tutorial.loans.repository.LoanRepository;
import com.ccsw.tutorial.loans.specification.LoanSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        Specification<Loan> spec = (root, query, cb) -> cb.conjunction();

        if (title != null)
            spec = spec.and(new LoanSpecification(new SearchCriteria("game.title", ":", title)));

        if (name != null)
            ;
        spec = spec.and((root, query, cb) -> cb.and(cb.lessThanOrEqualTo(root.get("loanDate"), date), cb.greaterThanOrEqualTo(root.get("returnDate"), date)));
        return loanRepository.findAll(spec);
    }

    @Override
    public void save(Long id, LoanDto dto) {
        if (dto.getReturnDate().isBefore(dto.getLoanDate()))
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la de inicio.");

        if (ChronoUnit.DAYS.between(dto.getLoanDate(), dto.getReturnDate()) > 14)
            throw new IllegalArgumentException("El préstamo no puede durar más de 14 días");

        Loan loan;

        if (id == null) {
            loan = new Loan();
        } else {
            loan = this.loanRepository.findById(id).orElse(null);
        }

        loan.setLoanDate(dto.getLoanDate());
        loan.setReturnDate(dto.getReturnDate());
        loan.setClient(clientService.get(dto.getClient().getId()));
        loan.setGame(gameService.get(dto.getGame().getId()));

    }

    @Override
    public void delete(Long id) {
        this.loanRepository.deleteById(id);

    }
}
