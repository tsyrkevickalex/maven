package org.example.threads;

public class Test {
    public static void main(String[] args) {
        ThreadUtils.logBegin();
        MyThread myTh = new MyThread("My Thread");
        myTh.start();

        DaemonHelper deamon = new DaemonHelper();
        deamon.start();


        Thread reader = new Thread(new ReaderThread("D:\\test"));
        reader.setName("Reader Thread");
        reader.start();

        ThreadUtils.delay(3);
        myTh.disable();

        ThreadUtils.logFinish();
    }
}
