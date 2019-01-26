package com.questions.java.thread.executor;

import java.util.concurrent.*;

/**
 * Created by jitendra on 08 Mar, 2018
 */
/*
To get an ExecutorService, you call an appropriate static method of the java.util.concurrent.Executors class.
Since we need a cached thread pool, we call the static newCachedThreadPool() method.

So what are the benefits of using a cached thread pool ? Well, the docs state them as follows:

The pool creates new threads if needed but reuses previously constructed threads if they are available.

Cached thread pool helps improve the performance of applications that make many short-lived asynchronous tasks.

Only if no threads are available for reuse will a new thread be created and added to the pool.

Threads that have not been used for more than sixty seconds are terminated and removed from the cache. Hence a
pool which has not been used long enough will not consume any resources.

So without further ado let’s have a look at obtaining an ExecutorService instance and use it to run a few threads.
The below line of code will get you a cached thread pool that is ready to roll.

ExecutorService cachedPool = Executors.newCachedThreadPool();

To submit a task for execution, you call the submit()method. There are three overloaded submit methods, all of
which return a Future<> (I am skipping the type parameter here on purpose; you will understand why a little bit
later when you look at the code) object which represents a pending task. We will be looking at two of these, one
which accepts a Callable<T> and the other which accepts a good ol’ Runnable

Callable<T> is an interface just like Runnable so to submit a Callable<T> you need an object of a class which
implements that interface or create an object of an anonymous class. For the sake of keeping it all concise,
I am going to create objects of anonymous classes for both Callable and Runnable interfaces and override the
call() and run() respectively.

The idea is simple: make the threads print out a few values and add some delay in between. The Future<T> object
returned as a result of call to submit() is amazing. It allows you to do a lot of things like retrieve the value
 after computation has been done, cancel the task associated with it and see if the task is done.
 */
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Obtain a cached thread pool
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        // Create an anonymous Callable<T> object. You need to
        // override the call() method
        Callable<String> aCallable = new Callable<String>(){
            String message = "Callable is done !";
            @Override
            public String call() throws Exception {
                for(int i = 0; i < 10; i++){
                    System.out.println("Callable is doing something");
                    Thread.sleep(500); // make it sleep a little
                }
                return message;
            }
        };

        // Create an anonymous instance of Runnable
        Runnable aRunnable = new Runnable(){
            @Override
            public void run() {
                try{
                    for(int i = 0; i < 10; i++){
                        System.out.println("\tRunnable is doing something");
                        Thread.sleep(1000);
                    }
                }catch(Exception e){

                }
            }
        };

        // Time to run these
        // Future<> gets parameterized based on how Callable is parameterized
        // Since Runnable is not parameterized, you get a Future <?>
        Future<String> callableFuture = cachedPool.submit(aCallable);
        Future<?> runnableFuture = cachedPool.submit(aRunnable);

        // check if tasks are done or not
        if(callableFuture.isDone()){
            System.out.println("\t\tCallable is done !");
        }else{
            System.out.println("\t\tCallable is not done !");
        }

        if(runnableFuture.isDone()){
            System.out.println("\t\tRunnable is done !");
        }else{
            System.out.println("\t\tRunnable is not done !");
        }

        try {
            // get() waits for the task to finish and then gets the result
            String returnedValue = callableFuture.get();
            System.out.println(returnedValue);
        } catch (InterruptedException e) {
            // thrown if task was interrupted before completion
            e.printStackTrace();
        } catch (ExecutionException e) {
            // thrown if the task threw an execption while executing
            e.printStackTrace();
        }

        cachedPool.shutdown(); // shutdown the pool.
    }
}
