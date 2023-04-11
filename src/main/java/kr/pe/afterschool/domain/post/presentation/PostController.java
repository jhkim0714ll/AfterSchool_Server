package kr.pe.afterschool.domain.post.presentation;

import kr.pe.afterschool.domain.post.presentation.dto.request.PostCreateRequest;
import kr.pe.afterschool.domain.post.presentation.dto.request.PostEditRequest;
import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.domain.post.service.*;
import kr.pe.afterschool.global.enums.PostType;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostQueryService postQueryService;
    private final PostByTypeQueryService postByTypeQueryService;
    private final PostCreateService postCreateService;
    private final PostEditService postEditService;
    private final PostDeleteService postDeleteService;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response createPost(
            @RequestBody @Valid PostCreateRequest request
    ) {
        postCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "게시물 작성 성공"
        );
    }

    @PatchMapping("/{postId}")
    public Response editPost(
            @PathVariable Long postId,
            @RequestBody PostEditRequest request
    ) {
        postEditService.execute(postId, request);
        return new Response(
                HttpStatus.OK,
                "게시물 수정 성공"
        );
    }

    @DeleteMapping("/{postId}")
    public Response deletePost(
            @PathVariable Long postId
    ) {
        postDeleteService.execute(postId);
        return new Response(
                HttpStatus.OK,
                "게시물 수정 성공"
        );
    }
}
