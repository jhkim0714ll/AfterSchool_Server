package kr.pe.afterschool.domain.user.presentation;

import kr.pe.afterschool.domain.user.presentation.dto.request.ModifyUserRequest;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import kr.pe.afterschool.domain.user.service.GetUserByEmailService;
import kr.pe.afterschool.domain.user.service.ModifyUserService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final GetUserByEmailService getUserByEmailService;
    private final ModifyUserService modifyUserService;

    @GetMapping("/{email}")
    public ResponseData<UserResponse> getUserByEmail(
            @PathVariable String email
    ) {
        UserResponse response = getUserByEmailService.execute(email);
        return new ResponseData<>(
                HttpStatus.OK,
                "유저 단일 조회 성공",
                response
        );
    }

    @PatchMapping("/update")
    public Response modifyUserData(
            @RequestBody ModifyUserRequest request
    ) {
        modifyUserService.execute(request);
        return new Response(
                HttpStatus.OK,
                "유저 정보 수정 성공"
        );
    }
}
