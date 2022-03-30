package com.example.company.dto;

import com.example.company.model.Department;

import java.util.Objects;

public class EmployeeResponse {

    private String firstName;
    private String surname;
    private String mail;
    private String password;
    private Department department;
    private double salary;

    public EmployeeResponse() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResponse that = (EmployeeResponse) o;
        return Double.compare(that.salary, salary) == 0 && Objects.equals(firstName, that.firstName) && Objects.equals(surname, that.surname) && Objects.equals(mail, that.mail) && Objects.equals(password, that.password) && department == that.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, mail, password, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
