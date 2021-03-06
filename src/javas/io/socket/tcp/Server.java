package javas.io.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        // 阻塞等待连接
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder s = new StringBuilder();
        String line;
        // 阻塞接收消息
        while ((line = br.readLine()) != null) {
            if (line.startsWith("{")) {
                s = new StringBuilder();
            }
            s.append(line);
            s.append(System.lineSeparator());
            if (line.startsWith("}")) {
                System.out.println(s);
            }
        }
    }

}