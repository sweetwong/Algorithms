package javas.network.http.retrofit;

/**
 * @author wangsw
 * @date 2020/9/4
 */
public class RetrofitTestDemo {

    public static void main(String[] args) {
        GankModel model = new GankModel();
        model.getBanners(result -> {
            if (!result.success()) {
                System.out.println("请求失败");
                return;
            }
            System.out.println(result.toJson());
        });
    }

}
