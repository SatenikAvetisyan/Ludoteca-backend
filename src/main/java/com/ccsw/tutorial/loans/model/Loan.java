package com.ccsw.tutorial.loans.model;

import com.ccsw.tutorial.clients.model.Clients;
import com.ccsw.tutorial.game.model.Game;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Clients client;

    @Column(name = "loanDate", nullable = false)
    private LocalDate loanDate;

    @Column(name = "returnDate", nullable = false)
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return loanDate
     */
    public LocalDate getLoanDate() {

        return this.loanDate;
    }

    /**
     * @param loanDate new value of {@link #getLoanDate()}.
     */
    public void setLoanDate(LocalDate loanDate) {

        this.loanDate = loanDate;
    }

    /**
     * @return returnDate
     */
    public LocalDate getReturnDate() {

        return this.returnDate;
    }

    /**
     * @param returnDate new value of {@link #getReturnDate()}.
     */
    public void setReturnDate(LocalDate returnDate) {

        this.returnDate = returnDate;
    }

    /**
     * @return client
     */
    public Clients getClient() {
        return this.client;
    }

    /**
     * @param client new value of {@link #getClient}.
     */
    public void setClient(Clients client) {

        this.client = client;
    }

    /**
     * @return game
     */
    public Game getGame() {

        return this.game;
    }

    /**
     * @param author new value of {@link #getGame}.
     */
    public void setAuthor(Game author) {

        this.game = game;
    }

}