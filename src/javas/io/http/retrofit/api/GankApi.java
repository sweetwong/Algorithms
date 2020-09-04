package javas.io.http.retrofit.api;

import javas.io.http.retrofit.entity.BannerBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GankApi {

    @GET
    Call<BannerBean> getBanners(@Url String url);

}
