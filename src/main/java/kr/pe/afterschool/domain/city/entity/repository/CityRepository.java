package kr.pe.afterschool.domain.city.entity.repository;

import kr.pe.afterschool.domain.city.entity.City;
import kr.pe.afterschool.domain.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
    List<City> findByCountry(Country country);
}
