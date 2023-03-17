package kr.pe.afterschool.domain.school.entity.repository;

import kr.pe.afterschool.domain.school.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}