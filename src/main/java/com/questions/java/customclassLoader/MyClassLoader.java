package com.questions.java.customclassLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jitendra Kumar : 10/5/19
 */
public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassMyClass(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassMyClass(String classPath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(classPath.replace(".", "/") + ".class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        try {
            while ((len = inputStream.read()) != -1) {
                byteArrayOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> clss = myClassLoader.findClass("com/questions/java/customclassLoader.ClassToBeLoaded");
            Object obj = clss.newInstance();
            Method method = clss.getMethod("getName");
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
