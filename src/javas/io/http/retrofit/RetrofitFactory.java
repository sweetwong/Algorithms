package javas.io.http.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangsw
 * @date 2020/6/18
 */
public class RetrofitFactory {

    private static RetrofitFactory sInstance;
    private Map<String, Retrofit> mRetrofitMap = new HashMap<>();

    private RetrofitFactory() {
    }

    public static RetrofitFactory getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitFactory();
        }
        return sInstance;
    }

    public Retrofit getRetrofit(String baseUrl) {
        if (!mRetrofitMap.containsKey(baseUrl)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mRetrofitMap.put(baseUrl, retrofit);
        }
        return mRetrofitMap.get(baseUrl);
    }


}