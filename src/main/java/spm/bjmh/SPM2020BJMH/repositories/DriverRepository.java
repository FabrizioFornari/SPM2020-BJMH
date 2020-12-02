package spm.bjmh.SPM2020BJMH.repositories;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spm.bjmh.SPM2020BJMH.models.Driver;


@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
    public Optional<Driver> findByUsername(String username);




}

