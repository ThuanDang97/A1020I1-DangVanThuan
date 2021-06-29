package B4_Class_And_OOP.BaiTap;


public class StopWatch {

    private long startTime;
    private long stopTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
        this.stopTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.stopTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return (this.stopTime - this.startTime);
    }

}
