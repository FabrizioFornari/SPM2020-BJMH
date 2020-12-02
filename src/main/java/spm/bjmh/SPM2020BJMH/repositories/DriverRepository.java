package spm.bjmh.SPM2020BJMH.repositories;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spm.bjmh.SPM2020BJMH.models.DriverModel;

//interface including standard CRUD - connection between model and mongoDB
//@RepositoryRestResource()
@Repository
public interface DriverRepository extends MongoRepository<DriverModel, String> {

    //first test query
    public DriverModel findByFirstName(String firstName);
    public List<DriverModel> findByLastName(String lastName);


    DriverModel findById(UUID id);
}

