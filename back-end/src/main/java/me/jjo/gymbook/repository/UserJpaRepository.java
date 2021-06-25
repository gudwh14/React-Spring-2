package me.jjo.gymbook.repository;

import me.jjo.gymbook.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") // Eager 조회로 authorities 정보를 같이 가져옴
    Optional<User> findOneWithAuthoritiesByPhone(String phone);
}
