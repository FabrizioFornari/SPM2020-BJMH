package spm.bjmh.SPM2020BJMH.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.model.Customer;

public interface CarRepository extends MongoRepository<car, String> {

    public Car findBylicencePlate(String licencePlate);
    
}


