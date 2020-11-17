package spm.bjmh.SPM2020BJMH.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.model.DriverModel;

//interface including standard CRUD
public interface DriverRepository extends MongoRepository<DriverModel, String> {

    //first test query
    public DriverModel findByName(String name);
    public List<DriverModel> findByLastName(String lastName);
}

