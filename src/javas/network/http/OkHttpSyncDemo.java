package javas.network.http;

import data_structure.other.Time;
import javas.concurrent.ThreadUtils;
import javas.entity.GankBanners;
import javas.utils.GsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpSyncDemo {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://gank.io/api/v2/banners")
                .build();
        try (Response response = client.newCall(request).execute()) {
            String json = response.body().string();
            GankBanners gankBanners = GsonUtils.fromJson(json, GankBanners.class);
            ThreadUtils.print(gankBanners);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Time.watch(() -> {

        });
    }

}
