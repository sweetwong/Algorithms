package javas.io.http.retrofit.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

/**
 * treat empty string "" as null
 *
 * for example:
 * {
 *     "reason": ""
 * }
 *
 * to
 *
 * {
 *     "reason": null
 * }
 *
 * @author wangsw
 * @date 2020/7/2
 */
public class GsonStringNullAdapter<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonPrimitive()) {
            final JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive();
            if (jsonPrimitive.isString() && jsonPrimitive.getAsString().isEmpty()) {
                return null;
            }
        }
        return context.deserialize(json, typeOfT);
    }
}
