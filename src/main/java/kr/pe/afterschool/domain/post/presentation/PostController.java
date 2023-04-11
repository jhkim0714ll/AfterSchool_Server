package kr.pe.afterschool.domain.post.presentation;

import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.domain.post.service.PostByTypeQueryService;
import kr.pe.afterschool.domain.post.service.PostQueryService;
import kr.pe.afterschool.global.enums.PostType;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostQueryService postQueryService;
    private final PostByTypeQueryService postByTypeQueryService;

    @GetMapping("/{postId}")
    public ResponseData<PostResponse> getPostById(
            @PathVariable Long postId
    ) {
        PostResponse response = postQueryService.execute(postId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 아이디의 게시물 조회 성공",
                response
        );
    }

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
