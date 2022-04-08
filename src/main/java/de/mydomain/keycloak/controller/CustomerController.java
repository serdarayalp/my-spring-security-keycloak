package de.mydomain.keycloak.controller;

import de.mydomain.keycloak.entity.Customer;
import de.mydomain.keycloak.model.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        addCustomers();
    }

    @GetMapping(path = "/")
    public String index() {
        return "public";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {

        Iterable<Customer> customers = customerRepository.findAll();

        model.addAttribute("customers", customers);
        /*model.addAttribute("username", principal.getName());*/

        return "customers";
    }

    private void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("Köpenicker Strasse 1, 12345 - Berlin");
        customer1.setName("Max Mustermann");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("Köpenicker Strasse 2, 12345 - Berlin");
        customer2.setName("Maxi Mustermann");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("Köpenicker Strasse 3, 12345 - Berlin");
        customer3.setName("Maximilian Mustermann");
        customerRepository.save(customer3);
    }
}