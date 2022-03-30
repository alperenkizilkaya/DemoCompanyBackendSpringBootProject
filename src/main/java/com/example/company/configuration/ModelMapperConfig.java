package com.example.company.configuration;

import com.example.company.dto.EmployeeRequest;
import com.example.company.dto.EmployeeResponse;
import com.example.company.dto.UpdateEmployeeRequest;
import com.example.company.model.Employee;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig{

    private static final Converter<EmployeeRequest,Employee> EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER =
            context -> {
                var emp = new Employee();
                emp.setFirstName(context.getSource().getFirstName());
                emp.setSurname(context.getSource().getSurname());
                emp.setMail(context.getSource().getMail());
                emp.setPassword(context.getSource().getPassword());
                emp.setDepartment(context.getSource().getDepartment());
                emp.setSalary(context.getSource().getSalary());
                        /*context.getSource().getId(),
                        context.getSource().getFirstName(),
                        context.getSource().getSurname(),
                        context.getSource().getMail(),
                        context.getSource().getPassword(),
                        context.getSource().getDepartment(),
                        context.getSource().getSalary());*/
                return emp;
            };
    private static final Converter<Employee, EmployeeResponse> EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER =
                    context -> {
                        var response = new EmployeeResponse();
                        response.setFirstName(context.getSource().getFirstName());
                        response.setSurname(context.getSource().getSurname());
                        response.setMail(context.getSource().getMail());
                        response.setPassword(context.getSource().getPassword());
                        response.setDepartment(context.getSource().getDepartment());
                        response.setSalary(context.getSource().getSalary());
                        return response;
                    };
    private static final Converter<UpdateEmployeeRequest,Employee> UPDATE_EMPLOYEE_REQUEST_EMPLOYEE_CONVERTER =
            context -> {
                var emp = new Employee();
                emp.setFirstName(context.getSource().getFirstName());
                emp.setSurname(context.getSource().getSurname());
                emp.setMail(context.getSource().getMail());
                emp.setPassword(context.getSource().getPassword());
                emp.setDepartment(context.getSource().getDepartment());
                emp.setSalary(context.getSource().getSalary());
                        /*context.getSource().getId(),
                        context.getSource().getFirstName(),
                        context.getSource().getSurname(),
                        context.getSource().getMail(),
                        context.getSource().getPassword(),
                        context.getSource().getDepartment(),
                        context.getSource().getSalary());*/
                return emp;
            };


    @Bean
    ModelMapper createModelMapper(){
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(EMPLOYEE_REQUEST_TO_EMPLOYEE_CONVERTER, EmployeeRequest.class, Employee.class);
        modelMapper.addConverter(EMPLOYEE_TO_EMPLOYEE_RESPONSE_CONVERTER, Employee.class, EmployeeResponse.class);
        modelMapper.addConverter(UPDATE_EMPLOYEE_REQUEST_EMPLOYEE_CONVERTER,UpdateEmployeeRequest.class,Employee.class);
        return modelMapper;
    }
}
