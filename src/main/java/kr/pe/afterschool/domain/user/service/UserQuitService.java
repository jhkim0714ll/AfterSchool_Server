package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserQuitService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();
        userRepository.delete(user);
    }
}
