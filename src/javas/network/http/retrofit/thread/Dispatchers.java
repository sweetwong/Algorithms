package javas.network.http.retrofit.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangsw
 * @date 2020/9/11
 */
public class Dispatchers {

    private static ExecutorService sExecutor = Executors.newFixedThreadPool(3);

    public static ExecutorService io() {
        return sExecutor;
    }

}
