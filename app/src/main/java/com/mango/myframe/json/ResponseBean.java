package com.mango.myframe.json;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/12.
 */
public class ResponseBean {
    private int code;

    private String message;

    private Result result;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
}
