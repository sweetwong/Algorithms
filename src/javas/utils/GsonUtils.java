package javas.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonUtils {

    private static Gson sGson;
    static {
        sGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public static String toJson(Object src) {
        return sGson.toJson(src);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return sGson.fromJson(json, typeOfT);
    }


}
