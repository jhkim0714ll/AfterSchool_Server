package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.exception.UserNotFoundException;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserByEmailQueryService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse execute(String email) {
        return new UserResponse(
                userRepository.findById(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION));
    }
}
