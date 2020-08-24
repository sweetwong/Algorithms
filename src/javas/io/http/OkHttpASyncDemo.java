package javas.io.http;

import javas.concurrent.ThreadUtils;
import javas.entity.GankBanners;
import javas.utils.GsonUtils;
import okhttp3.*;

import java.io.IOException;

public class OkHttpASyncDemo {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("https://gank.io/api/v2/banners")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                GankBanners gankBanners = GsonUtils.fromJson(json, GankBanners.class);
                ThreadUtils.print(gankBanners);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                ThreadUtils.print("请求失败");
            }
        });
    }

}
