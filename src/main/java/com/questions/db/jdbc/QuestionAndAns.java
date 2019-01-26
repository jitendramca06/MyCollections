package com.questions.db.jdbc;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Jitendra Kumar : 13/9/18
 */
public class QuestionAndAns {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
    public static void insertIntoEmp(int id, String firstName, String lastName, double salary, String joiningDate, String department) {
        String query = "insert into Employee (employee_id, first_name, last_name, salary, joining_date, department)" +
                " values (?,?,?,?,?,?)";
        try (Connection connection = MySQLUtils.getConnection1();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDouble(4, salary);
            java.util.Date utilDate = simpleDateFormat.parse(joiningDate);
            Date sqlDate = new Date(utilDate.getTime());
            preparedStatement.setDate(5, sqlDate);
            preparedStatement.setString(6, department);
            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoIncentive(int ref_id, String incentiveDate, double incentive) {
        String query = "insert into Incentives (employee_ref_id, incentive_date, incentive_amount)" +
                " values (?,?,?)";
        try (Connection connection = MySQLUtils.getConnection1();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, ref_id);
            java.util.Date utilDate = simpleDateFormat.parse(incentiveDate);
            Date sqlDate = new Date(utilDate.getTime());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setDouble(3, incentive);
            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all employee
     */
    public static void getAllEmployee() {
        String sql = "select * from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get only first and last name from table
     */
    public static void getFAndLName() {
        String sql = "select first_name, last_name from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get first and last name using alias
     */
    public static void getFAndLNameUsingAlias() {
        String sql = "select first_name as First_Name, last_name as Last_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.print(resultSet.getString("Last_Name") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get first name in upper case
     */
    public static void getFNameInUpper() {
        String sql = "select upper(first_name) as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {

        }
    }

    /**
     * Get first name in lower
     */
    public static void getFNameInLower() {
        String sql = "select lower(first_name) as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {

        }
    }

    /**
     * get unique department from employee table, which have multiple department name
     */
    public static void getUniqueDepartment() {
        String sql = "select distinct department from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get first three char from employee first name
     */
    public static void selectFirstThreeCharFromFName() {
        String sql = "select substring(first_name,1,3) as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get position of 'o' in first name 'John' from employee table
     */
    public static void getPositionOfCharFromAGivenName() {
        String sql = "select locate('o', first_name) as First_Name from Employee where first_name = 'Johan';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Get FIRST_NAME from employee table after removing white spaces from right side
     */
    public static void getFirstNameRemoveSpaceFromRight() {
        String sql = "select rtrim(first_name) as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get FIRST_NAME from employee table after removing white spaces from left side
     */
    public static void getFirstNameRemoveSpaceFromLeft() {
        String sql = "select ltrim(first_name) as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get length of FIRST_NAME from employee table
     */
    public static void getLengthOfFName() {
        String sql = "select length(first_name) as Length from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("Length") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get First_Name from employee table after replacing 'o' with '$'
     */
    public static void replaceAGivenChar() {
        String sql = "select replace(first_name, 'o', '$') as First_Name from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("First_Name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get First_Name and Last_Name as single column from employee table separated by a '_'
     */
    public static void getFAndLNameAsSingleCol() {
        String sql = "select concat(first_name,'_',last_name) as FullName from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("FullName") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get FIRST_NAME ,Joining year,Joining Month and Joining Date from employee table
     */
    public static void getFNameJoingYearMonDay() {
        String sql = "select first_name, year(joining_date) as JY, month(joining_date) as JM, day(joining_date) as JD from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("JY") + "\t");
                System.out.print(resultSet.getString("JM") + "\t");
                System.out.print(resultSet.getString("JD") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all employee details from the employee table order by First_Name Ascending
     */
    public static void getFNameInAscendingOrder() {
        String sql = "select first_name from Employee order by first_name asc;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all employee details from the employee table order by First_Name descending
     */
    public static void getFNameInDescendingOrder() {
        String sql = "select first_name from Employee order by first_name desc;";
        try(Connection connection = MySQLUtils.getConnection1();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all employee details from the employee table order by First_Name Ascending and Salary descending
     */
    public static void getFNameAscendingSalaryDescending() {
        String sql = "select first_name, salary from Employee order by first_name asc, salary desc;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details whose first name is 'johan'
     */
    public static void getEmployeeDetailsWhoseNameIsGiven() {
        String sql = "select * from Employee where first_name = 'Johan';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose employee name are “John” and “Roy”
     */
    public static void getEmployeeDetailsWithGivenNames() {
        String sql = "select * from Employee where first_name in ('Johan', 'Roy');";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose employee name are not “John” and “Roy”
     */
    public static void getEmployeeDetailsWithNotInGivenName() {
        String sql = "select * from Employee where first_name not in ('Johan', 'Roy');";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose first name starts with 'J'
     */
    public static void getEmployeeDetailsNameStartWithAChar() {
        String sql = "select * from Employee where first_name like 'J%';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose first name contains 'o'
     */
    public static void getEmployeeFNameContainsAChar() {
        String sql = "select * from Employee where first_name like '%o%';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose first name ends with 'n'
     */
    public static void getEmployeeNameEndWithAChar() {
        String sql = "select * from Employee where first_name like '%n';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose first name ends with 'n' and name contains 4 letters
     */
    public static void getEmployeeNameGivenCharEndWithAChar() {
        String sql = "select * from Employee where first_name like '____n';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose first name starts with 'J' and name contains 4 letters
     */
    public static void getEmployeeNameGivenCharStartWithAChar() {
        String sql = "select * from Employee where first_name like 'J____';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose Salary greater than 600000
     */
    public static void getEmployeeSalaryIsGrt() {
        String sql = "select * from Employee where salary > 600000;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose Salary less than 800000
     */
    public static void getEmployeeSalaryLess() {
        String sql = "select * from Employee where salary < 800000;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose Salary between 500000 and 800000
     */
    public static void getEmployeeSalaryBetween() {
        String sql = "select * from Employee where salary between 500000 and 800000;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose joining year is “2013”
     */
    public static void getEmployeeAccordingToJoiningYr() {
        String sql = "select * from Employee where year(joining_date) = 2013;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table whose joining month is “January”
     */
    public static void getEmployeeAccordingToJoiningMonth() {
        String sql = "select * from Employee where month(joining_date) = 01;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table who joined before January 1st 2013
     */
    public static void getEmployeeJoiningDateBefore() {
        String sql = "select * from Employee where joining_date < '2013-01-01';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get employee details from employee table who joined after January 31st
     */
    public static void getEmployeeJoiningDateAfter() {
        String sql = "select * from Employee where joining_date > '2013-01-01';";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Joining Date and Time from employee table
     */
    public static void getJoiningDateTime() {
        String sql = "select convert(date_format(joining_date, '%Y-%m-%d-%H:%i:00'),datetime) as JDate from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("JDate") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Joining Date,Time including milliseconds from employee table
     */
    public static void getJoiningDateInMilliSec() {
        String sql = "select microsecond(joining_date) as JDate from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("JDate") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get difference between JOINING_DATE and INCENTIVE_DATE from employee and incentives table
     */
    public static void getDateTimeDiff() {
        String sql = "select first_name, incentive_date-joining_date as DDiff from Employee as e inner join Incentives as i on e.employee_id = i.employee_ref_id;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("DDiff") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get DB Time
     */
    public static void getDBTime() {
        String sql = "select now() as DbTime;";
        try(Connection connection =MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("DbTime") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get names of employees from employee table who has '%' in Last_Name. Tip : Escape character for special characters in a query.
     */
    public static void getEmployeeWithGivenSpecialChar() {
        String sql = "select * from Employee where last_name like '%\\%%';";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Last Name from employee table after replacing special character with white space
     */
    public static void GetEmployeeAfterReplace() {
        String sql = "select replace(last_name,'%',' ') as LName from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("LName") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department,total salary with respect to a department from employee table.
     */
    public static void getDepartmentByTotalSalary() {
        String sql = "select department, sum(salary) as totalS from Employee group by department;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("totalS") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department,total salary with respect to a department from employee table order by total salary descending
     */
    public static void getDepartmentBySalaryOrderBy() {
        String sql = "select department, sum(salary) as TotalS from Employee group by department order by TotalS desc;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
           while (resultSet.next()) {
               System.out.print(resultSet.getString("department") + "\t");
               System.out.print(resultSet.getString("totalS") + "\t");
               System.out.println();
           }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department,no of employees in a department,total salary with respect to a department from employee table order by total salary descending
     */
    public static void getDepartmentTotalSalaryTotalEmployee() {
        String sql = "select department, sum(salary) as totalS, count(first_name) as totalE from Employee group by department;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("totalS") + "\t");
                System.out.print(resultSet.getString("totalE") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department wise average salary from employee table order by salary ascending
     */
    public static void getDepartmentByAvgSalary() {
        String sql = "select department, avg(salary) as aSalary from Employee group by department order by aSalary desc;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("aSalary") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department wise maximum salary from employee table order by salary ascending
     */
    public static void getDepartmentByMaxSalary() {
        String sql = "select department, max(salary) as mSalary from Employee group by department order by mSalary;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("mSalary") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get department wise minimum salary from employee table order by salary ascending
     */
    public static void getDepartmentByMinSalary() {
        String sql = "select department, min(salary) as mSalary from Employee group by department order by mSalary;";
        try(Connection connection = MySQLUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("mSalary") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select no of employees joined with respect to year and month from employee table
     */
    public static void getTotalEmployeeJoinWithYearMonth() {
        String sql = "select year(joining_date) as JYear, month(joining_date) as JMonth, count(*) as TotalE from Employee group by JYear, JMonth;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("JYear") + "\t");
                System.out.print(resultSet.getString("JMonth") + "\t");
                System.out.print(resultSet.getString("TotalE") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select department,total salary with respect to a department from employee table where total salary greater than 800000 order by Total_Salary descending
     */
    public static void getDepartmentTotalSalWithCondition() {
        String sql = "select department, sum(salary) as TotalS from Employee group by department having TotalS > 800000 order by TotalS desc;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("TotalS") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select employee details from employee table if data exists in incentive table ?
     */
    public static void getEmployeeWhichHaveDataInOtherTable() {
        String sql = "select * from Employee where exists (select * from Incentives);";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * How to fetch data that are common in two query results ?
     * select * from EMPLOYEE where EMPLOYEE_ID INTERSECT select * from EMPLOYEE where EMPLOYEE_ID < 4
     *
     * Get Employee ID's of those employees who didn't receive incentives without using sub query ?
     * select Employee.employee_id from Employee left join Incentives on Employee.employee_id != Incentives.employee_ref_id;
     */
    public static void getCommonDataFromTable() {
        String sql = "select * from Employee where employee_id intersect select * from Employee where employee_id < 4;";
    }

    /**
     * Get Employee ID's of those employees who didn't receive incentives without using sub query ?
     */
    public static void getEmployeeWhoDoNotReceiveInce() {
        String sql = "select * from Employee where employee_id not in (select employee_ref_id from Incentives);";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete employee data from employee table who got incentives in incentive table
     */
    public static void deleteEmployeeWhoTakeIncentive() {
        String sql = "delete from Employee where employee_id in (select employee_ref_id from Incentives);";
    }

    /**
     * Insert into employee table Last Name with " ' " (Single Quote - Special Character)
     */
    public static void insertLastNameWithSpecialChar() {
        String sql = "Insert into employee (LAST_NAME) values ('Test''')";
    }

    /**
     * Select Last Name from employee table which contain only numbers
     */
    public static void selectEmployeeWhoseLastNameInNumberOnly() {
        String sql = "select * from Employee where upper(last_name)=lower(last_name);";
    }

    /**
     * Select first_name, incentive amount from employee and incentives table for those employees who have incentives
     */
    public static void getEmployeeWhoGetIncentive() {
        String sql = "select first_name, incentive_amount from Employee inner join Incentives on Employee.employee_id=Incentives.employee_ref_id;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("incentive_amount") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select first_name, incentive amount from employee and incentives table for those employees who have incentives and incentive amount greater than 3000
     */
    public static void getEmployeeWhoGetIncentiveWithCondition() {
        String sql = "select first_name, incentive_amount from Employee inner join Incentives on Employee.employee_id=Incentives.employee_ref_id and Incentives.incentive_amount > 3000;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("incentive_amount") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select first_name, incentive amount from employee and incentives table for all employes even if they didn't get incentives
     */
    public static void getEmployeeWithOrWithoutIncentives() {
        String sql = "select first_name, incentive_amount from Employee left join Incentives on Employee.employee_id=Incentives.employee_ref_id;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("incentive_amount") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select first_name, incentive amount from employee and incentives table for all employees even if they didn't get incentives and
     * set incentive amount as 0 for those employees who didn't get incentives.
     */
    public static void getEmployeeDetailsWithoutIncentives() {
        String sql = "select first_name, ifnull(incentive_amount, 0) as Amount from Employee left join Incentives on Employee.employee_id=Incentives.employee_ref_id;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("Amount") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select first_name, incentive amount from employee and incentives table for all employees who got incentives using left join
     */
    public static void getEmployeeWhoGotIncentivesWithRightJoin() {
        String sql = "select first_name, incentive_amount from Employee right join Incentives on Employee.employee_id=Incentives.employee_ref_id;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("incentive_amount") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select max incentive with respect to employee from employee and incentives table using sub query
     */
    public static void getMaxIncentiveWithSubQuery() {
        String sql = "select department, (select ifnull(max(Incentives.incentive_amount), 0) from Incentives where Employee.employee_id=Incentives.employee_ref_id) as Amount from Employee;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("department") + "\t");
                System.out.print(resultSet.getString("Amount") + "\t");
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select TOP 2 salary from employee table
     * select * from employee order by salary desc limit N
     */
    public static void getTopNEmployeeWithSalary() {
        String sql = "select * from Employee order by salary desc limit 2;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("employee_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("salary") + "\t");
                System.out.print(resultSet.getString("joining_date") + "\t");
                System.out.print(resultSet.getString("department") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select 2nd Highest salary from employee table
     * select min(SALARY) from (select * from employee order by salary desc limit N) a
     */
    public static void getSecondHighestSalary() {
        String sql = "select min(salary) as Salary from (select * from Employee order by salary desc limit 2) as E;";
        try(Connection connection = MySQLUtils.getConnection1();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select First_Name,LAST_NAME from employee table as separate rows
     */
    public static void getEmployeeUsingUnion() {
        String sql = "select first_name from Employee union select last_name from Employee;";
        try(Connection connection = MySQLUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
