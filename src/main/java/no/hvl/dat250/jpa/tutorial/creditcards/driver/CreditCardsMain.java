package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    em.persist(address);
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    em.persist(customer);

    customer.addAddress(address);
    address.addOwner(customer);
    Pincode pincode = new Pincode();
    pincode.setPincode("123");
    pincode.setCount(1);
    em.persist(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setCreditLimit(-10000);
    creditCard1.setBalance(-5000);
    creditCard1.setNumber(12345);
    creditCard1.setPincode(pincode);
    creditCard1.setBank(bank);

    CreditCard creditCard2 = new CreditCard();
    creditCard2.setCreditLimit(2000);
    creditCard2.setBalance(1);
    creditCard2.setNumber(123);
    creditCard2.setPincode(pincode);
    creditCard2.setBank(bank);

    bank.addCard(creditCard1);
    bank.addCard(creditCard2);
    customer.addCreditCard(creditCard1);
    customer.addCreditCard(creditCard2);
    em.persist(customer);
    em.persist(bank);
    em.persist(creditCard1);
    em.persist(creditCard2);


  }
}
