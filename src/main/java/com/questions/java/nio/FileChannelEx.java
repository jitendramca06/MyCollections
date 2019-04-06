package com.questions.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class FileChannelEx {
    public static void main(String[] args) {
        Path path = Paths.get(FileChannelEx.class.getClassLoader().getResource("temp.txt").getPath());
        write(path);
        read(path);
    }

    private static void write(Path path) {
        String data = "Hello\n";
        ByteBuffer byteBuffer = ByteBuffer.wrap(data.getBytes());
        try {
            FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            fileChannel.write(byteBuffer);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read1() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(FileChannelEx.class.getClassLoader().getResource("populate.sql").getPath(), "r");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            while (fileChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(Path path) {
        try {
            FileChannel fileChannel = FileChannel.open(path);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                byte[] bytes = byteBuffer.array();
                System.out.println(new String(bytes).trim());
                byteBuffer.clear();
            }
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
