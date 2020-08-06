package javas.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private ReentrantLock mLock = new ReentrantLock();

    private Condition mCondition = mLock.newCondition();

    public void go() {
    }

}
