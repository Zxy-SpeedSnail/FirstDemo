package book;

/**
 * Created by yuan on 2017/7/13.
 */
public class OfTwo {
    public static void main(String[] args) {
        System.out.println(turnOfTwo(4));
    }
    public static boolean turnOfTwo(int val){
        return (val & - val) == val;
    }
}
