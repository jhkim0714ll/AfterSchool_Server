package kr.pe.afterschool.domain.user.entity.repository;

import kr.pe.afterschool.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
