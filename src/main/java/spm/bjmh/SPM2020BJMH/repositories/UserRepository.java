package spm.bjmh.SPM2020BJMH.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.models.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
    // find a user by email
    UserModel findByEmail(String email);

    UserModel findByUsername(String username);
    // check the exist of an user
    UserModel existsByEmail(String email);
}
