package pro.sky.collection.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.collection.model.Employee;
import pro.sky.collection.service.EmployeeService;
import pro.sky.collection.service.EmployeeServiceImpl;

@Component

public class FillEmployess implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        employeeService.add("Test1", "Test1", 1, 10000);
        employeeService.add("Test2", "Test2", 2, 20000);
        employeeService.add("Test3", "Test3", 3, 30000);
        employeeService.add("Test4", "Test4", 1, 40000);
        employeeService.add("Test5", "Test5", 2, 50000);
        employeeService.add("Test6", "Test6", 3, 60000);
        employeeService.add("Test7", "Test7", 1, 70000);
    }
}
