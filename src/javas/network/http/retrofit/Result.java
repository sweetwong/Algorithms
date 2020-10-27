package javas.network.http.retrofit;

import javas.utils.GsonUtils;

/**
 * @author wangsw
 * @date 2020/9/11
 */
public class Result<T> {

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILURE = 1;
    public static final int TYPE_EXCEPTION = 2;

    public static Result FAILURE = new Result(TYPE_FAILURE);
    public static Result EXCEPTION = new Result(TYPE_EXCEPTION);

    private T data;
    private int type;

    public Result(T data) {
        this(data, TYPE_SUCCESS);
    }

    public Result(int type) {
        this(null, type);
    }

    public Result(T data, int type) {
        this.data = data;
        this.type = type;
    }

    public boolean success() {
        return type == TYPE_SUCCESS;
    }

    public T getData() {
        return data;
    }

    public int getType() {
        return type;
    }

    public String toJson() {
        return GsonUtils.toJson(data);
    }

}
