package kr.pe.afterschool.domain.post.presentation;

import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.domain.post.service.PostByTypeQueryService;
import kr.pe.afterschool.global.enums.PostType;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class PostController {

    private final PostByTypeQueryService postByTypeQueryService;

    @GetMapping("/type")
    public ResponseData<List<PostResponse>> getPostByType(
            @RequestParam("type") PostType type
    ) {
        List<PostResponse> response = postByTypeQueryService.execute(type);
        return new ResponseData<>(
                HttpStatus.OK,
                "타입별 게시물 조회 성공",
                response
        );
    }
}
