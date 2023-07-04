package org.example.threads.synch;

import org.example.threads.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Resource {

    private List<Long> ids = new ArrayList<>();//new ArrayList<>(); new Vector<>()

    public List<Long> getIds() {
        return ids;
    }
}

class User implements Runnable {

    private Resource resource;

    public User(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();

      synchronized (resource){
          resource.getIds().clear();
          for(int i = 0; i < 10; i++){
              String data =  resource.getIds().toString();
              ThreadUtils.logJob("OWN LIST("+resource.getIds().size()+"): " + data);
              resource.getIds().add(Thread.currentThread().getId());
              ThreadUtils.delay(0.3);
          }
      }

      //  synchJob();
        ThreadUtils.logFinish();
    }

//    private synchronized void synchJob(){
//        resource.getIds().clear();
//        for(int i = 0; i < 10; i++){
//            String data =  resource.getIds().toString();
//            ThreadUtils.logJob("OWN LIST("+resource.getIds().size()+"): " + data);
//            resource.getIds().add(Thread.currentThread().getId());
//            ThreadUtils.delay(0.3);
//        }
//    }


}

class SynchRunner {
    public static void main(String[] args) {
        ThreadUtils.logBegin();
        Resource res = new Resource();

        for(int i = 0; i < 10; i++){
            Thread th = new Thread(new User(res));
            th.setName("User #" + i);
            th.start();
        }

        ThreadUtils.logFinish();
    }
}
