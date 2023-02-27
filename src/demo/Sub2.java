package demo;

public class Sub2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("Sub 2 i ="+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
