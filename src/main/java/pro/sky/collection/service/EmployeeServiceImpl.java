package pro.sky.collection.service;

import org.springframework.stereotype.Service;
import pro.sky.collection.exception.EmployeeAlreadyAddedExceprion;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.model.Employee;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullname())) {
            throw new EmployeeAlreadyAddedExceprion("Такой сотрудник уже существует");
        }
        employees.put(employee.getFullname(),employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullname())) {
            return employees.remove(employee.getFullname());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName,department, salary);
        if (employees.containsKey(employee.getFullname())) {
            return employees.get(employee.getFullname());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }
}
