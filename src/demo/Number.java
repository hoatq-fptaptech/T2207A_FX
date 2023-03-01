package demo;

public class Number {
    int x = 0;
    int y = 0;

    int z= 0;

    public synchronized void update(){
        x++;
        y++;
    }

    public synchronized void print(){
        System.out.println("x="+x);
        System.out.println("y="+y);
    }

    public void updateZ(){
        z++;
    }

    public void printZ(){
        System.out.println("z="+z);
    }
}
