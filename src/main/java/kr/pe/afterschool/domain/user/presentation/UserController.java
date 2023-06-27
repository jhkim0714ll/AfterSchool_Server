package kr.pe.afterschool.domain.user.presentation;

import kr.pe.afterschool.domain.user.presentation.dto.request.UserEditRequest;
import kr.pe.afterschool.domain.user.presentation.dto.request.UserEditSchoolRequest;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import kr.pe.afterschool.domain.user.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserByEmailQueryService userByEmailQueryService;
    private final MyUserQueryService myUserQueryService;
    private final UserEditService userEditService;
    private final UserEditSchoolService userEditSchoolService;
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
    public Response editUserData(
            @RequestBody UserEditRequest request
    ) {
        userEditService.execute(request);
        return new Response(
                HttpStatus.OK,
                "유저 정보 수정 성공"
        );
    }

    @PatchMapping("/update/school")
    public Response editUserSchool(
            @RequestBody UserEditSchoolRequest request
    ) {
        userEditSchoolService.execute(request);
        return new Response(
                HttpStatus.OK,
                "학교 설정 성공"
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
