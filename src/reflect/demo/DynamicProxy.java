package reflect.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxy {

  public static void main(String[] args) {
    Download realDownload = new DownloadImpl();

    // 注意, 动态代理只能代理接口, 不能代理类
    Download proxyDownload = (Download) Proxy.newProxyInstance(
      DownloadImpl.class.getClassLoader(),
      DownloadImpl.class.getInterfaces(),
      new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          System.out.println("开始下载");
          Object result = method.invoke(realDownload, args);
          System.out.println("完成下载");
          return result;
        }
      });

    int time = proxyDownload.downloadAudio();
    System.out.println(time);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println();

    proxyDownload.downloadVideo();
  }
}
