package com.zofnk.materialdesign.entity;

/**
 * Created by Administrator on 2017/3/30.
 */

public class BaseResponse<T> {
    public int status;
    public String message;
    public T data;

    public boolean isSuccess() {
        return status == 200;
    }
}
