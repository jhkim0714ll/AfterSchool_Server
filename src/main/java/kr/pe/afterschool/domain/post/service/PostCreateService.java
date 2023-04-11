package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.Post;
import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.presentation.dto.request.PostCreateRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCreateService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(PostCreateRequest request) {
        User user = userFacade.getCurrentUser();
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .user(user)
                .school(user.getSchool())
                .build();
        postRepository.save(post);
    }
}
