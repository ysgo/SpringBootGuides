package org.example.spring.data.jpa.repository;

import org.example.spring.data.jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}
