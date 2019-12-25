package reflect.dynamic_proxy;


class DownloadImpl implements Download {

  @Override
  public int downloadVideo() {
    System.out.println("下载视频的实际方法");
    return 50;
  }

  @Override
  public int downloadAudio() {
    System.out.println("下载音频的实际方法");
    return 100;
  }
}
