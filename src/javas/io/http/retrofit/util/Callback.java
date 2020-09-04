package javas.io.http.retrofit.util;

/**
 * @author wangsw
 * @date 2020/7/2
 * TODO 这个是可以优化的，可以把返回结果封装成一个类
 */
public interface Callback {

    void onResponse(Object data, String type);

}

