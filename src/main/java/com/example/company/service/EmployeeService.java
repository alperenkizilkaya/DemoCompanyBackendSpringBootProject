package com.example.company.service;

import com.example.company.dto.EmployeeRequest;
import com.example.company.dto.EmployeeResponse;
import com.example.company.dto.UpdateEmployeeRequest;
import com.example.company.dto.UpdateEmployeeResponse;
import com.example.company.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    EmployeeResponse addEmployee(EmployeeRequest req);

    EmployeeResponse getEmployeeById(Long id) throws EmployeeNotFoundException;

    EmployeeResponse removeEmployee(Long id) throws EmployeeNotFoundException;

    List<EmployeeResponse> getAllEmployees();

    UpdateEmployeeResponse updateEmployee(Long id, UpdateEmployeeRequest req) throws EmployeeNotFoundException;
}
