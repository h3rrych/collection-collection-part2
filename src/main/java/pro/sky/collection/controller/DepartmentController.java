package pro.sky.collection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collection.model.Employee;
import pro.sky.collection.service.DepartmentService;

import java.util.Optional;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int dep) {
        return service.findEmployeeWithMaxSalaryInDepartment(dep);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int dep) {
        return service.findEmployeeWithMinSalaryInDepartment(dep);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllByDep(@RequestParam(required = false) Integer dep) {
        return dep == null ?
                ResponseEntity.ok(service.getAll())
                :
                ResponseEntity.ok(service.getAllDepartment(dep));
    }
}
