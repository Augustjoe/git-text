package com.webDemo.expection;

import com.webDemo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.DuplicateFormatFlagsException;

@Slf4j
@RestControllerAdvice
public class GlobalExpectationHandler {
    @ExceptionHandler
    public Result handle(Exception e){
        log.error("出现异常：{}", e);
        return Result.error();
    }
    @ExceptionHandler
    public Result handle(DuplicateFormatFlagsException e){
        log.error("出现异常：{}", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }

}
