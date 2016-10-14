import java.io.IOException;

/**
 * Created by yuan on 16-8-22.
 */
public class SysInRead {
    public static void main(String[] args) throws IOException {
        int a = 0;
        a = System.in.read();
        System.in.getClass();
        System.out.println("a="+a);
        int sum = 0;
        for(int i=0;i<=a;i++){
            sum += i;
            System.out.println(sum);
        }
    }
}
