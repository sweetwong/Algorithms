package design_pattern.singleton;

/**
 * 懒汉式, 双重检测, 安全, 高效
 */
public class DoubleChecked {

    // 注意需要添加volatile, 为了保证可见性, 防止指令重排序
    private volatile static DoubleChecked instance;

    private DoubleChecked() {
    }

    public static DoubleChecked getInstance() {
        if (instance == null) {
            synchronized (DoubleChecked.class) {
                if (instance == null) {
                    // 此操作为非原子操作, 分为3步:  1.分配内存  2.初始化对象  3.赋值
                    // 在编译器运行时, 可能会发生重排序, 例如1-2-3变成1-3-2

                    // 如果不加上volatile
                    // 假设有两个线程A和B
                    // A执行了1和3, 正要执行2时线程调度到B
                    // B会判断instance不为空, 但是A并没有执行2, 就出现空指针异常
                    instance = new DoubleChecked();
                }
            }
        }
        return instance;
    }
}
