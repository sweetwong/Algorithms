package javas.network.ftp;

public class FtpDemo {

    private static final String HOST_NAME = "192.168.160.160";
    private static final int PORT = 22;
    private static final String USER_NAME = "wangsiwei";
    private static final String PASSWORD = "wangsiwei";

    private static final String SERVER_PATH = "/home/wangsiwei/DroidTvSettings.apk";
    private static final String LOCAL_PATH = "D:\\Project\\Other\\Algorithms\\src\\javas\\out";
    private static final String FILE_NAME = "DroidTvSettings.apk";

    public static void main(String[] args) {
        FtpDownloadClient client = new FtpDownloadClient(HOST_NAME, PORT, USER_NAME, PASSWORD);
        try {
            client.downloadFile(SERVER_PATH, LOCAL_PATH, FILE_NAME, new FtpDownloadClient.FtpDownloadCallback() {
                @Override
                public void onConnectSuccess() {
                    System.out.println("onConnectSuccess");
                }

                @Override
                public void onConnectFailed() {
                    System.out.println("onConnectFailed");
                }

                @Override
                public void onFileNonExistent() {
                    System.out.println("onFileNonExistent");
                }

                @Override
                public void onDownloadProgress(long progress) {
                    System.out.println("onDownloadProgress: " + progress);
                }

                @Override
                public void onDownloadCompleted() {
                    System.out.println("onDownloadCompleted");
                }

                @Override
                public void onDownloadFailed() {
                    System.out.println("onDownloadFailed");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
