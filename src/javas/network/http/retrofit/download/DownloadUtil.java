package javas.network.http.retrofit.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javas.network.http.retrofit.HttpUtils;
import javas.network.http.retrofit.api.DownloadApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description：下载文件工具类
 * Created by kang on 2018/3/9.
 *
 * https://juejin.im/post/6844903601341464589
 */

public class DownloadUtil {

    private static final String TAG = "DownloadUtil";
    private static final String PATH_CHALLENGE_VIDEO = "src/";
    //视频下载相关
    private static Call<ResponseBody> sCall;
    private static File sFile;
    private static Thread sThread;
    private static String sVideoPath; //下载到本地的视频路径

    public static void downloadFile(String url, final DownloadListener downloadListener) {
        DownloadApi api = HttpUtils.getDownloadApi();

        //通过Url得到保存到本地的文件名
        String name = url;
        if (FileUtils.createOrExistsDir(PATH_CHALLENGE_VIDEO)) {
            int i = name.lastIndexOf('/');//一定是找最后一个'/'出现的位置
            if (i != -1) {
                name = name.substring(i);
                sVideoPath = PATH_CHALLENGE_VIDEO +
                        name;
            }
        }
        if (sVideoPath == null || sVideoPath.isEmpty()) {
            System.out.println("downloadVideo: 存储路径为空了");
            return;
        }
        //建立一个文件
        sFile = new File(sVideoPath);
        if (!FileUtils.isFileExists(sFile) && FileUtils.createOrExistsFile(sFile)) {
            if (api == null) {
                System.out.println("downloadVideo: 下载接口为空了");
                return;
            }
            sCall = api.downloadFile(url);
            sCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                    //下载文件放在子线程
                    sThread = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            //保存到本地
                            writeFile2Disk(response, sFile, downloadListener);
                        }
                    };
                    sThread.start();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    downloadListener.onFailure("网络错误！");
                }
            });
        } else {
            downloadListener.onFinish(sVideoPath);
        }
    }

    private static void writeFile2Disk(Response<ResponseBody> response, File file, DownloadListener downloadListener) {
        downloadListener.onStart();
        long currentLength = 0;
        OutputStream os = null;

        if (response.body() == null) {
            downloadListener.onFailure("资源错误！");
            return;
        }
        InputStream is = response.body().byteStream();
        long totalLength = response.body().contentLength();

        try {
            os = new FileOutputStream(file);
            int len;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
                currentLength += len;
                System.out.println("当前进度: " + currentLength);
                downloadListener.onProgress((int) (100 * currentLength / totalLength));
                if ((int) (100 * currentLength / totalLength) == 100) {
                    downloadListener.onFinish(sVideoPath);
                }
            }
        } catch (FileNotFoundException e) {
            downloadListener.onFailure("未找到文件！");
            e.printStackTrace();
        } catch (IOException e) {
            downloadListener.onFailure("IO错误！");
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
