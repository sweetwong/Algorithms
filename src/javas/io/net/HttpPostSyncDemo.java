package javas.io.net;

import javas.concurrent.ThreadUtils;
import javas.utils.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpPostSyncDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
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
                    return IOUtils.toString(is);
                }
            } catch (IOException e) {
                e.printStackTrace();
                ThreadUtils.print("异常A");
            }

            return null;
        });
        executor.shutdown();


        try {
            String s = future.get();
            ThreadUtils.print(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            ThreadUtils.print("异常B");
        }
    }

}
