package javas.io.socket;

import javas.utils.FakeData;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(os);
        for (; ; ) {
            writer.write(FakeData.getJson() + System.lineSeparator());
            writer.flush();
            Thread.sleep(5000);
        }
    }

}