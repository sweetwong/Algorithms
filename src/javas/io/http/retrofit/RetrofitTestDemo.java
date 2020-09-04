package javas.io.http.retrofit;

import javas.io.http.retrofit.entity.BannerBean;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author wangsw
 * @date 2020/9/4
 */
public class RetrofitTestDemo {

    public static void main(String[] args) {
        try {
            Response<BannerBean> response = HttpUtils.getGankApi().getBanners("https://gank.io/api/v2/banners").execute();
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
