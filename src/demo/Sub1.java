package demo;

public class Sub1 extends Thread{
    private int min = 10;
    private int sec = 0;
    private boolean running = true;

    public Sub1(int min, int sec) {
        this.min = min;
        this.sec = sec;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(min + ":" + sec);
            sec--;
            if (sec < 0) {
                sec = 59;
                min--;
            }
            if (min < 0) {
                running = false;
            }
            try {
               Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
