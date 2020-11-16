package spm.bjmh.SPM2020BJMH.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}