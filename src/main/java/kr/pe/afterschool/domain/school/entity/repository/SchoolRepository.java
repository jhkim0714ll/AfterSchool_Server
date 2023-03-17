package kr.pe.afterschool.domain.school.entity.repository;

import kr.pe.afterschool.domain.city.entity.City;
import kr.pe.afterschool.domain.city.entity.Country;
import kr.pe.afterschool.domain.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByCityAndCountry(City city, Country country);
}
