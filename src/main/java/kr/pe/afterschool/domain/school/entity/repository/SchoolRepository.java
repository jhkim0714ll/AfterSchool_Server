package kr.pe.afterschool.domain.school.entity.repository;

import kr.pe.afterschool.domain.school.entity.City;
import kr.pe.afterschool.domain.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByCity(City city);
}
