package javas.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerB {

    public static void main(String[] args) {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ServerSocket server = new ServerSocket(8888);
            socket = server.accept();

            is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + line);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            writer.write("欢迎您！");
            writer.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}