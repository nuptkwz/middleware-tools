package com.mongo.springbootmongo.util;

/**
 * Description
 * Date 2020/9/23 22:20
 * Created by kwz
 */
public class Result<T>{

    private static final String CODE_SUCCESS = "200";
    private static final String CODE_FAIL = "400";
    private static final String MSG_SUCCESS="success";
    private static final String MSG_FAIL="failed";

    public Result(){
    }
    public Result(String code ){
        this.code=code;
    }
    public Result(String code, T entity ){
        this.code=code;
        this.entity=entity;
    }
    public Result(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result(String code, String msg, T entity) {
        this.code = code;
        this.msg = msg;
        this.entity=entity;
    }
    public static Result success(){
        return new Result(CODE_SUCCESS,MSG_SUCCESS);
    }

    public static Result success(Object data){
        return new Result(CODE_SUCCESS,MSG_SUCCESS, data);
    }

    public static Result fail(){
        return new Result(CODE_FAIL, MSG_FAIL);
    }

    private String code;
    private String msg;
    public T entity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
