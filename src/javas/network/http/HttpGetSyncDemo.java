package javas.network.http;

import javas.concurrent.ThreadUtils;
import javas.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

public class HttpGetSyncDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            HttpURLConnection con = null;
            try {
                URL url = new URL("https://www.baidu.com");
                con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setConnectTimeout(500);
                con.setReadTimeout(500);
                con.setUseCaches(false);

                OutputStream os = new DataOutputStream(con.getOutputStream());
                os.flush();
                os.close();

                if (con.getResponseCode() == 200) {
                    InputStream is = con.getInputStream();
                    String s = IOUtils.toString(is);
                    is.close();
                    return s;
                }
            } catch (IOException e) {
                e.printStackTrace();
                ThreadUtils.print("异常A");
            } finally {
                if (con != null) {
                    con.disconnect();
                }
            }
            return null;
        });
        executor.shutdown();

        try {
            String s = future.get();
            if (s != null) {
                ThreadUtils.print(s);
            } else {
                ThreadUtils.print("失败");
            }
        } catch (InterruptedException | ExecutionException e) {
            ThreadUtils.print("异常B");
            e.printStackTrace();
        }
    }

}
