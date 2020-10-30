package javas.concurrent;

import data_structure.other.Time;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum {

    static class SumTask extends RecursiveTask<Long> {

        long start;
        long end;

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // 注意：ForkJoin 适合每个子任务都是大任务的场景，而不是分成很多很小的子任务，这样反而增加了额外的创建对象的开销
            if (end - start < 1000000L) {
                long sum = 0L;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }

            long mid = end + start >>> 1L;

            SumTask task1 = new SumTask(start, mid);
            SumTask task2 = new SumTask(mid + 1L, end);

            task1.fork();
            task2.fork();

            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) {
        Time.watch(() -> {
            Long res = new ForkJoinPool(6).invoke(new SumTask(0L, 10000000000L));
        });

        Time.watch(() -> {
            long sum = 0L;
            for (long i = 0L; i <= 10000000000L; i++) {
                sum += i;
            }
        });
    }


}
