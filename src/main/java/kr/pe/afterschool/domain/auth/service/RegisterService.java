package kr.pe.afterschool.domain.auth.service;

import kr.pe.afterschool.domain.auth.exception.AlreadyJoinException;
import kr.pe.afterschool.domain.auth.presentation.dto.request.RegisterRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.global.enums.JoinMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(RegisterRequest request) {
        if (userRepository.existsById(request.getEmail())) {
            throw AlreadyJoinException.EXCEPTION;
        }
        String pw = passwordEncoder.encode(request.getPw());
        User user = User.builder()
                .email(request.getEmail())
                .pw(pw)
                .name(request.getName())
                .phone(request.getPhone())
                .grade(request.getGrade())
                .room(request.getRoom())
                .number(request.getNumber())
                .role(request.getRole())
                .profileImageUrl(request.getProfileImageUrl())
                .joinMethod(JoinMethod.LOCAL)
                .build();
        userRepository.save(user);
    }
}
