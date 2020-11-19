package spm.bjmh.SPM2020BJMH.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import spm.bjmh.SPM2020BJMH.models.CarModel;

public interface CarRepository extends MongoRepository<CarModel, String> {

    //public CarModel findBylicencePlate(String licencePlate);

}
