package javas.io.socket;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(os);
        for (; ; ) {
            writer.append(getJson())
                    .append(System.lineSeparator());
            writer.flush();
            Thread.sleep(3000);
        }
    }

    private static String getJson() {
        return "{\n" +
                "  \"appInfos\": [\n" +
                "    {\n" +
                "      \"orderIndex\": 1,\n" +
                "      \"packageName\": \"us.zoom.videomeetings\",\n" +
                "      \"customName\": \"\",\n" +
                "      \"customIcon\": \"\",\n" +
                "      \"useCustom\": false,\n" +
                "      \"isHidden\": false,\n" +
                "      \"description\": \"Zoom\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}