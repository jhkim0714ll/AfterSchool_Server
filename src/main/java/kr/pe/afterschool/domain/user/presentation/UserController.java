package kr.pe.afterschool.domain.user.presentation;

import kr.pe.afterschool.domain.user.presentation.dto.request.EditUserRequest;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import kr.pe.afterschool.domain.user.service.MyUserQueryService;
import kr.pe.afterschool.domain.user.service.UserByEmailQueryService;
import kr.pe.afterschool.domain.user.service.UserEditService;
import kr.pe.afterschool.domain.user.service.UserQuitService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserByEmailQueryService userByEmailQueryService;
    private final MyUserQueryService myUserQueryService;
    private final UserEditService userEditService;
    private final UserQuitService userQuitService;

    @GetMapping("/{email}")
    public ResponseData<UserResponse> getUserByEmail(
            @PathVariable String email
    ) {
        UserResponse response = userByEmailQueryService.execute(email);
        return new ResponseData<>(
                HttpStatus.OK,
                "유저 단일 조회 성공",
                response
        );
    }

    @GetMapping("/my")
    public ResponseData<UserResponse> getMyData() {
        UserResponse response = myUserQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "내 유저 정보 조회 성공",
                response
        );
    }

    @PatchMapping("/update")
    public Response modifyUserData(
            @RequestBody EditUserRequest request
    ) {
        userEditService.execute(request);
        return new Response(
                HttpStatus.OK,
                "유저 정보 수정 성공"
        );
    }

    @DeleteMapping("/quit")
    public Response quitUser() {
        userQuitService.execute();
        return new Response(
                HttpStatus.OK,
                "회원 탈퇴 성공"
        );
    }
}
