package kr.pe.afterschool.domain.city.service;

import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityRemoveService {

    private final CityRepository cityRepository;

    @Transactional
    public void execute(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
