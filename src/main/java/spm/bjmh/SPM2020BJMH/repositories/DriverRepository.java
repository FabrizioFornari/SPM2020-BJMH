package spm.bjmh.SPM2020BJMH.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spm.bjmh.SPM2020BJMH.models.Driver;

//interface including standard CRUD - connection between model and mongoDB
//@RepositoryRestResource()
@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {

    //first test query
    public Driver findByFirstName(String firstName);
    public List<Driver> findByLastName(String lastName);


    Driver findById(UUID id);
}


