package javas.io.socket;

import javas.utils.Utils;

import java.io.*;
import java.net.Socket;

public class ClientB {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write(Utils.bigText(10));
            pw.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("我是客户端，服务器说：" + line);
            }
            socket.shutdownInput();


            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}