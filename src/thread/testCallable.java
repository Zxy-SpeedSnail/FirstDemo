package thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by yuan4j on 2016/11/14.
 */
public class testCallable implements Callable {
    private int id;

    public testCallable(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {

        return "result of TaskWithResult " + id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            Future<String> fu = executorService.submit(new testCallable(i));
            results.add(fu);
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                // 不关闭，任务不结束
                executorService.shutdown();
            }
        }
    }
}
