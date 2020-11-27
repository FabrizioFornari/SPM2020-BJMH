package spm.bjmh.SPM2020BJMH.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.models.PolicemanModel;

import java.util.List;

public interface PolicemanRepository extends MongoRepository<PolicemanModel, String> {

//first test query
public PolicemanModel findByFirstName(String firstName);
public List<PolicemanModel> findByLastName(String lastName);


    PolicemanModel findBy_id(ObjectId id);
}