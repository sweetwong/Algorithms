package javas.io.net;

import javas.concurrent.ThreadUtils;
import javas.utils.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpGetSyncDemo {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.flush();
            wr.close();

            if (con.getResponseCode() == 200) {
                ThreadUtils.print("成功");
                InputStream is = con.getInputStream();
                String s = IOUtils.toString(is, 1024);
                ThreadUtils.print("成功", s);
            } else {
                ThreadUtils.print("失败", "message", con.getResponseMessage(), "code", con.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ThreadUtils.print("异常A");
        }
    }

}
