package com.questions.java.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jitendra Kumar : 7/4/19
 */
public class PathExample {
    public static void main(String[] args) {
        // Relative path
        Path path1 = FileSystems.getDefault().getPath("etc", "test.txt");

        // Absolute path
        Path path2 = Paths.get("/home/jitendrak/Desktop");

        // Current working directory
        Path path3 = Paths.get("").toAbsolutePath();
        System.out.println(path3.toAbsolutePath());

        // Resolve path
        Path path4 = Paths.get("/home/jitendrak/Desktop");
        // Output is /home/jitendrak/Desktop/conf.prop
        System.out.println(path1.resolve("conf.prop"));

        // relativize
        Path path5 = Paths.get("/home/jitendrak/Desktop");
        Path path6 = Paths.get("/home/jitendrak/Desktop/ProtocFiles");
        // outcome is ProtocFiles
        Path path5_to_path6 = path5.relativize(path6);
        System.out.println(path5_to_path6);
        // outcome is ..
        Path path6_to_path5 = path6.relativize(path5);
        System.out.println(path6_to_path5);
    }
}
