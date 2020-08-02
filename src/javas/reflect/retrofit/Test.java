package javas.reflect.retrofit;

import java.lang.reflect.*;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception {
//        HttpApi api = (HttpApi) Proxy.newProxyInstance(HttpApi.class.getClassLoader(), new Class<?>[]{HttpApi.class},
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        ParameterizedType genericReturnType = (ParameterizedType)method.getGenericReturnType();
//                    }
//                });
        Method getHome = HttpApi.class.getMethod("getHome", int.class);
        ParameterizedType genericReturnType = (ParameterizedType) getHome.getGenericReturnType();
        Type rawType = genericReturnType.getRawType();
        Type[] actualTypeArguments = genericReturnType.getActualTypeArguments();
        System.out.println(Arrays.toString(actualTypeArguments));
    }

}
