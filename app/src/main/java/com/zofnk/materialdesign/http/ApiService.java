package com.zofnk.materialdesign.http;

import com.zofnk.materialdesign.entity.DataResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/30.
 */

public interface ApiService {

    @GET("109-35")
    Observable<DataResponse> getHomeDatas(@QueryMap Map<String, Object> options);

}
