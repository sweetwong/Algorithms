package javas.io.http;

import javas.concurrent.ThreadUtils;
import javas.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpASyncDemo {

    private static Executor sExecutor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        String a = "sweet: ";
        getData(new CallBack<String>() {
            @Override
            public void onSuccess(String s) {
                ThreadUtils.print(a + s);
            }

            @Override
            public void onFailure() {
                ThreadUtils.print(a + "失败");
            }
        });

        System.out.println("你好呀");
    }

    public static void getData(CallBack<String> callBack) {
        sExecutor.execute(() -> {
            try {
                String urlParameters = "serialNumber=kunlun0000000000060";
                byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
                int postDataLength = postData.length;
                URL url = new URL("https://oob.smartvu.com/region-config");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setUseCaches(false);
                con.setReadTimeout(5000);
                con.setConnectTimeout(5000);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.setRequestProperty("charset", "utf-8");
                con.setRequestProperty("Content-Length", Integer.toString(postDataLength));

                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();

                if (con.getResponseCode() == 200) {
                    InputStream is = con.getInputStream();
                    String res = IOUtils.toString(is);
                    callBack.onSuccess(res);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                ThreadUtils.print("异常A");
            }
            callBack.onFailure();
        });
    }

    interface CallBack<T> {

        void onSuccess(T t);

        void onFailure();
    }

}
