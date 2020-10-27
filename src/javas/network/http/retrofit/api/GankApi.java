package javas.network.http.retrofit.api;

import javas.network.http.retrofit.entity.BannerBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GankApi {

    @GET
    Call<BannerBean> getBanners(@Url String url);

}
