package com.zofnk.materialdesign.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zofnk.materialdesign.constants.ApiConfig.BASE_URL;
import static com.zofnk.materialdesign.constants.ApiConfig.MAX_RESULT;
import static com.zofnk.materialdesign.constants.ApiConfig.NEED_ALLLIST;
import static com.zofnk.materialdesign.constants.ApiConfig.NEED_CONTENT;
import static com.zofnk.materialdesign.constants.ApiConfig.NEED_HTML;
import static com.zofnk.materialdesign.constants.ApiConfig.SHOWAPI_APPID;
import static com.zofnk.materialdesign.constants.ApiConfig.SHOWAPI_SIGN;

/**
 * Created by Administrator on 2017/3/30.
 */

public class RetrofitServiceManager {

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    /**
     * 获取RetrofitServiceManager
     *
     * @return
     */
    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;

    private RetrofitServiceManager() {
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间

        // 添加公共参数拦截器
        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams(NEED_CONTENT,"1")
                .addHeaderParams(NEED_HTML,"0")
                .addHeaderParams(NEED_ALLLIST,"0")
                .addHeaderParams(SHOWAPI_APPID,"33820")
                .addHeaderParams(SHOWAPI_SIGN,"7675d59be01e4fabb7838234c50b72f4")
                .build();
        builder.addInterceptor(commonInterceptor);

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
