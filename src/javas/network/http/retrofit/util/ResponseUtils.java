package javas.network.http.retrofit.util;

/**
 * @author wangsw
 * @date 2020/7/2
 */
public class ResponseUtils {

    public static boolean success(String type) {
        return ResponseType.SUCCESS.equals(type);
    }

}
