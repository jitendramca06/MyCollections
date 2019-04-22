package com.questions.java.nio;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author Jitendra Kumar : 14/4/19
 */
public class StreamFileReadWrite {
    public static void main(String[] args) throws IOException {
        readFile();
        writeIntoFile();
        readFile();
    }

    private static void readFile() throws IOException {
        Path path = FileSystems.getDefault().getPath(".", "/src/main/resources/temp.txt");
        InputStream inputStream = Files.newInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line=bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        inputStream.close();
    }

    private static void writeIntoFile() throws IOException {
        Path path = FileSystems.getDefault().getPath(".", "/src/main/resources/temp.txt");
        OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.WRITE);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String s = "HI";
        writer.write(s, 0, s.length());
        writer.close();
        outputStream.close();
    }
}
