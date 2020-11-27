package spm.bjmh.SPM2020BJMH.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.models.PolicemanModel;

import java.util.List;

public interface PolicemanRepository extends MongoRepository<PolicemanModel, String> {

   //PolicemanModel findBy_id(ObjectId id);
}