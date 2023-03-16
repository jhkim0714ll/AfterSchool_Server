package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.domain.user.presentation.dto.request.ModifyUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyUserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void execute(ModifyUserRequest request) {
        User user = userFacade.getCurrentUser();
        user.modifyUserData(
                request.getName(),
                request.getPhone(),
                request.getGrade(),
                request.getRoom(),
                request.getNumber(),
                request.getProfileImageUrl());
        userRepository.save(user);
    }
}
