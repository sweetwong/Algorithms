package javas.network.http.retrofit;

/**
 * @author wangsw
 * @date 2020/9/11
 */
public interface Callback<T> {

    void onResponse(Result<T> result);
}
