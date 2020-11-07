import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    // takes one parameter, average value, and returns a random number in an
    // exponential distribution around that expected average value
    static int expRand (int expected) {
        return (int)(-expected * Math.log(Math.random()));
    }

    static int randomNumber() {
        Random r = new Random();
        int rNumber = r.nextInt(100)+1;
        return rNumber;
    }

    // same as above, but I use a bit of arithmetic to round the result to the
    // nearest .0001 (in the OS program that would be 100 microseconds)
    static double expRandRound ( double expected ) {
        double nice = -expected * Math.log( Math.random());
        nice *= 10000; // move decimal point 5 digits over  eg. 1.234567 -> 12345.67
        nice = (int) nice; // chop off any remaining decimal    12345.67 -> 12345.0
        nice /= 10000; // now move the decimal point back       12345.0  -> 1.2345
        return nice;
    }

    public static void main(String[] args){

        int total_simulation_time = 0; // in seconds
        int quantum_size = 0; // in microseconds
        int context_switch_time = 0; // in microseconds
        int avg_process_length = 0; // in microseconds
        int avg_process_creation = 0; // in microseconds
        int percent_io_jobs = 0; // percentage
        int avg_io_interrupt = 0; // microseconds

        try{
            FileReader fr = new FileReader("params1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int counter = 0;

            while((line = br.readLine()) != null){
                if(!line.startsWith("#")){
                    int part = Integer.parseInt(line.split(" ")[0]);
                    switch (counter) {
                        case 0 -> total_simulation_time = part;
                        case 1 -> quantum_size = part;
                        case 2 -> context_switch_time = part;
                        case 3 -> avg_process_length = part;
                        case 4 -> avg_process_creation = part;
                        case 5 -> percent_io_jobs = part;
                        case 6 -> avg_io_interrupt = part;
                    }
                    ++counter;
                }
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException e){
            System.err.println("File not found!");
            return;
        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        total_simulation_time *= 1000000;

        LinkedList<Event> eventQueue = new LinkedList<>(); // First in, first out
        LinkedList<Process> readyQueue = new LinkedList<>();

        int pidGen = 0;
        long timer = 0;

        Event firstEvent = new Event("N", 0);
        eventQueue.push(firstEvent);

        Random r = new Random();

        while(timer < total_simulation_time){
            Event e = eventQueue.pop();
            timer = e.getTime();

            switch(e.getType()){
                case "N": // Create a new process
                    //time when next process will be created
                    int next_process = expRand(avg_process_creation);
                    //total CPU time of the process
                    int total_CPU_time = expRand(avg_process_length);
                    int randomNumber = randomNumber();
                    int cpuBurst;
                    if (randomNumber < percent_io_jobs) {
                        cpuBurst = r.nextInt(1001)+1000;
                    } else {
                        cpuBurst = r.nextInt(10001)+10000;
                    }
                    readyQueue.push(new Process(next_process, total_CPU_time, cpuBurst));
                    break;
            }
        }


    }
}
