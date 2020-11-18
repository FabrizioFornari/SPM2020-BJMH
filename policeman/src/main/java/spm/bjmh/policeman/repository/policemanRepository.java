package spm.bjmh.policeman.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.policeman.model.policemanModel;

import java.util.List;

//interface CRUD
public interface policemanRepository extends MongoRepository<policemanModel, String> {

    //first test query
    public policemanModel findByName(String name);
    public List<policemanModel> findByLastName(String lastName);
}

