package com.example.company.service;

import com.example.company.dto.EmployeeRequest;
import com.example.company.dto.EmployeeResponse;
import com.example.company.dto.UpdateEmployeeRequest;
import com.example.company.dto.UpdateEmployeeResponse;
import com.example.company.exception.EmployeeNotFoundException;
import com.example.company.model.Employee;
import com.example.company.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest req) {
        var employee = modelMapper.map(req, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) throws EmployeeNotFoundException {
        var emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
            EmployeeResponse response = modelMapper.map(emp.get(), EmployeeResponse.class);
            return response;
        }
        throw new EmployeeNotFoundException("employee not found with id : " + id);
    }

    @Override
    public EmployeeResponse removeEmployee(Long id) throws EmployeeNotFoundException {
        var employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return modelMapper.map(employee.get(),EmployeeResponse.class);
        }
        throw new EmployeeNotFoundException("employee not found with id: " + id);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        var employees = employeeRepository.findAll().stream()
                            .map( emp -> modelMapper.map(emp,EmployeeResponse.class))
                            .toList();
        return employees;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(Long id, UpdateEmployeeRequest req) throws EmployeeNotFoundException {

        if(employeeRepository.existsById(id)){
            var emp = employeeRepository.findById(id);
            emp.get().setFirstName(req.getFirstName()!=null? req.getFirstName() : emp.get().getFirstName());
            emp.get().setSurname(req.getSurname()!=null? req.getSurname() : emp.get().getSurname());
            emp.get().setMail(req.getMail()!=null? req.getMail() : emp.get().getMail());
            emp.get().setPassword(req.getPassword()!=null? req.getPassword() : emp.get().getPassword());
            emp.get().setDepartment(req.getDepartment()!=null? req.getDepartment() : emp.get().getDepartment());
            emp.get().setSalary(req.getSalary()!=0? req.getSalary() : emp.get().getSalary());

            var savedEmp = employeeRepository.save(emp.orElse(null));

            return modelMapper.map(savedEmp, UpdateEmployeeResponse.class);
        }
        throw new EmployeeNotFoundException("employee not found with id: " +id);
    }
}
