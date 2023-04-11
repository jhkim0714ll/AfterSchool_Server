package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.exception.PostNotFoundException;
import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostQueryService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponse execute(Long postId) {
        return new PostResponse(postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION));
    }
}
