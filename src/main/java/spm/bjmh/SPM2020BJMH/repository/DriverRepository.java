package spm.bjmh.SPM2020BJMH.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spm.bjmh.SPM2020BJMH.model.DriverModel;

@Repository
public interface DriverRepository extends MongoRepository<DriverModel, String>{
}
