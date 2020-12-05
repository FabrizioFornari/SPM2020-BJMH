package spm.bjmh.SPM2020BJMH.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    // find a user by email
    User findByEmail(String email);

    User findByUsername(String username);
    // check the exist of an user
    User existsByEmail(String email);
}
