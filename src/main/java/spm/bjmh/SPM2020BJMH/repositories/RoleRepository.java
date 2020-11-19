package spm.bjmh.SPM2020BJMH.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spm.bjmh.SPM2020BJMH.models.ERole;
import spm.bjmh.SPM2020BJMH.models.RoleModel;

import java.util.Optional;

public interface RoleRepository  extends MongoRepository<RoleModel, String> {

    Optional<RoleModel> findByName(ERole name);
    RoleModel findByRole(String role);
}
