package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.domain.user.presentation.dto.request.EditUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserEditService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(EditUserRequest request) {
        User user = userFacade.getCurrentUser();
        user.editUserData(
                request.getName(),
                request.getPhone(),
                request.getGrade(),
                request.getRoom(),
                request.getNumber(),
                request.getProfileImageUrl());
        userRepository.save(user);
    }
}
