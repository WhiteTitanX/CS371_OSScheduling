public class Process {

    private int cpu_time_remaining, current_cpu_burst_remaining, time_spent_on_cpu,
    time_spent_on_io, time_spent_in_ready_queue, io_request_count, pid, time_new_process, cpu_total, cpu_burst;

    public Process(int pid){
        this.pid = pid;
    }

    public Process(int time_new_process, int cpu_total, int cpu_burst) {
        this.time_new_process = time_new_process;
        this.cpu_total = cpu_total;
        this.cpu_burst = cpu_burst;
    }

    public int getCpu_time_remaining() {
        return cpu_time_remaining;
    }

    public void setCpu_time_remaining(int cpu_time_remaining) {
        this.cpu_time_remaining = cpu_time_remaining;
    }

    public int getCurrent_cpu_burst_remaining() {
        return current_cpu_burst_remaining;
    }

    public void setCurrent_cpu_burst_remaining(int current_cpu_burst_remaining) {
        this.current_cpu_burst_remaining = current_cpu_burst_remaining;
    }

    public int getTime_spent_on_cpu() {
        return time_spent_on_cpu;
    }

    public void setTime_spent_on_cpu(int time_spent_on_cpu) {
        this.time_spent_on_cpu = time_spent_on_cpu;
    }

    public int getTime_spent_on_io() {
        return time_spent_on_io;
    }

    public void setTime_spent_on_io(int time_spent_on_io) {
        this.time_spent_on_io = time_spent_on_io;
    }

    public int getTime_spent_in_ready_queue() {
        return time_spent_in_ready_queue;
    }

    public void setTime_spent_in_ready_queue(int time_spent_in_ready_queue) {
        this.time_spent_in_ready_queue = time_spent_in_ready_queue;
    }

    public int getIo_request_count() {
        return io_request_count;
    }

    public void setIo_request_count(int io_request_count) {
        this.io_request_count = io_request_count;
    }
}
