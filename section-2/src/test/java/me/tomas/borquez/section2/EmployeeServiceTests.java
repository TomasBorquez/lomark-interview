package me.tomas.borquez.section2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTests {
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService();
    }

    @Test
    void testGetAllEmployees() {
        Employee emp1 = new Employee(0L, "Tomas Borquez", "Developer", 1500.0);
        Employee emp2 = new Employee(1L, "Tomas Borquez", "Designer", 2000.0);
        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertTrue(result.contains(emp1));
        assertTrue(result.contains(emp2));
    }

    @Test
    void testGetEmployeeById_ExistingEmployee() {
        Employee emp = new Employee(null, "John Doe", "Developer", 1000.0);
        Employee addedEmp = employeeService.addEmployee(emp);

        Employee result = employeeService.getEmployeeById(addedEmp.getId());

        assertNotNull(result);
        assertEquals(addedEmp.getId(), result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("Developer", result.getDesignation());
    }

    @Test
    void testGetEmployeeById_NonExistingEmployee() {
        Long nonExistingId = 999L;

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.getEmployeeById(nonExistingId);
        });
    }
}
