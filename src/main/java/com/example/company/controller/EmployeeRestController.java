package com.example.company.controller;

import com.example.company.dto.EmployeeRequest;
import com.example.company.dto.EmployeeResponse;
import com.example.company.dto.UpdateEmployeeRequest;
import com.example.company.dto.UpdateEmployeeResponse;
import com.example.company.exception.EmployeeNotFoundException;
import com.example.company.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    EmployeeResponse addEmployee(@RequestBody EmployeeRequest req){
        return employeeService.addEmployee(req);
    }

    @GetMapping("/{id}")
    EmployeeResponse getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    EmployeeResponse deleteEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.removeEmployee(id);
    }

    @GetMapping("/all")
    List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    UpdateEmployeeResponse updateEmployee(@PathVariable Long id,@RequestBody UpdateEmployeeRequest req) throws EmployeeNotFoundException {
        return employeeService.updateEmployee(id, req);
    }
}
