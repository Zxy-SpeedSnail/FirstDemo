package book;

import java.util.Stack;

/**
 * Created by yuan on 2017/7/13.
 */
public class ReversStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);

        System.out.println(insert(s));


    }
    public static Stack<Integer> insert(Stack<Integer> s){
        if(s.isEmpty()){
            return null;
        }
        int tem = s.pop();
        insert(s);
        s.add(tem);
        return s;
    }
}
