package spm.bjmh.SPM2020BJMH.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spm.bjmh.SPM2020BJMH.models.DriverInformation;

import java.util.Optional;

@Repository
public interface DriverInformationRepository extends MongoRepository<DriverInformation, String> {
    public Optional<DriverInformation>findByUsername(String username);
}
