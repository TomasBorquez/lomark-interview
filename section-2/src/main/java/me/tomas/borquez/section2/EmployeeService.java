package me.tomas.borquez.section2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private long idCounter = 0;

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(idCounter);
        employees.add(employee);
        idCounter++;
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }
}

