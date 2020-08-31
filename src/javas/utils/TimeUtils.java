package javas.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangsw
 * @date 2020/8/31
 */
public class TimeUtils {

    private static Map<String, Long> sRepeatMap = new HashMap<>();

    /**
     * @param interval 两次重复的间隔时间
     * @return 如果重复就返回true，没有重复返回false
     */
    public static boolean checkRepeat(long interval) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[3];
        String key = element.toString();
        Long prev = sRepeatMap.get(key);
        boolean repeat = prev != null && System.currentTimeMillis() < prev;
        if (!repeat) {
            sRepeatMap.put(key, System.currentTimeMillis() + interval);
        }
        return repeat;
    }

}
