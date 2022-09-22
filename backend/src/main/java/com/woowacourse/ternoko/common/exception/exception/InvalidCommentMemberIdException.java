package com.woowacourse.ternoko.common.exception.exception;

import com.woowacourse.ternoko.common.exception.CommonException;
import com.woowacourse.ternoko.common.exception.ExceptionType;
import org.springframework.http.HttpStatus;

public class InvalidCommentMemberIdException extends CommonException {

    public InvalidCommentMemberIdException(final ExceptionType exceptionType) {
        super(HttpStatus.BAD_REQUEST, exceptionType.getStatusCode(), exceptionType.getMessage());
    }
}
