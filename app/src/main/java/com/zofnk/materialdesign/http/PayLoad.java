package com.zofnk.materialdesign.http;

import com.zofnk.materialdesign.entity.BaseResponse;

import rx.functions.Func1;

/**
 * Created by Administrator on 2017/3/30.
 */

public class PayLoad<T> implements Func1<BaseResponse<T>, T> {

    @Override
    public T call(BaseResponse<T> response) {
        if (!response.isSuccess()){
            throw new Fault(response.status,response.message);
        }
        return response.data;
    }
}
