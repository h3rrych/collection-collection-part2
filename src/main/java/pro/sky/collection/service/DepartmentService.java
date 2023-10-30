package pro.sky.collection.service;

import pro.sky.collection.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllDepartment(int dep);

    public Map<Integer, List<Employee>> getAll();

   Employee findEmployeeWithMaxSalaryInDepartment(int dep);

   Employee findEmployeeWithMinSalaryInDepartment(int dep);
}
