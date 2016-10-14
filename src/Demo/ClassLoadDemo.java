package Demo;

/**
 * Created by yuan on 16-8-1.
 */
public class ClassLoadDemo {
    public static void main(String[] args) {

        ClassLoader sysClass = ClassLoader.getSystemClassLoader();
        System.out.println(sysClass);

//        ClassLoader classLoader = ClassLoader.getSystemResource();

    }
}
