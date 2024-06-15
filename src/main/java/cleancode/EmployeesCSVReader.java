package cleancode;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;



public class EmployeesCSVReader implements EmployeesFeacther{
    private String fileName;

    public EmployeesCSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> fetchEmployeeRecords()  {
        List<Employee> employees = new ArrayList<>();
    
        try (BufferedReader in =  new BufferedReader(new FileReader(fileName));) { // try-with-resources statement
            String str;
            str = in.readLine(); // skip header
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
                employees.add(employee);
            }
        } catch (IOException | java.text.ParseException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
