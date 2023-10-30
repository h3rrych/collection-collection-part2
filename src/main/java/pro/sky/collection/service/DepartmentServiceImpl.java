package pro.sky.collection.service;

import org.springframework.stereotype.Service;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public List<Employee> getAllDepartment(int dep) {
        return employeeServiceImpl.getMap().values()
                .stream()
                .filter(employee -> employee.getDepartment() == dep)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAll() {
        return employeeServiceImpl.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
@Override
    public Employee findEmployeeWithMaxSalaryInDepartment(int dep) {
    return employeeServiceImpl.findAll()
            .stream()
            .filter(e -> e.getDepartment() == dep)
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(EmployeeNotFoundException::new);
}
@Override
    public Employee findEmployeeWithMinSalaryInDepartment(int dep) {
    return employeeServiceImpl.findAll()
            .stream()
            .filter(e -> e.getDepartment() == dep)
            .min(Comparator.comparing(Employee::getSalary))
            .orElseThrow(EmployeeNotFoundException::new);
    }
}
