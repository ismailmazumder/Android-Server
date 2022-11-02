package Android;

import java.util.concurrent.TimeUnit;

class make implements Runnable{
    private int count;

    public make(int count) {
        this.count = count;
    }
//    public make(int count){
//
//    }
    @Override
    public void run() {

        while(true){
            System.out.println("thread "+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class test {
    public static void main(String[] args) {
        int count = 0;
        while(true){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            make make_obj = new make(count);
            String count_str = Integer.toString(count)+"thread+obj";

            Thread thread_obj = new Thread(make_obj);
            thread_obj.start();
            count = count + 1;
            System.out.println("LOOP is running");
        }
    }
}