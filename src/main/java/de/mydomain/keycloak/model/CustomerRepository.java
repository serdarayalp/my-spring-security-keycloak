package de.mydomain.keycloak.model;

import de.mydomain.keycloak.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
