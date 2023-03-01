package demo;

public class MainThread2 {
    public static void main(String[] args){
        Number n = new Number();
        Number n2 = new Number();

        Runnable r = ()->{
            for (int i=0;i<20;i++){
//                synchronized (n){
                    n.update();
                    n.print();
//                }
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        };

        new Thread(r).start();
        new Thread(r).start();

    }
}
