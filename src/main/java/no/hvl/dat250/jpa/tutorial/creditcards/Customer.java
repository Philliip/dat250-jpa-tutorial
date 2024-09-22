package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;
import no.hvl.dat250.jpa.tutorial.relationshipexample.Job;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Set<CreditCard> creditCards = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Address> addresses = new HashSet<>();

    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {

        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }
}
