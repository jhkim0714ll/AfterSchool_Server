package kr.pe.afterschool.global.security.principle;

import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.exception.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findById(email)
                .orElseThrow(() -> UsernameNotFoundException.EXCEPTION);
        return new AuthDetails(user);
    }
}
