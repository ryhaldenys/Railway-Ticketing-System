package ua.nulp.kn303.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.nulp.kn303.dto.UserDto;
import ua.nulp.kn303.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query("select new ua.nulp.kn303.dto.UserDto(u.username,u.email)" +
            " from User u where u.id =?1")
    Optional<UserDto> findUserById(Long id);
}
