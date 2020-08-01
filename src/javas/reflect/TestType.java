package javas.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

public class TestType {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = DouBanApi.class;
        Method getHome = clazz.getMethod("getHome", Map.class);
        Type genericReturnType = getHome.getGenericReturnType();
        Type[] genericParameterTypes = getHome.getGenericParameterTypes();
        System.out.println(genericReturnType);
        System.out.println(Arrays.toString(genericParameterTypes));
    }

}
