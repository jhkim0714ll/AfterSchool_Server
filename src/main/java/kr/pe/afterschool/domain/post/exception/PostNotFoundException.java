package kr.pe.afterschool.domain.post.exception;

import kr.pe.afterschool.domain.post.error.PostExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class PostNotFoundException extends AfterSchoolException {

    private PostNotFoundException() {
        super(PostExceptionCode.POST_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new PostNotFoundException();
}
