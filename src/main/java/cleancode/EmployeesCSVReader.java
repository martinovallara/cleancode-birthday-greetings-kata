package cleancode;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects; // Add this import statement
import java.io.FileReader;

public class EmployeesCSVReader implements EmployeesFeacther {
    private static final int EMAIL_ADDRESS_INDEX = 3;
    private static final int BIRTH_DATE_INDEX = 2;
    private static final int LAST_NAME_INDEX = 0;
    private static final int FIRST_NAME_INDEX = 1;
    private String fileName;

    public EmployeesCSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> fetchEmployeeRecords() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(fileName));) { // try-with-resources statement
            employees = in.lines()
                    .skip(1) // skip header
                    .map(line -> line.split(", "))
                    .map(this::parseEmployeeData)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private Employee parseEmployeeData(String[] data) {
        try {
            return new Employee(
                    data[FIRST_NAME_INDEX],
                    data[LAST_NAME_INDEX],
                    data[BIRTH_DATE_INDEX],
                    data[EMAIL_ADDRESS_INDEX]);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
