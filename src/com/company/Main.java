package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*
        // Задание N1
        long start = System.currentTimeMillis();
        System.out.println(start);

        long number1 = 100000000;
        long number2 = 50000000;
        System.out.println(sum(0, number1));

        long finish = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(finish);
        System.out.println(finish - start);

        List<Long> list = new ArrayList<>();

        long start1 = System.currentTimeMillis();
        System.out.println(start1);
        Thread runnable1 = new Thread() {
            @Override
            public void run() {
                list.add(0, sum(0, number2));

            }
        };
        Thread runnable2 = new Thread() {

            @Override
            public void run() {
                list.add(1, sum(number2, number1));
            }
        };

        runnable1.run();
        runnable2.run();

        //System.out.println(list);
        long sum = list.get(0) + list.get(1);
        long finish1 = System.currentTimeMillis();
        System.out.println(finish1);
        System.out.println(sum);
        System.out.println(finish1 - start1);


         */


        /*
        // Задание N2
        // Создание 10 файлов одним потоком
        long start = System.currentTimeMillis();
        System.out.println("start " + start);
        for (int i = 0; i < 10; i++) {
            createFile();
        }
        long finish = System.currentTimeMillis();
        System.out.println("finish " + finish);
        System.out.println("time " + (finish - start));


        // Создание 10 файлов десятью потоками

        long start2 = System.currentTimeMillis();
        System.out.println("start " + start2);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> createFile());
            thread.start();
            thread.join();
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("finish " + finish2);
        System.out.println("time " + (finish2 - start2));

        // Вариант N2 -  через класс
        long start = System.currentTimeMillis();
        System.out.println("start " + start);
        for (int i = 0; i < 10; i++) {
            CreateFile createFile = new CreateFile();
            createFile.start();
            createFile.join();
        }
        long finish = System.currentTimeMillis();
        System.out.println("finish " + finish);
        System.out.println("time " + (finish - start));

         */

        /* Реализация DeadLock
        DeadLock deadLock = new DeadLock();
        Thread thread = new Thread(deadLock);
        Thread thread1 = new Thread(deadLock);
        thread.start();
        thread.join();
        thread1.start();
        thread1.join();

         */

    }

    public static long sum(long start, long finish) {
        long sum = 0;
        for (long i = start; i < finish; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void createFile() {
        final String BASE_PATH = "G:\\Java курсы\\JavaConcurrencyHomework\\src\\Files";
        String fileName = UUID.randomUUID().toString();

        Path path = Paths.get(BASE_PATH + UUID.randomUUID() + ".txt");
        File file = new File(BASE_PATH, fileName);
        try {

            FileWriter writer = new FileWriter(file);
            for (long i = 0; i < 100000; i++) {
                String text = UUID.randomUUID().toString();
                writer.write(text + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

