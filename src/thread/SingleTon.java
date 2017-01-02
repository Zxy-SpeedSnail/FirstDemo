package thread;

/**
 * Created by yuan4j on 2016/11/24.
 */
public class SingleTon {
    private static SingleTon singleTon;
    private SingleTon(){

    }

    public static SingleTon getInstance(){
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}
