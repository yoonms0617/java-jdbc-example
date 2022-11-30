import model.Employee;
import dao.EmployeeDAO;

import java.util.List;

public class JdbcExample {

    public static void main(String[] args) throws Exception{
        EmployeeDAO dao = new EmployeeDAO();

        System.out.println("=======================================");

        List<Employee> employees = dao.getEmployeeList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("Employee cnt = " + employees.size());
        System.out.println("=======================================");

        Long empNo = 7698L;
        Employee employeeByEmpNo = dao.findEmployeeByEmpNo(empNo);
        System.out.println(employeeByEmpNo);

        System.out.println("=======================================");

        String empName = "SCOTT";
        Employee employeeByName = dao.findEmployeeByName(empName);
        System.out.println(employeeByName);

        System.out.println("=======================================");

        Long delEmpNo = 7521L;
        dao.deleteEmployeeByEmpNo(delEmpNo);
    }

}
