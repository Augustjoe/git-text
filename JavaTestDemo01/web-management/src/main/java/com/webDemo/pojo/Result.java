package com.webDemo.pojo;

import lombok.Data;

@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success(){
        Result result = new Result();
        result.code = 200;
        result.msg = "success";
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.code = 200;
        result.msg = "success";
        result.data = data;
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.code = 500;
        result.msg = "error";
        return result;
    }

}
