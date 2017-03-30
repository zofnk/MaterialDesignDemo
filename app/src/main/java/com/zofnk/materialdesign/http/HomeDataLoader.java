package com.zofnk.materialdesign.http;

import com.zofnk.materialdesign.entity.DataResponse;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Administrator on 2017/3/30.
 */

public class HomeDataLoader extends ObjectLoader {

    private ApiService mApiService;

    public HomeDataLoader() {
        mApiService = RetrofitServiceManager.getInstance().create(ApiService.class);
    }

    public Observable<List<DataResponse.ShowapiResBodyBean.PagebeanBean.ContentlistBean>> getHomeList(HashMap<String, String> options) {
        return observe(mApiService.getHomeDatas(options))
                .map(new Func1<DataResponse, List<DataResponse.ShowapiResBodyBean.PagebeanBean.ContentlistBean>>() {
                    @Override
                    public List<DataResponse.ShowapiResBodyBean.PagebeanBean.ContentlistBean> call(DataResponse response) {
                        return response.getShowapi_res_body().getPagebean().getContentlist();
                    }
                });
    }

}
