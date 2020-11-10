package javas.network.http.retrofit;


import javas.network.http.retrofit.api.DownloadApi;
import javas.network.http.retrofit.api.GankApi;

/**
 * @author wangsw
 * @date 2020/6/18
 */
public class HttpUtils {

    private static HttpUtils sInstance;

    private GankApi mRouterApi;
    private DownloadApi mDownloadApi;

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

    public static DownloadApi getDownloadApi() {
        return getInstance().getDownloadApiInner();
    }


    private GankApi getGankApiInner() {
        if (mRouterApi == null) {
            mRouterApi = RetrofitFactory.getInstance().getRetrofit("https://www.baidu.com").create(GankApi.class);
        }
        return mRouterApi;
    }

    private DownloadApi getDownloadApiInner() {
        if (mDownloadApi == null) {
            mDownloadApi = RetrofitFactory.getInstance().getRetrofit("https://www.baidu.com").create(DownloadApi.class);
        }
        return mDownloadApi;
    }


}