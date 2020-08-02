package javas.reflect.retrofit;

public interface HttpApi {

    @GET("https://www.baidu.com")
    Observable<String> getHome(int id);

}
