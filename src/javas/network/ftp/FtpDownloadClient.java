package javas.network.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FtpDownloadClient {

    private String mHostName;
    private int mServerPort = 21;
    private String mUserName;
    private String mPassword;
    private FTPClient mFtpClient;

    public FtpDownloadClient(String hostName, int serverPort, String userName, String password) {
        this.mHostName = hostName;
        this.mServerPort = serverPort;
        this.mUserName = userName;
        this.mPassword = password;
        this.mFtpClient = new FTPClient();
    }

    public FtpDownloadClient(String hostName, String userName, String password) {
        this.mHostName = hostName;
        this.mUserName = userName;
        this.mPassword = password;
        this.mFtpClient = new FTPClient();
    }

    /**
     * 下载单个文件，可实现断点下载.
     *
     * @param serverPath Ftp目录及文件路径
     * @param localPath  本地目录
     * @param fileName   下载之后的文件名称
     * @param callback   监听器
     * @throws IOException
     */
    public void downloadFile(String serverPath, String localPath, String fileName, FtpDownloadCallback callback)
            throws Exception {
        //连接FTP服务器
        try {
            openFtpConnect();
            callback.onConnectSuccess();
        } catch (IOException e1) {
            e1.printStackTrace();
            callback.onConnectFailed();
            return;
        }

        //切到指定目录
        if (serverPath.contains("/")) {
            int lastIndex = serverPath.lastIndexOf("/") + 1;
            mFtpClient.changeWorkingDirectory(serverPath.substring(0, lastIndex));
            serverPath = serverPath.substring(lastIndex);
        }

        //判断文件是否存在
        FTPFile[] files = mFtpClient.listFiles();
        if (files.length == 0) {
            callback.onFileNonExistent();
            return;
        }

        //创建本地文件
        File mkFile = new File(localPath);
        if (!mkFile.exists()) {
            mkFile.mkdirs();
        }
        localPath = localPath + fileName;

        // 获取远程文件的长度
        long serverSize = 0;
        for (FTPFile file : files) {
            if (serverPath.equals(file.getName())) {
                serverSize = file.getSize();
                break;
            }
        }

        // 接着判断下载的文件是否能断点下载
        File localFile = new File(localPath);
        long localSize = 0;
        if (localFile.exists()) {
            localSize = localFile.length(); // 如果本地文件存在，获取本地文件的长度
            if (localSize > serverSize) {
                localFile.delete();
                localSize = 0;
            }
        }

        // 进度
        long step = serverSize / 100;
        long process = 0;
        long currentSize = 0;
        // 开始准备下载文件
        OutputStream out = new FileOutputStream(localFile, true);
        mFtpClient.setRestartOffset(localSize);
        InputStream input = mFtpClient.retrieveFileStream(serverPath);
        byte[] b = new byte[1024];
        int length = 0;
        while ((length = input.read(b)) != -1) {
            out.write(b, 0, length);
            currentSize = currentSize + length;
            if (currentSize / step != process) {
                process = currentSize / step;
                callback.onDownloadProgress(process);
            }
        }
        out.flush();
        out.close();
        input.close();

        // 此方法是来确保流处理完毕，如果没有此方法，可能会造成现程序死掉
        if (mFtpClient.completePendingCommand()) {
            callback.onDownloadCompleted();
        } else {
            callback.onDownloadFailed();
        }

        // 下载完成之后关闭连接
        this.closeFtpConnect();
    }

    /**
     * 打开FTP服务.
     *
     * @throws IOException
     */
    private void openFtpConnect() throws IOException {
        // 中文转码
        mFtpClient.setControlEncoding("UTF-8");
        int reply; // 服务器响应值
        // 连接至服务器
        mFtpClient.connect(mHostName, mServerPort);
        // 获取响应值
        reply = mFtpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            // 断开连接
            mFtpClient.disconnect();
            throw new IOException("connect fail: " + reply);
        }
        // 登录到服务器
        mFtpClient.login(mUserName, mPassword);
        // 获取响应值
        reply = mFtpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            // 断开连接
            mFtpClient.disconnect();
            throw new IOException("connect fail: " + reply);
        } else {
            // 获取登录信息
            FTPClientConfig config = new FTPClientConfig(mFtpClient
                    .getSystemType().split(" ")[0]);
            config.setServerLanguageCode("zh");
            mFtpClient.configure(config);
            // 使用被动模式设为默认
            mFtpClient.enterLocalPassiveMode();
            // 二进制文件支持
            mFtpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
        }
    }

    /**
     * Disconnect FTP server and release resource
     *
     * @throws IOException
     */
    private void closeFtpConnect() throws IOException {
        if (mFtpClient != null) {
            mFtpClient.logout();
            mFtpClient.disconnect();
        }
    }

    public interface FtpDownloadCallback {
        void onConnectSuccess();

        void onConnectFailed();

        void onFileNonExistent();

        void onDownloadProgress(long progress);

        void onDownloadCompleted();

        void onDownloadFailed();
    }
}
