package pro.sky.collection.service;


import pro.sky.collection.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, double salary);
    Employee remove(String firstName, String lastName, int department, double salary);
    Employee find(String firstName, String lastName,int department, double salary);

    Collection<Employee> findAll();

    Map<String, Employee> getMap();
}
