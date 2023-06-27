package kr.pe.afterschool.domain.post.service;

import kr.pe.afterschool.domain.post.entity.repository.PostRepository;
import kr.pe.afterschool.domain.post.presentation.dto.response.PostResponse;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostBySchoolQueryService {

    private final PostRepository postRepository;
    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public List<PostResponse> execute(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        return postRepository.findBySchool(school)
                .stream().map(PostResponse::new).collect(Collectors.toList());
    }
}
