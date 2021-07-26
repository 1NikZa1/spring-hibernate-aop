package org.example.mvc_hibernate.dao;

import org.example.mvc_hibernate.entity.Employee;

import java.util.List;

public interface BaseDAO<T>{
    List<Employee> getAllEmployees();

    void saveEmployee(T t);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
