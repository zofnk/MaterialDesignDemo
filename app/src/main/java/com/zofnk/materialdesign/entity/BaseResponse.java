package com.zofnk.materialdesign.entity;

/**
 * Created by Administrator on 2017/3/30.
 */

public class BaseResponse {
    public int status;
    public String message;
    public DataResponse data;

    public boolean isSuccess() {
        return status == 200;
    }
}
