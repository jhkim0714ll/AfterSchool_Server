package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyPostQueryService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<PostResponse> execute() {
        User user = userFacade.getCurrentUser();
        return postRepository.findByUser(user)
                .stream().map(PostResponse::new).collect(Collectors.toList());
    }
}
