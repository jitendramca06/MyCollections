package com.questions.java.constructor;

/**
 * @author Jitendra Kumar : 2/2/19
 *
 * When constructor throw exception then no any object is created
 */
public class Employee {
   int a;

   public Employee() throws Exception {
       throw new Exception("exception from constructor.");
   }

    public static void main(String[] args) {
        Employee employee = null;
        try {
            employee  = new Employee();
        } catch (Exception e) {
        }
        System.out.println(employee.a);
    }
}
