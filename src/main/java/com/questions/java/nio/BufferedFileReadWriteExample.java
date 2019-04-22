package com.questions.java.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jitendra Kumar : 9/4/19
 */
public class BufferedFileReadWriteExample {
    public static void main(String[] args) {
        writeIntoAFile();
        readFile();
    }

    private static void readFile() {
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(BufferedFileReadWriteExample.class.getClassLoader().getResource("temp.txt").getPath());
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path, charset);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIntoAFile() {
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(BufferedFileReadWriteExample.class.getClassLoader().getResource("temp.txt").getPath());
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path, charset);
            String data = "Hello How Are You?";
            bufferedWriter.write(data, 0, data.length());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
