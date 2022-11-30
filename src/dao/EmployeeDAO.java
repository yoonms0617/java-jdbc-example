package dao;

import model.Employee;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private final DBUtil dbUtil = new DBUtil();

    public List<Employee> getEmployeeList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        try {
            String query = "SELECT * FROM EMP";
            connection = dbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getLong("empno"),
                        resultSet.getString("ename"),
                        resultSet.getString("job"),
                        resultSet.getString("sal")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.disConnection(preparedStatement, resultSet, connection);
        }
        return employees;
    }

    public Employee findEmployeeByEmpNo(Long empNo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            String query = "SELECT * FROM EMP e WHERE e.EMPNO = ?";
            connection = dbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, empNo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(
                        resultSet.getLong("empno"),
                        resultSet.getString("ename"),
                        resultSet.getString("job"),
                        resultSet.getString("sal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.disConnection(preparedStatement, resultSet, connection);
        }
        return employee;
    }

    public Employee findEmployeeByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            String query = "SELECT * FROM EMP e WHERE e.ENAME = ?";
            connection = dbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(
                        resultSet.getLong("empno"),
                        resultSet.getString("ename"),
                        resultSet.getString("job"),
                        resultSet.getString("sal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.disConnection(preparedStatement, resultSet, connection);
        }
        return employee;
    }

    public void deleteEmployeeByEmpNo(Long empNo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "DELETE FROM EMP e WHERE e.EMPNO = ?";
            connection = dbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, empNo);
            int delete = preparedStatement.executeUpdate();
            if (delete == 1) {
                System.out.println("Delete Employee");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.disConnection(preparedStatement, connection);
        }
    }

}
