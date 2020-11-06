import java.util.Date;

public class Event {

    private final String type;
    private final int time;

    public Event(String type, int time){
        this.type = type;
        this.time = time;
    }

    public String getType(){
        return this.type;
    }

    public int getTime(){
        return this.time;
    }

}
