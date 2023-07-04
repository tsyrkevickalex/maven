package org.example.threads.synch;


import org.example.threads.ThreadUtils;

class ProducerConsumerTask {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();

    }
}

public class Store {
    private int counter = 0; // number of products
    private int max = 5; //  max number of products

    // producer method
    synchronized int put(){
        if(counter <= max){
            counter++;
            ThreadUtils.logJob("Store number of products: " + counter + "  | PUT");
            return 1;
        }
        return 0;//
    }

    // consumer method
    synchronized int get(){
        if(counter > 0){
            counter--;
            ThreadUtils.logJob("Store number of products: " + counter + " | GET");
            return 1;
        }
        return 0; //
    }

}


class Producer extends Thread {
    private Store store;
    private int product = 5;

    public Producer(Store store){
        this.store = store;
        setName("Producer");
    }

    @Override
    public void run() {
       while (product > 0){
           product -= store.put();
           System.out.println(getName() + " Left to produce "+product+" (products)");
           ThreadUtils.delay(0.2);
       }
    }
}


class Consumer extends Thread {
    private Store store;
    private int product = 0;

    public Consumer(Store store){
        this.store = store;
        setName("Consumer");
    }

    @Override
    public void run() {
        while (product < 5){
            product += store.get();
            System.out.println(getName() + " Left to consume "+(5 -product)+" (products)");
            ThreadUtils.delay(0.1);
        }
    }
}