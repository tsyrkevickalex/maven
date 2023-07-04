package org.example.threads.synch;


import org.example.threads.ThreadUtils;

class Tester {
    public static void main(String[] args) {
        Store2 store2= new Store2();
        new Producer2(store2).start();
        new Consumer2(store2, "Consumer1").start();
        new Consumer2(store2, "Consumer2").start();
        new Consumer2(store2, "Consumer3").start();

    }
}

public class Store2 {

    private int product = 0;
    public synchronized void get(){
        while (product < 1){
            try {
                ThreadUtils.logJob("Start Waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        ThreadUtils.logJob("Consume 1 product...");
        ThreadUtils.logJob("Store products:" + product);
        notify();
    }

    public synchronized void put(){
        while (product >= 15){
            try {
                ThreadUtils.logJob("Start Waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadUtils.delay(2);
        product += 15 ;
        ThreadUtils.logJob("Producer add 15 product...");
        ThreadUtils.logJob("Store products:" + product);
        notifyAll();//notify();
    }


}

class Consumer2 extends Thread {
    private Store2 store;

    public Consumer2(Store2 store, String name){
        this.store = store;
        setName(name);
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
        for (int i = 0; i < 5; i++){
            ThreadUtils.delay(0.1);
            store.get();
        }
        ThreadUtils.logFinish();
    }
}

class Producer2 extends Thread {
    private Store2 store;
    public Producer2(Store2 store){
        this.store = store;
        setName("Producer2");
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
      //  for (int i = 0; i < 15; i++){
        //    ThreadUtils.delay(0.2);
            store.put();
      //  }
        ThreadUtils.logFinish();
    }
}
