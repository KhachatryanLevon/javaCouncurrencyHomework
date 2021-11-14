package com.company;

public class DeadLock implements Runnable {
    private final Object first = new Object();
    private final Object second = new Object();

    private void doFirst() throws InterruptedException {

        synchronized (first) {
            wait(1);
            System.out.println("The first one does something himself ");
        }
        synchronized (second) {
            System.out.println("The first one does something with second ");
        }
    }

    private void doSecond() {
        synchronized (second) {
            System.out.println("The second one does something himself ");
        }
        synchronized (first) {
            System.out.println("The second one does something with first ");
        }
    }

    @Override
    public void run() {
        try {
            doFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doSecond();
    }
}
