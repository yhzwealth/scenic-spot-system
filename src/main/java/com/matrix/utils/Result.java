package com.matrix.utils;

import java.io.Serializable;

public class Result implements Serializable {
    // 消息状态码
    private Integer code;
    // 消息
    private String msg;
    // 返回数据
    private Object data;

    private Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     * @param data 返回数据
     * @return Result
     */
    public static Result success(Object data){
        return new Result(200,"响应成功",data);
    }

    public static Result success(String msg, Object data){
        return new Result(200,msg,data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static Result success(){
        return new Result(200,"响应成功",null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static Result error(String msg){
        return new Result(500,msg,null);
    }

    public static Result error(String msg, Object data){
        return new Result(500,msg,data);
    }
    /**
     * 响应错误(带错误码,消息提醒)
     * @return
     */
    public static Result errorMsg(Integer code, String msg){
        return new Result(code,msg,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
