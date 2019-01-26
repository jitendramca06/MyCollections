package com.questions.java.comparablecomparator;

import java.util.Arrays;

/**
 * Created by jitendra on 13 Mar, 2018
 */

/*
Comparable vs Comparator

Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to
provide different ways of sorting.
For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any
change in the class.
Comparable interface is in java.lang package whereas Comparator interface is present in java.util package.
We don’t need to make any code changes at client side for using Comparable, Arrays.sort() or Collection.sort()
methods automatically uses the compareTo() method of the class. For Comparator, client needs to provide the
Comparator class to use in compare() method.

Comparable:
Whenever we want to store only homogeneous elements and default natural sorting order required, we can go
for class implementing  comparable interface.

Comparator:
Whenever we want to store homogeneous and heterogeneous elements and we want to sort in default customized
sorting order, we can go for comparator interface.

Implementing Comparable means "I can compare myself with another object." This is typically useful when
there's a single natural default comparison.

Implementing Comparator means "I can compare two other objects." This is typically useful when there are
multiple ways of comparing two instances of a type - e.g. you could compare people by age, name etc.
 */
public class JavaObjectSorting {
    /**
     * This class shows how to sort custom objects array/list
     * implementing Comparable and Comparator interfaces
     * @param args
     */
    public static void main(String[] args) {

        //sorting custom object array
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Sample", 32, 50000);

        //sorting employees array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n"+ Arrays.toString(empArr));

        //sort employees array using Comparator by Salary
        Arrays.sort(empArr, Employee.SalaryComparator);
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

        //sort employees array using Comparator by Age
        Arrays.sort(empArr, Employee.AgeComparator);
        System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));

        //sort employees array using Comparator by Name
        Arrays.sort(empArr, Employee.NameComparator);
        System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));

        //Employees list sorted by ID and then name using Comparator class
        empArr[0] = new Employee(1, "Mikey", 25, 10000);
        Arrays.sort(empArr, new EmployeeComparatorByIdAndName());
        System.out.println("Employees list sorted by ID and Name:\n"+Arrays.toString(empArr));
    }
}
