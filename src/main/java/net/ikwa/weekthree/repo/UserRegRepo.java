package net.ikwa.weekthree.repo;

import net.ikwa.weekthree.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegRepo extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
