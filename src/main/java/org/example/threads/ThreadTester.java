package org.example.threads;

import java.time.LocalDate;
import java.util.Date;

public class ThreadTester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Begin");

        Thread th = Thread.currentThread();
        th.setName("Main thread");
        th.setPriority(Thread.MAX_PRIORITY);

        System.out.println( th.getId());
        System.out.println(  th.getName());
        System.out.println( th.getPriority());
        System.out.println( th.getState());

        ExtraThread extra = new ExtraThread("Extra");
        extra.setPriority(1);
        extra.start();

        for (int i = 0; i < 10; i++){
            ExtraThread extraTh = new ExtraThread("Extra th #" + i);

            extraTh.setPriority((int) (Math.random() * 10) + 1);
            extraTh.start();
        }

        extra.join(1000);


        System.out.println("End of " + th);

    }
}

class ExtraThread extends Thread {

    public ExtraThread(String name){
        this.setName(name);
        this.setPriority(10);
    }

    // own job is here
    @Override
    public void run() {
        System.out.println(this + " is Started " + new Date()) ;
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(500);
                System.out.println(this.getName() + "["+this.getPriority()+"]" + ": counter is " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " is Finished " + new Date());
    }

}
