package javas.network.http.retrofit;

import javas.network.http.retrofit.entity.BannerBean;
import javas.network.http.retrofit.thread.Dispatchers;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author wangsw
 * @date 2020/9/11
 */
public class GankModel {

    public void getBanners(Callback<BannerBean> callback) {
        Dispatchers.io().execute(() -> {
            try {
                Response<BannerBean> response = HttpUtils.getGankApi().getBanners("https://gank.io/api/v2/banners").execute();
                if (response.isSuccessful()) {
                    callback.onResponse(new Result<>(response.body()));
                } else {
                    callback.onResponse(Result.FAILURE);
                }
            } catch (IOException e) {
                e.printStackTrace();
                callback.onResponse(Result.EXCEPTION);
            }
        });
    }
}
