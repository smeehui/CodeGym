package org.example;
public class StopWatch {
    private long startTime,endTime;
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public long getElapsedTime(){
        return this.getEndTime() - this.getStartTime();
    }
}
