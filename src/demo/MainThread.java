package demo;

public class MainThread {
    public static void main(String[] args){
        Sub1 s1 = new Sub1(5,30);
        s1.start();
//        for(int i=0;i<20;i++){
//            System.out.println("Main i ="+i);
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e){
//
//            }
//        }
    }
}
