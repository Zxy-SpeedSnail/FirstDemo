package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuan4j on 2016/11/14.
 */
public class testThread implements Runnable {
    int num = 1;

    @Override
    public void run() {
        while (num < 50) {
            SingleTon singleton = SingleTon.getInstance();
            System.out.println(singleton.toString());
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
//        new testThread().run();
        for (int i = 0; i < 2; i++) {
            exec.execute(new testThread());
//            testThread t = new testThread();

//            Thread thread = new Thread(t);
//            thread.start();
            System.out.println("这是第" + i + "个线程");
        }
        exec.shutdown();
//        System.out.println("这句话为啥先打印");
    }
}
