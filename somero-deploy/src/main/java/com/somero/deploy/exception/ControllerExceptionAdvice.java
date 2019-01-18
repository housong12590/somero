package com.somero.deploy.exception;

import com.somero.deploy.utils.MakerResp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        logger.debug("==================================");
        for (FieldError error : bindingResult.getFieldErrors()) {
            logger.debug(error.getField() + " : " + error.getDefaultMessage());
        }
        logger.debug("==================================");
        return MakerResp.errorResult(e.getBindingResult());
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Object handlerServiceException(ServiceException e) {
        MakerResp result = MakerResp.failed(e.getMessage());
        logger.debug("请求返回: " + result.toString());
        return result;
    }

}
