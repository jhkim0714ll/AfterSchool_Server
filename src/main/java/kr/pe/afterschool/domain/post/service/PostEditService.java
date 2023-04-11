package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.Post;
import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.exception.PostCannotManageException;
import kr.pe.afterschool.domain.post.exception.PostNotFoundException;
import kr.pe.afterschool.domain.post.presentation.dto.request.PostEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostEditService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long postId, PostEditRequest request) {
        User user = userFacade.getCurrentUser();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        if (user != post.getUser()) {
            throw PostCannotManageException.EXCEPTION;
        }

        post.editPost(request.getTitle(), request.getContent());
        postRepository.save(post);
    }
}
