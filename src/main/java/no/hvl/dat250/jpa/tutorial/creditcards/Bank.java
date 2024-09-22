package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> cards = new HashSet<>();

    public String getName() {
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(CreditCard card) {
        cards.add(card);
    }
}
