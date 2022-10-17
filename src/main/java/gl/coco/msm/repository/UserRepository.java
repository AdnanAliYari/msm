package gl.coco.msm.repository;

import gl.coco.msm.entity.User;

import java.util.Optional;


public interface UserRepository extends AbstractEntityRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
