package demo;

import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class Timer {

    public Text lbMin;
    public Text lbSec;

    public Integer min = 10;
    public Integer sec = 0;

    boolean running = false;

    public void start(ActionEvent actionEvent) {
        if(!running){
           running = true;
           new Thread(()->{
               while(running){
                   String min_txt = min>=10?min.toString():"0"+min;
                   String sec_txt = sec>=10?sec.toString():"0"+sec;
                   lbMin.setText(min_txt);
                   lbSec.setText(sec_txt);
                   sec--;
                   if(sec<0){
                       sec = 59;
                       min--;
                   }
                   if(min<0){
                       running = false;
                   }
                   try{
                      Thread.sleep(1000);
                   }catch (Exception e){

                   }
               }
           }).start();
        }
    }

    public void pause(ActionEvent actionEvent) {
    }

    public void stop(ActionEvent actionEvent) {
    }
}
