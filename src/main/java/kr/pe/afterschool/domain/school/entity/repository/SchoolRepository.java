package kr.pe.afterschool.domain.school.entity.repository;

import kr.pe.afterschool.domain.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByAddressContaining(String address);
    List<School> findByNameContaining(String name);
    boolean existsByNameAndAddress(String name, String address);
}
