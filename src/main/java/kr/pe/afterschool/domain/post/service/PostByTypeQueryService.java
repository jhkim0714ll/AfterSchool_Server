package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.global.enums.PostType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostByTypeQueryService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResponse> execute(PostType type) {
        return postRepository.findByType(type)
                .stream().map(PostResponse::new).collect(Collectors.toList());
    }
}
