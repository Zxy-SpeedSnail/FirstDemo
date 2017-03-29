package HeadFirst;


/**
 * Created by yuan4j on 2017/3/29.
 */
//状态模式,当一个对象的内在状态改变时,允许改变其行为,这个对象看起来像是改变了其类。
public class ForenoonState extends State {
    @Override
    public void WriteProgram(Work work) {
        if (work.Hour < 12) {
            System.out.println("当前时间:" + work.Hour + "上午");
        }else {
            work.SetState(new NoonState());
            work.WriteProgram();
        }
    }
}
