package java.reflect.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxy {

  public static void main(String[] args) {
    // 只有一个地方用到了这个
    Download realDownload = new DownloadImpl();

    // 注意, 动态代理只能代理接口, 不能代理类
    Download proxyDownload = (Download) Proxy.newProxyInstance(
      Download.class.getClassLoader(),
      new Class<?>[]{Download.class},
      new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          System.out.println("开始下载");
          Object result = method.invoke(realDownload, args);
          System.out.println("完成下载");
          return result;
        }
      });

    int audioTime = proxyDownload.downloadAudio();
    System.out.println(audioTime);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println();

    int videoTime = proxyDownload.downloadVideo();
    System.out.println(videoTime);
  }
}
