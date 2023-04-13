package kr.pe.afterschool.domain.auth.service;

import kr.pe.afterschool.domain.auth.exception.AlreadyJoinException;
import kr.pe.afterschool.domain.auth.presentation.dto.request.OauthRegisterRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OauthRegisterService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(OauthRegisterRequest request) {
        if (userRepository.existsById(request.getEmail())) {
            throw AlreadyJoinException.EXCEPTION;
        }
        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .grade(request.getGrade())
                .room(request.getRoom())
                .number(request.getNumber())
                .role(request.getRole())
                .profileImageUrl(request.getProfileImageUrl())
                .phone(request.getPhone())
                .build();
        userRepository.save(user);
    }
}
