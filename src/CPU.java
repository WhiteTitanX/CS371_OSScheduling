import java.util.LinkedList;

public class CPU {

    private final LinkedList<Process> processes;

    public CPU(){
        this.processes = new LinkedList<>();
    }

    public Process addProcess(Process e){
        processes.add(e);
        return e;
    }

    public void removeProcess(Process e){
        processes.remove(e);
    }

}
