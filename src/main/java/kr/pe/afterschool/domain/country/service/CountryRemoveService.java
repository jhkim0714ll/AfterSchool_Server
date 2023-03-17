package kr.pe.afterschool.domain.country.service;

import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryRemoveService {

    private final CountryRepository countryRepository;

    @Transactional
    public void execute(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}
