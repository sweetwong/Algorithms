package javas.network.http;

import javas.network.http.retrofit.HttpUtils;
import javas.network.http.retrofit.download.DownloadListener;
import javas.network.http.retrofit.download.DownloadUtil;

public class RetrofitDownloadDemo {

    public static void main(String[] args) {
        DownloadUtil.downloadFile("http://ipv4.download.thinkbroadband.com/100MB.zip",
                new DownloadListener() {
                    @Override
                    public void onStart() {
                        System.out.println("onStart");
                    }

                    @Override
                    public void onProgress(int currentLength) {
                        System.out.println(currentLength);
                    }

                    @Override
                    public void onFinish(String localPath) {
                        System.out.println("onFinish, localPath： " + localPath);
                    }

                    @Override
                    public void onFailure(String erroInfo) {
                        System.out.println("onFailure, erroInfo: " + erroInfo);
                    }
                }
        );
    }
}
