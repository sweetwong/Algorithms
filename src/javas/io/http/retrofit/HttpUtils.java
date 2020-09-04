package javas.io.http.retrofit;


import javas.io.http.retrofit.api.GankApi;

/**
 * @author wangsw
 * @date 2020/6/18
 */
public class HttpUtils {

    private static HttpUtils sInstance;

    private GankApi mRouterApi;

    private HttpUtils() {
    }

    private static HttpUtils getInstance() {
        if (sInstance == null) {
            sInstance = new HttpUtils();
        }
        return sInstance;
    }

    public static GankApi getGankApi() {
        return getInstance().getGankApiInner();
    }

    private GankApi getGankApiInner() {
        if (mRouterApi == null) {
            mRouterApi = RetrofitFactory.getInstance().getRetrofit("https://www.baidu.com").create(GankApi.class);
        }
        return mRouterApi;
    }

}