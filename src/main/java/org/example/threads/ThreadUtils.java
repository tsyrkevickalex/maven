package org.example.threads;

import java.util.Date;

public class ThreadUtils {


    public static void join(Thread thread) {
        join(thread, 0);
    }

    public static void join(Thread thread, int sec){
        try {
            thread.join((long)(sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delay(double sec){
        try {
            Thread.sleep((long)(sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void logBegin(){
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + "["+th.getId()+"] is started " + new Date());
    }

    public static void logJob(Object o){
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + "["+th.getId()+"]["+new Date()+"]: " + o );
    }

    public static void logFinish(){
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + "["+th.getId()+"] is finished " + new Date());
    }

}
