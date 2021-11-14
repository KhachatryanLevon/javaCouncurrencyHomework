package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CreateFile extends Thread {

    public static final String BASE_PATH = "G:\\Java курсы\\JavaConcurrencyHomework\\src\\Files";

    public void run() {

        String fileName = UUID.randomUUID().toString();

        Path path = Paths.get(BASE_PATH  + UUID.randomUUID() + ".txt");
        File file = new File(BASE_PATH, fileName);
        try {

            FileWriter writer = new FileWriter(file);
            for (long i = 0; i < 10000; i++) {
                String text = UUID.randomUUID().toString();
                writer.write(text + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
