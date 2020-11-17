package spm.bjmh.SPM2020BJMH.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spm.bjmh.SPM2020BJMH.model.Car;

public interface CaRrepository extends MongoRepository<Car, String> {

    public Car findBylicencePlate(String licencePlate);

}
