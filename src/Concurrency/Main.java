package Concurrency;

/**
 * Created by yuan on 16-8-19.
 */

//指令重排测试
//如果你多运行几次该程序，会发现结果中出现了pass，即有x==0，y==0的情况。
//造成这种现象的原因就是指令重排，首先我们看一下JMM的happens-before对指令重排所做的定义：

public class Main {
    static int x = 0,y = 0;
    static int a = 0,b = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i=0;i<10000;i++) {
            Thread one = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            x = 0;
            y = 0;
            a = 0;
            b = 0;

            one.start();
            other.start();
            try {
                one.join();
                other.join();
            } catch (Exception e) {
                System.out.println("exception");
            }
            if ((x==0)&&(y==0)) {
                System.out.println("pass");
            }
        }
        System.out.println("end");

    }

}