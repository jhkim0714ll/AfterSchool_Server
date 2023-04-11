package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.apply.exception.ApplyNotFoundException;
import kr.pe.afterschool.global.enums.ApplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyByIdDecisionService {

    private final ApplyRepository applyRepository;

    @Transactional
    public void execute(Long applyId, ApplyStatus status) {
        Apply apply = applyRepository.findById(applyId)
                .orElseThrow(() -> ApplyNotFoundException.EXCEPTION);
        apply.editStatus(status);
        applyRepository.save(apply);
    }
}
