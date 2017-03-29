package HeadFirst;


/**
 * Created by yuan4j on 2017/3/29.
 */
public class NoonState extends State {
    @Override
    public void WriteProgram(Work work) {
        if(work.Hour<13){
            System.out.println("当前时间:"+work.Hour);
        }else {
            work.SetState(new AfterNoonState());
            work.WriteProgram();
        }
    }
}
