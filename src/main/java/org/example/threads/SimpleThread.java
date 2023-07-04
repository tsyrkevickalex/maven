package org.example.threads;

public class SimpleThread {
    public static void main(String[] args) {
        ThreadUtils.logBegin();
        ThreadUtils.delay(5);
        ThreadUtils.logJob("JOB");
        ThreadUtils.delay(5);
        ThreadUtils.logFinish();
    }
}
