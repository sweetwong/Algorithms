package javas.network.socket;

import javas.utils.FakeData;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        for (; ; ) {
            writer.println(FakeData.getJson());
            Thread.sleep(5000);
        }
    }

}