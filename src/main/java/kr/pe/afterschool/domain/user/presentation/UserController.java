package kr.pe.afterschool.domain.user.presentation;

import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserFacade userFacade;


}
