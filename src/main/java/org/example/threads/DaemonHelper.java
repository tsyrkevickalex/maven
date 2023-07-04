package org.example.threads;

import org.example.swing.XMLCurrencyParser;

public class DaemonHelper extends Thread {

    public DaemonHelper(){
        setDaemon(false);
        setName("Daemon Thread");
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();
        while (true){
            String usdStrValue = XMLCurrencyParser.getCurrency("USD");
            ThreadUtils.logJob("USD CURRENCY Rate is " + usdStrValue);
            ThreadUtils.delay(0.2);
        }

        //ThreadUtils.logFinish();
    }
}
