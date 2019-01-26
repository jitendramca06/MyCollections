package com.questions.db.jdbc;

import org.skife.jdbi.v2.Handle;
import java.util.List;
import java.util.Map;

/**
 * @author Jitendra Kumar : 12/9/18
 */
public class SampleApp {
    public static void main(String[] args) {

        Handle handle = MySQLConnectionManager.getInstance().getHandle().open();
        List<Map<String, Object>> employeeWithManager = handle.select("select a.name EmployeeName, (select b.name from Employee b where a.managerId = b.id) ManagerName from Employee a");
        employeeWithManager.forEach(System.out::println);

        List<Map<String, Object>> managerWithTotalEmployee = handle.select("select a.name, (select count(b.name) from Employee b where a.id = b.managerId) count from Employee a");
        managerWithTotalEmployee.forEach(System.out::println);
    }
}
