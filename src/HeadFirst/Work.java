package HeadFirst;

/**
 * Created by yuan4j on 2017/3/29.
 */
public class Work {
    private State current;
    public Work(){
        current = new ForenoonState();//初始化工作状态  上午
    }

    private double hour;
    public double Hour;

    public void setHour(double hour) {
        this.hour = hour;
    }
    public double getHour() {
        return hour;
    }

    private boolean finish = false;

    public boolean isFinish() {
        return finish;
    }
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void SetState(State state){
        current = state;
    }
    public void WriteProgram(){
        current.WriteProgram(this);
    }
}
