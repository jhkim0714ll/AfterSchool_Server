package kr.pe.afterschool.domain.post.exception;

import kr.pe.afterschool.domain.post.error.PostExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class PostCannotManageException extends AfterSchoolException {

    private PostCannotManageException() {
        super(PostExceptionCode.POST_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new PostCannotManageException();
}
